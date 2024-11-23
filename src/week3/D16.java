
import java.util.*;

public class D16 {
    static int n;
    static int[][] board;
    static int maxBlock = 0; 
    
    /**
     * D16
     * ✍️ Title : 2048 (Easy)
     * ⏰ Time : 40분 실패
     * 🤔 Approach : dfs와 재귀와 백트래킹을 생각. merge 구현 방법을 못떠올림
     * 🚬 Review : 우선 복잡하게 백트래킹하는 것보다 새로운 배열 반환이 더 간단하였음. 
     */ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        dfs(0, board);
        System.out.println(maxBlock);
    }
    
    
    static void dfs(int depth, int[][] curBoard) {
        if (depth == 5) { 
            maxBlock = Math.max(maxBlock, getMaxBlock(curBoard));
            return;
        }
        
        for (int dir = 0; dir < 4; dir++) { 
            int[][] newBoard = slide(dir, curBoard);
            dfs(depth + 1, newBoard);
        }
    }
    
    
    static int getMaxBlock(int[][] curBoard) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, curBoard[i][j]);
            }
        }
        return max;
    }
    
    
    static int[][] slide(int dir, int[][] board) {
        int[][] newBoard = new int[n][n];
        
        if (dir == 0) { 
            for (int col = 0; col < n; col++) {
                int[] newCol = merge(getColumn(board, col));
                setColumn(newBoard, col, newCol);
            }
        } else if (dir == 1) { 
            for (int col = 0; col < n; col++) {
                int[] newCol = reverseArr(merge(reverseArr(getColumn(board, col))));
                setColumn(newBoard, col, newCol);
            }
        } else if (dir == 2) { 
            for (int row = 0; row < n; row++) {
                int[] newRow = merge(board[row]);
                newBoard[row] = newRow;
            }
        } else if (dir == 3) { 
            for (int row = 0; row < n; row++) {
                int[] newRow = reverseArr(merge(reverseArr(board[row])));
                newBoard[row] = newRow;
            }
        }
        
        return newBoard;
    }
    
    
    static int[] merge(int[] line) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : line) {
            if (num != 0) queue.add(num);
        }
        
        int[] result = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!queue.isEmpty() && current == queue.peek()) {
                result[index++] = current * 2;
                queue.poll();
            } else {
                result[index++] = current;
            }
        }
        return result;
    }
    
    
    static int[] getColumn(int[][] board, int col) {
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = board[i][col];
        }
        return column;
    }
    
    
    static void setColumn(int[][] board, int col, int[] newCol) {
        for (int i = 0; i < n; i++) {
            board[i][col] = newCol[i];
        }
    }
    
    
    static int[] reverseArr(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}

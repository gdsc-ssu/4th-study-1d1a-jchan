import java.util.*;

public class D26 {
    public static void main(String[] args){
        solution();
    }
    
     /**
     * D26
     * ✍️ Title : 안전 영역
     * ⏰ Time : 21분 5초 성공
     * 🤔 Approach : 입력 값 범위보고 부르트포스가 가능함을 알앗음.
     * 🚬 Review : 그냥 구현
     */ 
    static int n;
    static int[][] board;
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0 ,-1};
    static int result = 0;
    static void solution(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        int maxVal = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
                maxVal = Math.max(maxVal, board[i][j]);
            }
        }
        for(int i = 0; i <= maxVal; i++){
            int res = countArea(board, i);
            result = Math.max(res, result);
        }
        
        System.out.println(result);
    }
    
    static int countArea(int[][] board, int rain){
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] > rain && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int t = 0; t < 4; t++){
                            int nx = cur[0] + dx[t];
                            int ny = cur[1] + dy[t];
                            if(isValid(nx, ny) && !visited[nx][ny] && board[nx][ny] > rain){
                                q.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
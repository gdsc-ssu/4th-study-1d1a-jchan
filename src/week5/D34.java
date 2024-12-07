import java.util.*;

public class D34 {
    static int[][] board;
    static int n, k, l;
    static List<int[]> snake; 
    static int[] dx = {0, 1, 0, -1}; 
    static int[] dy = {1, 0, -1, 0};

    /**
     * D34
     * ✍️ Title : 뱀
     * ⏰ Time : 40분 실패
     * 🤔 Approach : 뱀의 길이를 길이, 길-1, ... 1로 저장하고자 했음
     * 🚬 Review : 그냥 뱀을 큐로 관리하면 되는 거였음.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            board[x][y] = 1; 
        }

        l = sc.nextInt();
        Map<Integer, Character> directionChanges = new HashMap<>();
        for (int i = 0; i < l; i++) {
            int time = sc.nextInt();
            char direction = sc.next().charAt(0);
            directionChanges.put(time, direction);
        }

        
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0}); 
        int time = 0, direction = 0; 

        
        while (true) {
            time++;
            int[] head = snake.get(0); 
            int nx = head[0] + dx[direction];
            int ny = head[1] + dy[direction];

            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || isSnakeBody(nx, ny)) {
                break;
            }

            
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; 
                snake.add(0, new int[]{nx, ny});
            } else {
                
                snake.add(0, new int[]{nx, ny});
                snake.remove(snake.size() - 1);
            }

            
            if (directionChanges.containsKey(time)) {
                char turn = directionChanges.get(time);
                if (turn == 'L') {
                    direction = (direction + 3) % 4; 
                } else if (turn == 'D') {
                    direction = (direction + 1) % 4; 
                }
            }
        }

        
        System.out.println(time);
    }

    
    private static boolean isSnakeBody(int x, int y) {
        for (int[] part : snake) {
            if (part[0] == x && part[1] == y) {
                return true;
            }
        }
        return false;
    }
}

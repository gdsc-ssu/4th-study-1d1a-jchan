import java.util.*;

public class D36 {
    public static void main(String[] args) {
        solution();
    }   

    /**
     * D36
     * ✍️ Title : 유기농 배추
     * ⏰ Time : 17분 성공     
     * 🤔 Approach : BFS
     * 🚬 Review :
     */
    static int[][] farm;
    static boolean[][] visited;
    static int m, n, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void solution() {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            farm = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                farm[y][x] = 1; 
            }

            int worms = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); 
                        worms++; 
                    }
                }
            }
            
            System.out.println(worms);
        }
    }

    
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && farm[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}

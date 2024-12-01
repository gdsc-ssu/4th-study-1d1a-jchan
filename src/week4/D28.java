import java.util.*;

public class D28 {
    public static void main(String[] args) {
        solution();
    }

    static int[][] board;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = { 1, -1, 0, 0 }; 
    static int[] dy = { 0, 0, 1, -1 };
    /**
     * D28
     * ✍️ Title : 미로 탐색
     * ⏰ Time : 16분 성공
     * 🤔 Approach : 그냥 BFS 구현
     * 🚬 Review : 
     */ 
    static void solution() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        visited[x][y] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            cnt++;
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0]+ dx[j];
                    int ny = cur[1] + dy[j];
                    if(nx == n-1 && ny == m-1) {
                        return cnt+1;
                    }

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[] { nx, ny });
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return cnt;
    }
}

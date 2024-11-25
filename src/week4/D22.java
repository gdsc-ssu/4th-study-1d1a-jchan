import java.util.*;

public class D22 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    /**
     * D22
     * ✍️ Title : 단지번호붙이기
     * ⏰ Time : 21분 성공
     * 🤔 Approach : BFS
     * 🚬 Review : 부르트 포스 느낌이 났음
     */ 
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int count : list) {
            System.out.println(count);
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return count;
    }
}

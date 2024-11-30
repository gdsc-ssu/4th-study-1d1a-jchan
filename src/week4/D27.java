import java.util.*;

public class D27 {

    /**
     * D27
     * ✍️ Title : 상범 빌딩
     * ⏰ Time : 21분 55초 실패
     * 🤔 Approach : 그냥 BFS 구현. 하지만 계속 입력 에러가 났음.
     * 🚬 Review : nextInt, next, nextLine의 문제. nextInt를 하면 \n을 남겨 놓기때문에 sc.nextLine으로 클리어해주어야 했음. 백준 풀 때는 이런거 주의해야 할듯
     */ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (l == 0 && r == 0 && c == 0) break;

            sc.nextLine(); 
            char[][][] building = new char[l][r][c];
            int[] start = new int[3];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = sc.nextLine();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = line.charAt(k);
                        if (building[i][j][k] == 'S') {
                            start = new int[]{i, j, k};
                        }
                    }
                }
                if (i < l - 1) sc.nextLine(); 
            }

            String result = solution(building, start, l, r, c);
            System.out.println(result);
        }

        sc.close();
    }

    static String solution(char[][][] building, int[] start, int l, int r, int c) {
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        boolean[][][] visited = new boolean[l][r][c];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]][start[2]] = true;

        int minutes = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int x = current[0], y = current[1], z = current[2];

                if (building[x][y][z] == 'E') {
                    return "Escaped in " + minutes + " minute(s).";
                }

                for (int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];

                    if (isValid(nx, ny, nz, l, r, c) && !visited[nx][ny][nz] && building[nx][ny][nz] != '#') {
                        visited[nx][ny][nz] = true;
                        q.add(new int[]{nx, ny, nz});
                    }
                }
            }
            minutes++;
        }

        return "Trapped!";
    }

    static boolean isValid(int x, int y, int z, int l, int r, int c) {
        return x >= 0 && y >= 0 && z >= 0 && x < l && y < r && z < c;
    }
}

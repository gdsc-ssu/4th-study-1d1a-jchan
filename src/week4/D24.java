import java.util.*;

public class D24 {
    static int[][][] cube = new int[5][5][5];
    static int[][][] tempCube = new int[5][5][5];
    static boolean[][][] visited;
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution();
    }

    /**
     * D23
     * ✍️ Title : Maaaaaaaaaze
     * ⏰ Time : 20분 실패
     * 🤔 Approach : rotate까지는 구현 완료. 부르트포스라고 는 생각하였음. 하지만 순열 구하는게 떠오르지 않았음
     * 🚬 Review : swap을 저렇게 써도 되는지 몰랐음. 자바 컬렉션 API를 더 공부해야 할 것같음
     */ 
    static void solution() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    cube[i][j][k] = sc.nextInt();
                }
            }
        }
        
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);
        recur(list, 0);
        
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void recur(List<Integer> list, int depth) {
        if (depth == list.size()) {
            int[][][] newCube = new int[5][5][5];
            for (int i = 0; i < 5; i++) {
                newCube[i] = cube[list.get(i)];
            }
            dfsRotate(0, newCube);
            return;
        }

        // 순열 구하는 부분이 어려웠음 -> 외우기
        for (int i = depth; i < list.size(); i++) {
            Collections.swap(list, depth, i);
            recur(list, depth + 1);
            Collections.swap(list, depth, i);
        }
    }

    static void dfsRotate(int depth, int[][][] cube) {
        if (depth == 5) {
            for (int i = 0; i < 5; i++) {
                tempCube[i] = cube[i];
            }
            bfs(); 
            return;
        }

        for (int i = 0; i < 4; i++) {
            cube[depth] = rotate(cube[depth]);
            dfsRotate(depth + 1, cube);
        }
    }

    static int[][] rotate(int[][] layer) {
        int[][] newLayer = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newLayer[j][4 - i] = layer[i][j];
            }
        }
        return newLayer;
    }

    static void bfs() {
        visited = new boolean[5][5][5];
        if (tempCube[0][0][0] == 0 || tempCube[4][4][4] == 0) return;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0], y = current[1], z = current[2], steps = current[3];

            if (x == 4 && y == 4 && z == 4) {
                result = Math.min(result, steps);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < 5 && ny < 5 && nz < 5 && 
                    tempCube[nx][ny][nz] == 1 && !visited[nx][ny][nz]) {
                    visited[nx][ny][nz] = true;
                    q.add(new int[]{nx, ny, nz, steps + 1});
                }
            }
        }
    }
}

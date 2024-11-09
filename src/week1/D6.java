package week1;

import java.io.*;
import java.util.*;

public class D6 {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        solution();
    }

    /**
     * D6
     * ✍️ Title : 빙산
     * ⏰ Time : 40분 실패
     * 🤔 Approach : dfs와 재귀를 이용하고, minX, maxX 등을 이용하여 탐색 범위를 줄이고자 함 재귀는 새로운 보드를 다음 세대에 주어야 될거라고 생각해서.
     * 🚬 Review : 재귀에서 터졌음. minX는 빙산이 테두리에 있는 경우가 있을 수 있어 유효하지 않았음. 재귀는 최후의 수단으로 사용해야겠다고 생각이 들었음. 새로운 보드를 마지막에 보드에 업데이트치면 되는 거였음 
     */ 
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            visited = new boolean[n][m];
            int cnt = count빙산();

            if (cnt >= 2) {  
                System.out.println(years);
                return;
            } else if (cnt == 0) {  
                System.out.println(0);
                return;
            }

            녹이기();  
            years++;
        }
    }

    static int count빙산() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int cx = pos[0], cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }

    static void 녹이기() {
        int[][] newBoard = new int[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] > 0) {
                    int cnt = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                    newBoard[x][y] = cnt;  
                }
            }
        }

        
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                board[x][y] = Math.max(board[x][y] - newBoard[x][y], 0);
            }
        }
    }
}

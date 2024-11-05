package week1;

import java.io.*;
import java.util.*;

class Main {
    public static int[][] board1 = new int[101][101];
    public static int[][] board2 = new int[101][101];
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n;

    public static void main(String[] args) throws IOException {
        solution();
    }

    /**
     * D2
     * ✍️ Title : 적록색약
     * ⏰ Time : 20분
     * 🤔 Approach : 단순 dfs
     * 🚬 Review : 백준을 위해 BufferedReader 사용이 익숙하지 않았음
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char color = line.charAt(j);
                if (color == 'R') {
                    board1[i][j] = 1;
                    board2[i][j] = 1; 
                } else if (color == 'G') {
                    board1[i][j] = 2;
                    board2[i][j] = 1;
                } else {
                    board1[i][j] = 3;
                    board2[i][j] = 3;
                }
            }
        }

        int cnt = count(board1);
        int cnt2 = count(board2);

        System.out.println(cnt + " " + cnt2);
    }

    public static int count(int[][] board) {
        int regions = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) { 
                    dfs(board, i, j, board[i][j]);
                    regions++;
                }
            }
        }

        return regions;
    }

    
    public static void dfs(int[][] board, int x, int y, int color) {
        Stack<Coord> stack = new Stack<>();
        stack.push(new Coord(x, y));

        while (!stack.isEmpty()) {
            Coord coord = stack.pop();
            int cx = coord.x;
            int cy = coord.y;

            if (board[cx][cy] == color) {  
                board[cx][cy] = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];

                    if (valid(nx, ny) && board[nx][ny] == color) {
                        stack.push(new Coord(nx, ny));
                    }
                }
            }
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static class Coord {
        int x, y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
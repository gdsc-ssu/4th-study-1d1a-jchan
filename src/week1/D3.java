package week1;

import java.util.*;
import java.io.*;

public class D3 {
    static int m, n, h; 
    static int[][][] board = new int[101][101][101];
    static int[] dx = {0, 0, 1, -1, 0, 0}; 
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        solution();
    }

    /**
     * D3
     * ✍️ Title : 토마토
     * ⏰ Time : 27분 21초
     * 🤔 Approach : BFS이며 dy를 만들어 내었음. list를 while돌때마다 새로 만듦
     * 🚬 Review : 자바 컬렉션 api 암기가 필요했음. 500이라는 숫자보고 다 돌렀는데 성능이 느렸음
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); 
        n = Integer.parseInt(st.nextToken()); 
        h = Integer.parseInt(st.nextToken()); 

        ArrayList<Coord> 익은토마토s = new ArrayList<>(); 
        
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        익은토마토s.add(new Coord(i, j, k)); 
                    }
                }
            }
        }

        int days = bfs(익은토마토s); 
        System.out.println(days);
    }

    public static int bfs(ArrayList<Coord> 익은토마토s) {
        int dayCount = -1;
        while (!익은토마토s.isEmpty()) {
            ArrayList<Coord> nextRipe = new ArrayList<>(); 

            for (Coord coord : 익은토마토s) {
                for (int d = 0; d < 6; d++) {
                    int nx = coord.x + dx[d];
                    int ny = coord.y + dy[d];
                    int nz = coord.z + dz[d];
                    
                    
                    if (valid(nx, ny, nz) && board[nx][ny][nz] == 0) {
                        board[nx][ny][nz] = 1; 
                        nextRipe.add(new Coord(nx, ny, nz));
                    }
                }
            }

            익은토마토s = nextRipe; 
            dayCount++; 
        }

        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        return -1; 
                    }
                }
            }
        }

        return dayCount;
    }

    static class Coord {
        int x, y, z;

        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static boolean valid(int x, int y, int z) {
        return x >= 0 && x < h && y >= 0 && y < n && z >= 0 && z < m;
    }
}


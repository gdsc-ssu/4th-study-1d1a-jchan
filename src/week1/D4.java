package week1;

import java.util.*;
import java.io.*;

public class D4 {
    static int n, m; 
    static int[][] board; 
    static boolean[][][] visited; 
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    /**
     * D4
     * ✍️ Title : 벽부수고 이동하기
     * ⏰ Time : 30분 실패
     * 🤔 Approach : BFS를 생각하고, 벽을 부수는 경우를 Coord에 넣는 것까지는 생각했음
     * 🚬 Review : visited를 삼중배열로 만들어야 된다는것은 생각도 못함. 반례를 찾았어야 했음. 배열 하나일 경우, 벽을 깨는 경우가 최단 경로일 수 있는 벽을 아예 안깨는 경우의 길을 visited로 맏을 수 있었음. 이거는 경험으로 채워야 되는 영역같음
     */ 
    public static void main(String[] args) throws IOException {
        solution();
    }
    
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m][2]; 

        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        
        int cnt = bfs();
        System.out.println(cnt);
    }
    
    static int bfs() {
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(0, 0, 1, false)); 
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Coord ccd = q.poll();

            
            if (ccd.x == n - 1 && ccd.y == m - 1) {
                return ccd.dist;
            }

            
            for (int i = 0; i < 4; i++) {
                int nx = ccd.x + dx[i];
                int ny = ccd.y + dy[i];

                if (valid(nx, ny)) {
                    
                    if (board[nx][ny] == 0) {
                        if (!visited[nx][ny][ccd.remove ? 1 : 0]) {
                            visited[nx][ny][ccd.remove ? 1 : 0] = true;
                            q.add(new Coord(nx, ny, ccd.dist + 1, ccd.remove));
                        }
                    }
                    
                    else if (board[nx][ny] == 1 && !ccd.remove) {
                        
                        if (!visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            q.add(new Coord(nx, ny, ccd.dist + 1, true));
                        }
                    }
                }
            }
        }

        
        return -1;
    }

    
    static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    
    static class Coord {
        int x, y, dist;
        boolean remove; 

        public Coord(int x, int y, int dist, boolean remove) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.remove = remove;
        }
    }
}

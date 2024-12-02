package week5;

import java.util.*;

public class D29 {
    public static void main(String[] args){
        solution();
    }

     /**
     * D29
     * ✍️ Title : 영역 구하기
     * ⏰ Time : 21분 성공
     * 🤔 Approach : 그냥 BFS 구현
     * 🚬 Review : 실수해서 늦게 끝났음
     */ 
    static int result = 0;
    static int m,n;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static void solution(){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();
        board = new boolean[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < k; i++){
            int[] list = new int[4];
            for(int j = 0; j < 4; j++){
                list[j] = sc.nextInt();
            }

            for(int a = list[0]; a < list[2]; a++){
                for(int b = list[1]; b < list[3]; b++){
                    board[b][a] = true;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == false && !visited[i][j]) {
                    int cnt = dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(result);
        String line = "";
        for(int cnt:list){
            line += cnt + " ";
        }
        System.out.println(line);
    }

    static int dfs(int x, int y){
        int cnt = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});
        visited[x][y] = true;
        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            cnt++;
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && board[nx][ny] == false){
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        result++;
        return cnt;
    }
}
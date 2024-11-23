

import java.util.*;

public class D1 {

    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}
        Solution solution = new Solution();
        System.out.println(solution.solution(land));
    }
}

/**
 * D1
 * ✍️ Title : [PCCP 기출문제] 2번 / 석유 시추
 * ⏰ Time : 30분 실패 -> 자바 기본 문법 문제
 * 🤔 Approach : 500이라는 수를 보고 부르트 포스라고 생각. 순회를 하면서 값을 1차원 배열에 추가하는 식으로 접근
 * 🚬 Review : 오랜만에 풀어서 푸는 방법과 DFS 코드 작성이 떠오르지 않았다.
 */
class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] oilRow = new int[501];

    public int solution(int[][] land) {
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1) dfs(land, i, j);   
            }
        }
        Arrays.sort(oilRow);
        return oilRow[500];
    }

    private static void dfs(int[][] land, int i, int j){
        Stack<Coord> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        stack.push(new Coord(i, j));
        int cnt = 0;
        while(!stack.isEmpty()){
            Coord cur = stack.pop();
            int r = cur.r;
            int c = cur.c;
            if(land[r][c] == 0) continue;
            land[r][c] = 0;
            cnt++;
            set.add(c);
            for(int d = 0; d < 4; d++){
                int nr = r + dx[d];
                int nc = c + dy[d];
                if(valid(land, nr, nc) && land[nr][nc] == 1){
                    stack.push(new Coord(nr, nc));
                }
            }
        }

        for(int c : set){
            oilRow[c] += cnt;
        }
    }

    private static boolean valid(int[][] land, int i, int j){
        return i >= 0 && j >= 0 && i < land.length && j < land[0].length;
    }

    private static class Coord {
        private int r;
        private int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }        
    }
}
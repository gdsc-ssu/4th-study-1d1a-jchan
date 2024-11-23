
import java.util.*;

public class D17 {
    static int n, m;
    static List<int[]> 집s = new ArrayList<>();
    static List<int[]> 치킨집s = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    /**
     * D17
     * ✍️ Title : 치킨 배달
     * ⏰ Time : 34분 성공
     * 🤔 Approach : 재귀와 백트래킹 연습
     * 🚬 Review : 복잡하지는 않았지만 문법 실수가 계속 걸렸음 
     */ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) 집s.add(new int[]{i, j});
                if (board[i][j] == 2) 치킨집s.add(new int[]{i, j});
            }
        }
        
        recur(new ArrayList<>(), 0);

        System.out.println(result);
    }

    
    static void recur(List<int[]> selected, int start) {
        if (selected.size() == m) {
            result = Math.min(result, getMinDist(selected));
            return;
        }

        for (int i = start; i < 치킨집s.size(); i++) {
            selected.add(치킨집s.get(i));
            recur(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    
    static int getMinDist(List<int[]> selected) {
        int totalDistance = 0;

        for (int[] house : 집s) {
            int minDistance = Integer.MAX_VALUE;

            for (int[] chicken : selected) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }

            totalDistance += minDistance;
        }

        return totalDistance;
    }
}

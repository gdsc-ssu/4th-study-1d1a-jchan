import java.util.*;

public class D19 {
    public static void main(String[] args) {
        solution();
    }

    static int n;
    // 부르트 포스는 아님. 그리디도 반례가 있어 보임 -> DP
    static int[][] list;
    /**
     * D19
     * ✍️ Title : RGB거리
     * ⏰ Time : 34분 실패
     * 🤔 Approach : 부르트포스 등은 아닐것같다고 생각
     * 🚬 Review : DP가 성립되는지 확실하지 않았음.  
     */ 
    static void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n][3];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
            list[i][2] = sc.nextInt();
        }

        int[][] dp = new int[n][3];
        dp[0][0] = list[0][0];
        dp[0][1] = list[0][1];
        dp[0][2] = list[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = list[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]); 
            dp[i][1] = list[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]); 
            dp[i][2] = list[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]); 
        }

        result = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

        System.out.println(result);
    }
}

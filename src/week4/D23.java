import java.util.*;

public class D23 {
    public static void main(String[] args) {
        solution();
    }

    /**
     * D23
     * ✍️ Title : 이친수
     * ⏰ Time : 14분 12초 성공
     * 🤔 Approach : 처음에 경우의 수를 싹다 구해봄. 처음에는 n-1과 n-2더하면 되는줄알았음
     * 🚬 Review : 경우의 수를 나눌 생각을 했음. 이를 점화식으로 풀기가 쉽지 않았음
     */ 
    static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1 -> 1
        // 2 -> 10
        // 3 -> 100, 101
        // 4 -> 1000, 1001, 1010
        // 5 -> 10000, 10001, 10010, 10100, 10101
        // 6 -> 100000, 100001, 100010, 100100, 100101, 101000, 101001, 101010
        long[][] dp = new long[N + 1][2];

        // 마지막 자리가 0, 1
        dp[1][0] = 0; 
        dp[1][1] = 1; 

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; 
            dp[i][1] = dp[i - 1][0];               
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}

import java.util.Scanner;

public class D20 {
    /**
     * D20
     * ✍️ Title : 2×n 타일링
     * ⏰ Time : 44분 실패
     * 🤔 Approach : 1,2로 n만들기로 접근.
     * 🚬 Review : 오버플로우를 생각하지 못했음. 디버깅이 안되어서 못푼듯
     */ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        System.out.println(dp[n]);

    }
}
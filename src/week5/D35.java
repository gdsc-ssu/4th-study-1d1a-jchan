import java.util.*;

public class D35 {
    public static void main(String[] args) {
        solution();
    }
    
    /**
     * D35
     * ✍️ Title : 1로 만들기 2
     * ⏰ Time : 16분 성공     
     * 🤔 Approach : 처음에는 그리디로 풀었음. 
     * 🚬 Review :당장 /2가 아닌 -1을 하고 /3을 하는게 더 나은 것이 있었음. 따라서 DP
     */
    static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        int[] path = new int[n + 1];
        
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = n; i != 0; i = path[i]) {
            list.add(i);
        }

        System.out.println(dp[n]);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}

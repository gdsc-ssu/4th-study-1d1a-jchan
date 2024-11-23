

import java.util.*;

public class D12 {
    /**
     * D12
     * ✍️ Title : N과 M (7)
     * ⏰ Time : 18분 실패
     * 🤔 Approach : 재귀적으로 어떻게 프린트해야할 지 생각이 안났음
     * 🚬 Review : 이 쪽 풀이를 많이 풀어봐야 익숙해질듯
     */ 
    static int n, m;
    static int[] numbers;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int len) {
        if (len == m) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            result[len] = numbers[i];
            dfs(len + 1);
        }
    }
}

import java.util.*;

   
public class D35 {
    public static void main(String[] args) {
        solution();
    }

     /**
     * D35
     * ✍️ Title : 1로 만들기 2
     * ⏰ Time : 19분 성공     
     * 🤔 Approach : 처음에는 그리디로 풀었음. 
     * 🚬 Review :당장 /2가 아닌 -1을 하고 /3을 하는게 더 나은 것이 있었음. 따라서 DP
     */
    static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] memo = new int[n + 1];
        int[] list = new int[n + 1];

        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[n] = 0;

        for (int i = n; i > 0; i--) {
            if (i % 3 == 0 && memo[i / 3] > memo[i] + 1) {
                memo[i / 3] = memo[i] + 1;
                list[i / 3] = i;
            }
            if (i % 2 == 0 && memo[i / 2] > memo[i] + 1) {
                memo[i / 2] = memo[i] + 1;
                list[i / 2] = i;
            }
            if (memo[i - 1] > memo[i] + 1) {
                memo[i - 1] = memo[i] + 1;
                list[i - 1] = i;
            }
        }

        System.out.println(memo[1]);

        List<Integer> res = new ArrayList<>();
        int cur = 1;
        while (cur != 0) {
            res.add(cur);
            cur = list[cur];
        }
        Collections.reverse(res);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}

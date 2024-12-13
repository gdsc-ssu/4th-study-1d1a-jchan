import java.util.*;

public class D39 {
    public static void main(String[] args) {
        solution();
    }

    /**
     * D39
     * ✍️ Title : 수 정렬하기 2
     * ⏰ Time : 
     * 🤔 Approach : 
     * 🚬 Review : 많은 양의 출력 처리는 StringBuffer를 이용하여 한번에 처리하는 것이 좋았음. 여기서 시간초과가 발생
     */
    static void solution() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        for (int num : numbers) {
            sb.append(num).append("\n");
        }

        System.out.print(sb.toString());
    }
}

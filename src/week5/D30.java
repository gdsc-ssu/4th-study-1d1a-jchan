import java.util.*;

public class D30 {
    public static void main(String[] args) {
        solution();
    }

    /**
     * D30
     * ✍️ Title : 윷놓이
     * ⏰ Time : 9분 성공
     * 🤔 Approach : 그냥  구현
     * 🚬 Review : 
     */ 
    static void solution() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) { 
            int[] 윳 = new int[4];
            for (int j = 0; j < 4; j++) {
                윳[j] = scanner.nextInt();
            }
            System.out.println(func(윳));
        }
    }

    static String func(int[] 윳) {
        int cnt = 0; 
        for (int num : 윳) {
            if (num == 0) cnt++;
        }

        if (cnt == 1) return "A";
        if (cnt == 2) return "B";
        if (cnt == 3) return "C";
        if (cnt == 4) return "D";
        return "E";
    }
}

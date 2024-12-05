import java.util.*;

public class D32 {
    public static void main(String[] args) {
        solution();
    }

    /**
     * D32
     * ✍️ Title : 카드 역배치
     * ⏰ Time : 10분 성공
     * 🤔 Approach : 
     * 🚬 Review : 
     */ 
    static void solution() {
        Scanner sc = new Scanner(System.in);
        
        int[] cards = new int[20];
        for (int i = 0; i < 20; i++) {
            cards[i] = i + 1;
        }

        for (int i = 0; i < 10; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            
            reverse(cards, s - 1, e - 1);
        }

        for (int card : cards) {
            System.out.print(card + " ");
        }
    }

    static void reverse(int[] cards, int s, int e) {
        while (s < e) {
            int temp = cards[s];
            cards[s] = cards[e];
            cards[e] = temp;
            s++;
            e--;
        }
    }
}

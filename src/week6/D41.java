import java.util.*;

public class D41 {
    public static void main(String[] args) {
        solution();
    }

    /**
     * D41
     * ✍️ Title : 시리얼 번호
     * ⏰ Time : 
     * 🤔 Approach : 
     * 🚬 Review : Comparator 연습
     */
    static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLine();
        }
        
        Arrays.sort(arr, Comparator.comparingInt(String::length)
            .thenComparing(D41::getNumSum)
            .thenComparing(Comparator.naturalOrder()));
            
        for(String s : arr){
            System.out.println(s);
        }
    }

    static int getNumSum(String s) {
        int sum = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                sum += c - '0';
            }
        }
        return sum;
    }
}
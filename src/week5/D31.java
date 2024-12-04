import java.util.*;

public class D31{
    public static void main(String[] args){
        solution();
    }
    /**
     * D31
     * ✍️ Title : 숫자
     * ⏰ Time : 10분 성공
     * 🤔 Approach : 그냥  구현. 큰 수보고 long 떠올리기
     * 🚬 Review : 
     */ 
    static void solution(){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long cnt = Math.abs(b - a);
        if(cnt == 0 || cnt == 1) {
            System.out.println(0);
            return;
        }
        System.out.println(cnt - 1);
        long tmp;
        if(a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        for(long i = a + 1l; i < b; i++){
            System.out.print(i + " ");
        }
    }
}
import java.util.*;

public class D21 {
    public static void main(String[] args){
        solution();
    }
    
    static int n, m;
    static int[] memo;
    /**
     * D21
     * ✍️ Title : 구간 합 구하기 4
     * ⏰ Time : 15분 성공
     * 🤔 Approach : DP로 생각이 들었음. 유명한 문제.
     * 🚬 Review : 
     */ 
    static void solution(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        memo = new int[n + 1];
        memo[1] = sc.nextInt();
        for(int i = 2; i <= n; i++){
            memo[i] = sc.nextInt() + memo[i - 1];
        }
        
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            func(s, e);
        }
    }
    
    static void func(int s, int e){
        int result =  memo[e] - memo[s - 1];
        System.out.println(result);
    }
}
import java.util.*;

public class D33 {
    public static void main(String[] args){
        solution();
    }
    
    /**
     * D33
     * ✍️ Title : 재귀함수가 뭔가요?
     * ⏰ Time : 16분 성공
     * 🤔 Approach : 
     * 🚬 Review : 
     */ 
    static int n;
    static void solution(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(n);
    }
    
    static void recur(int cnt){
        if(cnt < 0) return; 
        String line = "____".repeat(n - cnt); 
        String str = line + "\"재귀함수가 뭔가요?\"\n";
        
        if(cnt == 0) {
            str += line + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
            System.out.print(str);
            System.out.println(line + "라고 답변하였지.");
            return;
        }
        
        str += line + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        str += line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        str += line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        System.out.print(str);
        
        recur(cnt-1);
        
        System.out.println(line + "라고 답변하였지.");
    }
}

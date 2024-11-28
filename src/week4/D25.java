import java.util.*;

public class D25 {
    public static void main(String[] args) {
        solution();
    }

    static int f, g, s, u, d;
    static boolean[] visited;

    /**
     * D24
     * ✍️ Title : 스타트링크
     * ⏰ Time : 15분 성공
     * 🤔 Approach : -1을 보고 완탐을 고려. 처음에는 숫자보고 DP나 정렬을 생각했음.
     * 🚬 Review : 
     */ 
    static void solution() {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt(); 
        s = sc.nextInt(); 
        g = sc.nextInt(); 
        u = sc.nextInt(); 
        d = sc.nextInt(); 
        
        visited = new boolean[f + 1]; 
        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0}); 
        visited[s] = true; 

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curVal = cur[0];
            int curCnt = cur[1];

            
            if (curVal == g) {
                System.out.println(curCnt);
                return;
            }

            if (curVal + u <= f && !visited[curVal + u]) {
                visited[curVal + u] = true;
                q.add(new int[]{curVal + u, curCnt + 1});
            }
            
            if (curVal - d >= 1 && !visited[curVal - d]) {
                visited[curVal - d] = true;
                q.add(new int[]{curVal - d, curCnt + 1});
            }
        }

        
        System.out.println("use the stairs");
    }
}

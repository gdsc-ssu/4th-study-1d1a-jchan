package week1;

import java.util.*;
import java.io.*;

public class D5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];  
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(arr, n));
        }
    }

    /**
     * D5
     * ✍️ Title : 텀 프로젝트
     * ⏰ Time : 25분 실패
     * 🤔 Approach : for문을 돌리며 작업을 해볼까 했음. 하지만 2중 for문 밖에 생각을 못함
     * 🚬 Review : 다시 봐야 될 듯
     */ 
    static int solution(int[] arr, int n){
        boolean[] visited = new boolean[n + 1];   
        boolean[] finished = new boolean[n + 1];  
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            if(!visited[i]){   
                cnt += dfs(i, arr, visited, finished);
            }
        }
        return n - cnt;
    }

    static int dfs(int current, int[] arr, boolean[] visited, boolean[] finished){
        visited[current] = true;    
        int next = arr[current];    
        int cycleCount = 0;

        if(!visited[next]){         
            cycleCount += dfs(next, arr, visited, finished);
        } else if(!finished[next]){ 
            int temp = next;
            cycleCount++;  
            
            while(temp != current){
                cycleCount++;
                temp = arr[temp];
            }
        }

        finished[current] = true;  
        return cycleCount;
    }
}

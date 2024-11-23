

import java.util.*;
import java.io.*;

public class D13 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static int n, m;
    static int[] arr = new int [10000];
    static StringBuilder sb = new StringBuilder();

    /**
     * D13
     * ✍️ Title : N과 M (8)
     * ⏰ Time : 27분 성공
     * 🤔 Approach : 이 전 풀이 응용
     * 🚬 Review : 자바 문자열 비교가 동치 비교만 있다는 것을 몰랐음. 그 부분에서 오래 걸렸음
     */ 
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr, 0, n); 
        recur(0, new int[m]); 
        System.out.print(sb);
    }

    static void recur(int len, int[] tmp) {
        if (len == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            
            if (len > 0 && tmp[len - 1] > arr[i]) {
                continue; 
            }
            tmp[len] = arr[i]; 
            recur(len + 1, tmp); 
        }
    }
}

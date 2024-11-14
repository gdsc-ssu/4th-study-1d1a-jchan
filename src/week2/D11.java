package week2;

import java.util.*;
import java.io.*;

public class D11 {
    static int n;
    static int[][] board;
    static int white = 0;
    static int blue = 0; 

    /**
     * D11
     * ✍️ Title : 색종이 만들기
     * ⏰ Time : 29분 49초
     * 🤔 Approach : 재귀 카테고리였지만 다른 시럼에서 콜스택이 터질 수 있다 생각해 DFS 스택으로 해결. size를 처음에 min, max로 하려다가 정사각형인 것을 이용해 size로 풀었음
     * 🚬 Review : 대부분의 재귀 문제는 DFS stack으로 풀 수 있는 듯 했음. 이 문제에서는 n이 매우 작아서 재귀도 가능했던 것 같음
     */ 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

       
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       
        Stack<Area> stack = new Stack<>();
        stack.push(new Area(0, 0, n));

        while (!stack.isEmpty()) {
            Area area = stack.pop();

            if (check(area.x, area.y, area.size)) {
                if (board[area.x][area.y] == 0) {
                    white++;
                } else {
                    blue++;
                }
            } else {
                int newSize = area.size / 2;
                stack.push(new Area(area.x, area.y, newSize));
                stack.push(new Area(area.x, area.y + newSize, newSize));
                stack.push(new Area(area.x + newSize, area.y, newSize));
                stack.push(new Area(area.x + newSize, area.y + newSize, newSize));
            }
        }

       
        System.out.println(white);
        System.out.println(blue);
    }

   
    static boolean check(int x, int y, int size) {
        int color = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

   
    static class Area {
        int x, y, size;

        public Area(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
}

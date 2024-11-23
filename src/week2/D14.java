

import java.util.*;
import java.io.*;

public class D14{
    public static void main(String[] args) throws IOException{
        solution();
    }
    
    static int n, m;
    static int[] dx = {1, 0, -1, 0}; 
    static int[] dy = {0, 1, 0, -1};
    static String[][] board;
    static int minCnt = Integer.MAX_VALUE;
    

    /**
     * D14
     * ✍️ Title : 감시
     * ⏰ Time : 40분 20초 성공
     * 🤔 Approach : 부르트 포스와 백트래킹인 것을 확인하고 품
     * 🚬 Review : 자바 컴파일 에러 등이 문제였음. 백준이라 디버깅하기도 힘들었음
     */ 
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new String[n][m];
        
        for(int i = 0; i < n; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = st1.nextToken();
            }
        }
        
        recur(board, 0, 0);
        
        System.out.println(minCnt);
    }
    
    static void recur(String[][] board, int i, int j){
        if(i == n){
            
            int cnt = count(board);
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        
        int nextI = i;
        int nextJ = j + 1;
        if(nextJ == m){
            nextI++;
            nextJ = 0;
        }
        
        String cell = board[i][j];
        if(cell.equals("0") || cell.equals("6") || cell.equals("7")){
            
            recur(board, nextI, nextJ);
        } else if(cell.equals("1")){
            for(int t = 0; t < 4; t++){
                String[][] tempBoard = copyBoard(board);
                tempBoard[i][j] = "7";
                paintStraight(tempBoard, t, i, j, "7");
                recur(tempBoard, nextI, nextJ);
            }
        } else if(cell.equals("2")){
            for(int t = 0; t < 2; t++){
                String[][] tempBoard = copyBoard(board);
                tempBoard[i][j] = "7";
                paintStraight(tempBoard, t, i, j, "7");
                paintStraight(tempBoard, (t + 2) % 4, i, j, "7");
                recur(tempBoard, nextI, nextJ);
            }
        } else if(cell.equals("3")){
            for(int t = 0; t < 4; t++){
                String[][] tempBoard = copyBoard(board);
                tempBoard[i][j] = "7";
                paintStraight(tempBoard, t, i, j, "7");
                paintStraight(tempBoard, (t + 1) % 4, i, j, "7");
                recur(tempBoard, nextI, nextJ);
            }
        } else if(cell.equals("4")){
            for(int t = 0; t < 4; t++){
                String[][] tempBoard = copyBoard(board);
                tempBoard[i][j] = "7";
                paintStraight(tempBoard, t, i, j, "7");
                paintStraight(tempBoard, (t + 1) % 4, i, j, "7");
                paintStraight(tempBoard, (t + 2) % 4, i, j, "7");
                recur(tempBoard, nextI, nextJ);
            }
        } else if(cell.equals("5")){
            String[][] tempBoard = copyBoard(board);
            tempBoard[i][j] = "7";
            for(int t = 0; t < 4; t++){
                paintStraight(tempBoard, t, i, j, "7");
            }
            recur(tempBoard, nextI, nextJ);
        }
    }
    
    static void paintStraight(String[][] board, int dir, int x, int y, String num){
        int nx = x;
        int ny = y;
        while(true){
            nx += dx[dir];
            ny += dy[dir];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(board[nx][ny].equals("6")){
                    break; 
                }
                if(board[nx][ny].equals("0")){
                    board[nx][ny] = num;
                }
                
            } else {
                break; 
            }
        }
    }
    
    static String[][] copyBoard(String[][] board){
        String[][] newBoard = new String[n][m];
        for(int i = 0; i < n; i++){
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }
    
    static int count(String[][] board){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j].equals("0")) cnt++;
            }
        }
        return cnt;
    }
}


import java.util.*;
import java.io.*;

public class D15 {
    static int n, m;
    static Sticker[] stickers;
    static Scanner sc = new Scanner(System.in);
    static int[][] board;

    public static void main(String[] args) throws IOException {
        solution();
    }

    /**
     * D15
     * ✍️ Title : 스티커 붙이기
     * ⏰ Time : 26분 40초 성공
     * 🤔 Approach : rotate만 잘 구현하면 된다고 생각
     * 🚬 Review : 순서 고려해서 그냥 구현
     */ 
    static void solution() throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        int k = sc.nextInt();
        stickers = new Sticker[k];
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            Sticker s = new Sticker();
            stickers[i] = s.setBoard(r, c);
        }

        for (Sticker stick : stickers) {
            for (int deg = 0; deg < 4; deg++) {
                if(deg != 0) stick.rotate();
                int maxRow = n - stick.r;
                int maxCol = m - stick.c;
                boolean found = false;
                int minX = -1, minY = -1;
                
                for1:
                for (int x = 0; x <= maxRow; x++) {
                    for (int y = 0; y <= maxCol; y++) {
                        if (canPlace(stick, x, y)) {
                            minX = x;
                            minY = y;
                            found = true;
                            break for1;
                        }
                    }
                }

                if (found) {
                    place(stick, minX, minY);
                    break;
                }
            }
        }

        int cnt = 0;
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean canPlace(Sticker s, int x, int y) {
        for (int i = 0; i < s.r; i++) {
            for (int j = 0; j < s.c; j++) {
                if (s.board[i][j] == 1 && board[x + i][y + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void place(Sticker s, int x, int y) {
        for (int i = 0; i < s.r; i++) {
            for (int j = 0; j < s.c; j++) {
                if (s.board[i][j] == 1) {
                    board[x + i][y + j] = 1;
                }
            }
        }
    }

    static class Sticker {
        int r, c;
        int[][] board;

        public Sticker setBoard(int r, int c) {
            this.r = r;
            this.c = c;
            this.board = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    this.board[i][j] = sc.nextInt();
                }
            }
            return this;
        }

        public void rotate() {
            int[][] newBoard = new int[this.c][this.r];
            for (int i = 0; i < this.c; i++) {
                for (int j = 0; j < this.r; j++) {
                    newBoard[i][j] = this.board[this.r - 1 - j][i];
                }
            }
            int temp = this.r;
            this.r = this.c;
            this.c = temp;
            this.board = newBoard;
        }
    }
}

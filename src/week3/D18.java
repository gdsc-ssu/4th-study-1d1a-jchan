package week3;
import java.util.*;

public class D18 {
    /**
     * D18
     * ✍️ Title : Puyo Puyo
     * ⏰ Time : 38분 27초 성공
     * 🤔 Approach : 이 전 풀이들을 가지고 풀 수 있었음. 컬렉션 api메서드들이 짜증났음
     * 🚬 Review : 더 빠르게만 풀고 싶다
     */ 
    public static void main(String[] args) {
        solution();
    }

    static String[][] board = new String[12][6];
    static int result = 0;

    static void solution() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 12; i++) {
            String line = sc.next();
            for (int j = 0; j < 6; j++) {
                board[i][j] = String.valueOf(line.charAt(j));
            }
        }

        result = 0;

        while (true) {
            boolean is뿌요 = 뿌요();
            if (!is뿌요) break;
            result++;
            떨어뜨리기();
        }

        System.out.println(result);
    }

    static void 떨어뜨리기() {
        for (int j = 0; j < 6; j++) {
            List<String> column = new ArrayList<>();
            for (int i = 11; i >= 0; i--) {
                if (!board[i][j].equals(".")) {
                    column.add(board[i][j]);
                }
            }

            for (int i = 11; i >= 0; i--) {
                if (11 - i < column.size()) {
                    board[i][j] = column.get(11 - i);
                } else {
                    board[i][j] = ".";
                }
            }
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean 뿌요() {
        boolean 뿌요발생 = false;
        boolean[][] visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (!board[i][j].equals(".") && !visited[i][j]) {
                    List<int[]> 뿌요list = new ArrayList<>();
                    String cur = board[i][j];
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cd = q.poll();
                        뿌요list.add(cd);

                        for (int t = 0; t < 4; t++) {
                            int nx = cd[0] + dx[t];
                            int ny = cd[1] + dy[t];

                            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 &&
                                    !visited[nx][ny] && board[nx][ny].equals(cur)) {
                                q.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    if (뿌요list.size() >= 4) {
                        for (int[] cd : 뿌요list) {
                            board[cd[0]][cd[1]] = ".";
                        }
                        뿌요발생 = true;
                    }
                }
            }
        }
        return 뿌요발생;
    }
}

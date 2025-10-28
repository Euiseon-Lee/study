import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final int[] X = {1, -1, 0, 0};
        final int[] Y = {0, 0, 1, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.addLast(new int[]{j, i});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            int x = current[0], y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + X[d];
                int ny = y + Y[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (board[ny][nx] != 0) continue;

                board[ny][nx] = board[y][x] + 1;
                q.addLast(new int[]{nx, ny});
            }
        }
        int max = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == 0) {
                    System.out.print(-1);
                    return;
                }
                max = Math.max(max, board[y][x]);
            }
        }
        System.out.print(max == 0 ? 0 : max - 1);
    }
}

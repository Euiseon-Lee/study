import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int[][] points = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, (a, b) -> {
            int byX = Integer.compare(a[0], b[0]);
            return (byX != 0) ? byX : Integer.compare(a[1], b[1]);
        });

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(points[i][0]).append(' ').append(points[i][1]).append('\n');
        }
        System.out.print(sb);
    }
}

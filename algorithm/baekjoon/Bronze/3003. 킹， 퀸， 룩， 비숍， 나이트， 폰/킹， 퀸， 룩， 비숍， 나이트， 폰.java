import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final int[] pieces = {1, 1, 2, 2, 2, 8};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int read = 0;
        while (read < 6) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                continue;
            }
            int possess = Integer.parseInt(st.nextToken());
            if (read > 0) sb.append(' ');
            sb.append(pieces[read] - possess);
            read++;
        }
        System.out.println(sb);
    }
}
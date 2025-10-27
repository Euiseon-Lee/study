import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();
        int bit = 0;

        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final String cmd = st.nextToken();
            int x;

            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    bit |= (1 << x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    bit &= ~(1 << x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((bit & (1 << x)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bit ^= (1 << x);
                    break;
                case "all":
                    bit = (1 << 21) - 2;
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}

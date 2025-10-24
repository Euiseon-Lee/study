import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            char[] ops = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>(Math.max(8, n));
            StringTokenizer st = new StringTokenizer(line, "[],");

            for (int i = 0; i < n; i++) dq.addLast(Integer.parseInt(st.nextToken()));

            boolean reverse = false;
            boolean error = false;

            for (char op : ops) {
                if (op == 'R') {
                    reverse = !reverse;
                } else {
                    if (dq.isEmpty()) {
                        sb.append("error").append('\n');
                        error = true;
                        break;
                    }
                    if (!reverse) dq.pollFirst(); else dq.pollLast();
                }
            }

            if (error) continue;

            sb.append('[');
            if (!dq.isEmpty()) {
                if (!reverse) {
                    sb.append(dq.pollFirst());
                    while (!dq.isEmpty()) sb.append(',').append(dq.pollFirst());
                } else {
                    sb.append(dq.pollLast());
                    while (!dq.isEmpty()) sb.append(',').append(dq.pollLast());
                }
            }
            sb.append(']').append('\n');
        }

        System.out.print(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                q.addLast(Integer.parseInt(cmd.substring(5)));
                continue;
            }
            switch (cmd) {
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.pollFirst()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}

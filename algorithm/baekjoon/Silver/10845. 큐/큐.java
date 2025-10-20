import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            switch (command) {
                case "pop":
                    if (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                    } else {
                        sb.append(-1);
                    }
                    break;
                case "size":
                    sb.append(dq.size());
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if (!dq.isEmpty()) {
                        sb.append(dq.peekLast());
                    } else {
                        sb.append(-1);
                    }
                    break;
                case "back":
                    if (!dq.isEmpty()) {
                        sb.append(dq.peekFirst());
                    } else {
                        sb.append(-1);
                    }
                    break;
                default:
                    st = new StringTokenizer(command);
                    st.nextToken();
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
            }
            if (!command.contains("push")) sb.append('\n');
        }
        System.out.print(sb);
    }
}
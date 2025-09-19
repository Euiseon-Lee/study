import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int removeIndex = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }
        StringBuilder sb = new StringBuilder("<");
        while (queue.size() > 1) {
            for (int i = 0; i < removeIndex - 1; i++) {
                int val = queue.pollFirst();
                queue.addLast(val);
            }
            sb.append(queue.pollFirst()).append(", ");
        }
        sb.append(queue.pollFirst()).append(">");
        System.out.println(sb);
    }
}
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
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n; i >= 1; i--) {
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder("<");
        while (stack.size() > 1) {
            for (int i = 0; i < removeIndex - 1; i++) {
                int val = stack.pollFirst();
                stack.addLast(val);
            }
            sb.append(stack.pollFirst()).append(", ");
        }
        sb.append(stack.pollFirst()).append(">");
        System.out.println(sb);
    }
}
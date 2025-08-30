import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int commandCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": queue.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop": Integer pop = queue.pollFirst();
                            sb.append(pop == null ? -1 : pop).append('\n');
                    break;
                case "size": sb.append(queue.size()).append('\n');
                    break;
                case "empty": sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front": Integer front = queue.peekFirst();
                            sb.append(front == null ? -1 : front).append('\n');
                    break;
                case "back": Integer back = queue.peekLast();
                            sb.append(back == null ? -1 : back).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
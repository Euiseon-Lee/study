import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque left = new ArrayDeque();
        Deque right = new ArrayDeque();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '<' : if (!left.isEmpty()) right.addLast(left.removeLast()); break;
                    case '>' : if (!right.isEmpty()) left.addLast(right.removeLast()); break;
                    case '-' : if (!left.isEmpty()) left.removeLast(); break;
                    default: left.addLast(c); break;
                }
            }
            while (!right.isEmpty()) left.addLast(right.removeLast());
            while (!left.isEmpty()) sb.append(left.removeFirst());
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
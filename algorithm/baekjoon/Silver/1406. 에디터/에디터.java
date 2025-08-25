import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initial = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (int i = 0; i < initial.length(); i++) {
            left.addLast(initial.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            char cmd = line.charAt(0);

            switch (cmd) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.addLast(left.removeLast());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.addLast(right.removeLast());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.removeLast();
                    }
                    break;
                case 'P':
                    // line: "P x"
                    char x = line.charAt(2);
                    left.addLast(x);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder(left.size() + right.size());
        for (char c : left) sb.append(c);
        Iterator<Character> it = right.descendingIterator();
        while (it.hasNext()) sb.append(it.next());
        System.out.println(sb.toString());
    }
}
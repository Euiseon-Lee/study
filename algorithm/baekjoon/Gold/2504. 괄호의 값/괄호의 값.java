import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        int result = 0;
        int value = 1;
        boolean invalid = false;

        for(int i = 0; i < line.length(); i++) {
            char ch =  line.charAt(i);
            if (ch == '(') {
                deque.push(ch);
                value *= 2;
            } else if (ch == '[') {
                deque.push(ch);
                value *= 3;
            } else if (ch == ')') {
                if (deque.isEmpty() || deque.peek() != '(') {
                    invalid = true;
                    break;
                }
                if (i > 0 && line.charAt(i - 1) == '(') result += value;
                deque.pop();
                value /= 2;
            } else if (ch == ']') {
                if (deque.isEmpty() || deque.peek() != '[') {
                    invalid = true;
                    break;
                }
                if (i > 0 && line.charAt(i - 1) == '[') result += value;
                deque.pop();
                value /= 3;
            } else {
                invalid = true;
                break;
            }
        }
        if (invalid || !deque.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
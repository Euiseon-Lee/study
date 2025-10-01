import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        boolean isOdd = word.length() % 2 == 1;
        int mid = word.length() / 2;
        boolean mismatch = false;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char ch =  word.charAt(i);
            if (i < mid) {
                deque.addFirst(ch);
            } else {
                if (isOdd && i == mid) {
                    continue;
                }
                if (deque.removeFirst() != ch) {
                    mismatch = true;
                    break;
                }
            }
        }
        System.out.print(!mismatch && deque.isEmpty() ? 1 : 0);
    }
}
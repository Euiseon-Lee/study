import java.io.*;
import java.util.*;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        count = 0;
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            checkWords(str);
        }
        System.out.print(count);
    }

    static void checkWords(String s) {
        if (s.length() % 2 == 1) return; // 홀수 길이는 불가능
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) count++;
    }
}

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (start < value) {
                for (int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                start = value;
            } else if (value == stack.peek()) {
                stack.pop();
                sb.append("-\n");

            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String expr = br.readLine().trim();

        double[] values = new double[26];
        for (int i = 0; i < N; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                stack.push(values[ch - 'A']);
            } else {
                double right = stack.pop();
                double left  = stack.pop();
                double res;

                switch (ch) {
                    case '+': res = left + right; break;
                    case '-': res = left - right; break;
                    case '*': res = left * right; break;
                    case '/': res = left / right; break;
                    case '%': res = left % right; break;
                    default:  throw new IllegalArgumentException("Unknown operator: " + ch);
                }
                stack.push(res);
            }
        }

        double answer = stack.pop();
        System.out.printf("%.2f%n", answer);
    }
}
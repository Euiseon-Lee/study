import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String space = " ";
        String star = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(space.repeat(n - i - 1));
            sb.append(star.repeat((i + 1) * 2 - 1)).append('\n');
        }
        for (int i = n - 1; i > 0; i--) {
            sb.append(space.repeat(n - i));
            sb.append(star.repeat((i * 2) - 1)).append('\n');
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(b.charAt(i) + "");
            int multiply = tmp * a;
            sb.append(multiply + "\n");
            total += multiply * (int) Math.pow(10, b.length() - i - 1);
        }
        System.out.print(sb.toString());
        System.out.println(total);
    }
}
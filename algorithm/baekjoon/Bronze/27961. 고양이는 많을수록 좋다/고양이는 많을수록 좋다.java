import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long steps = 1;
        long cats  = 1;
        while (cats < n) {
            cats <<= 1;
            steps++;
        }
        System.out.print(steps);
    }
}

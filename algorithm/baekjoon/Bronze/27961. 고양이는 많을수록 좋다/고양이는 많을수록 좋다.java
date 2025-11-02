import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int cat = 0;
        while (n > 3) {
            cat++;
            n = (n / 2) + (n % 2);
        }
        System.out.print(cat + n);
    }
}
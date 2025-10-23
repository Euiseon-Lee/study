import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 4 || n == 7) {
            System.out.println(-1);
            return;
        }
        int bags;
        switch (n % 5) {
            case 0: bags = n / 5; break;
            case 1:
            case 3: bags = (n / 5) + 1; break;
            case 2:
            case 4: bags = (n / 5) + 2; break;
            default: bags = -1; break;
        }
        System.out.println(bags);
    }
}
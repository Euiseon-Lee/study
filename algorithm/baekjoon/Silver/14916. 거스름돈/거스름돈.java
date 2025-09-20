import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int coin = -1;
        for (int i = n / 5; i >= 0; i--) {
            if ((n - (5 * i)) % 2 == 0) {
               coin = i + ((n - (5 * i)) / 2);
               break;
            }
        }
        System.out.println(coin);
    }
}
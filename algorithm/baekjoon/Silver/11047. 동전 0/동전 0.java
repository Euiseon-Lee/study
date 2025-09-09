import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int targetPrice = Integer.parseInt(st.nextToken());
        int[] coins = new int[coinCount];
        for (int i = coinCount - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int neededCoinCount = 0;
        for (int i = 0; i < coinCount; i++) {
            if (coins[i] <= targetPrice) {
                neededCoinCount += (targetPrice / coins[i]);
                targetPrice %= coins[i];
            }
        }
        System.out.println(neededCoinCount);
    }
}

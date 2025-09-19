import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int[] coins = new int[]{25, 10, 5, 1};
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int change = Integer.parseInt(br.readLine());
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                sb.append(change / coin).append(' ');
                change %= coin;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
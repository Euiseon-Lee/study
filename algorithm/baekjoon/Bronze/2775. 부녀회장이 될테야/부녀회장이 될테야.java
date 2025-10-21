import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) dp[i] = i;

            for (int floor = 1; floor <= k; floor++) {
                for (int room = 2; room <= n; room++) {
                    dp[room] += dp[room - 1];
                }
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}
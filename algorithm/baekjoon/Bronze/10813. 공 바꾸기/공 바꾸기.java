import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int ballX = basket[x] == 0 ? x : basket[x];
            int ballY = basket[y] == 0 ? y : basket[y];
            basket[x] = ballY;
            basket[y] = ballX;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int num = basket[i] == 0 ? i : basket[i];
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] baskets = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            baskets[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= (end - start) / 2; j++) {
                int temp = baskets[start + j];
                baskets[start + j] = baskets[end - j];
                baskets[end - j] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(baskets[i] + " ");
        }
        System.out.println(sb);
    }
}
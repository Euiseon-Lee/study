import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int answer = 0;
        outer:
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum > m) {
                    k--;
                } else {
                    if (sum > answer) answer = sum;
                    if (answer == m) break outer;
                    j++;
                }
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static long countFactor(long x, int p) {
        long cnt = 0;
        while (x > 0) {
            x /= p;
            cnt += x;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long v2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
        long v5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);

        long answer = Math.min(v2, v5);
        System.out.println(answer);
    }
}
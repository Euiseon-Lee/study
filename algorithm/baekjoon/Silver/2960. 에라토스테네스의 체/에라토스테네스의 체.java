import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        boolean[] isRemoved = new boolean[n + 1];
        isRemoved[0] = true;
        isRemoved[1] = true;

        for (int i = 2; i <= n; i++) {
            if (isRemoved[i]) continue;

            for (int j = i; j <= n; j += i) {
                if (!isRemoved[j]) {
                    k--;
                    isRemoved[j] = true;
                }

                if(k == 0) {
                    System.out.println(j);
                    break;
                }
            }

        }
    }
}
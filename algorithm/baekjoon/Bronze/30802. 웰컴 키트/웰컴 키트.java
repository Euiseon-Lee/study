import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tShirts = new int[6];
        for (int i = 0; i < tShirts.length; i++) tShirts[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int sum = 0;
        int quantity = 0;
        for (int s : tShirts) {
            quantity = s % t == 0 ? s / t :( s / t )+ 1;
            sum += quantity;
        }
        int bundle = n / p;
        int separate = n % p;
        System.out.println(sum);
        System.out.println(bundle + " " + separate);
    }
}
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(makeFactorial(n) / (makeFactorial(k) * makeFactorial(n - k)));
    }
    public static int makeFactorial(int n){
        if (n == 0 || n == 1) return 1;
        return n * makeFactorial(n - 1);
    }
}
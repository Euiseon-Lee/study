import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (!n.equals("0")) {
		    int len = n.length();
            int mid = len % 2 == 0 ? len / 2 : (len / 2) + 1;
            boolean isPalindrome = true;
            for (int i = 0; i < mid; i++) {
                if (n.charAt(i) != n.charAt(len - i - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            sb.append((isPalindrome) ? "yes" : "no").append('\n');
            n = br.readLine();
        }
        System.out.print(sb);
    }
}
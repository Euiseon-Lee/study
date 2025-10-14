import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
	    final String RIGHT = "right";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while (a + b + c != 0) {
            if (a * a == b * b + c * c) {
                sb.append(RIGHT);
            } else if (b * b == a * a + c * c) {
                sb.append(RIGHT);
            } else if (c * c == a * a + b * b) {
                sb.append(RIGHT);
            } else {
                sb.append("wrong");
            }
            sb.append('\n');
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
	}
}
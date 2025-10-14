import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<Long> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
		    set.add(Long.parseLong(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
            sb.append(set.contains(Long.parseLong(st.nextToken())) ? 1 : 0).append('\n');
		}
		System.out.print(sb);
	}
}
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }
}
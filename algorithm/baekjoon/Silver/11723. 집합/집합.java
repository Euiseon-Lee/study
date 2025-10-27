import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                for (int j = 1; j < 21; j++) {
					set.add(j);
				}
                continue;
            } else if (command.equals("empty")) {
                set.clear();
                continue;
            }
            int target = Integer.parseInt(st.nextToken());
            switch (command) {
                case "add":
                    set.add(target);
                    break;
                case "remove":
                    set.remove(target);
                    break;
                case "check":
                    sb.append(set.contains(target) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    if (set.contains(target)) {
                        set.remove(target);
                    } else {
                        set.add(target);
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
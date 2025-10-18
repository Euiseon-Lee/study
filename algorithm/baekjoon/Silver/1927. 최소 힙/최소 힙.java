import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (map.isEmpty()) {
                    sb.append("0");
                } else {
                    int first = map.firstKey();
                    int count = map.get(first);
                    sb.append(first);
                    if (count > 1) {
                        map.put(first, count - 1);
                    } else {
                        map.remove(first);
                    }
                }
                sb.append("\n");
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        System.out.println(sb);
    }
}
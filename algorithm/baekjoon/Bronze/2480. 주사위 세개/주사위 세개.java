import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        if (map.size() == 3) {
            int max = 0;
            for (int i : map.keySet()) {
                max = Math.max(i, max);
            }
            System.out.println(max * 100);
        } else {
            for (int i : map.keySet()) {
                int target = map.get(i);
                if (target > 1) {
                    System.out.println(Math.round(Math.pow(10, target + 1) + (i * Math.pow(10, target))));
                }
            }
        }
    }
}

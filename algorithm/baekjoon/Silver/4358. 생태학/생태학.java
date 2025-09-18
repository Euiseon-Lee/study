import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        double count = 0.0;
        String tree;
        while ((tree = br.readLine()) != null) {
            count++;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            int value = map.get(key);
            String portion = String.format("%.4f", (100.0 * value / count));
            sb.append(key).append(' ').append(portion).append('\n');
        }
        System.out.print(sb);
    }
}
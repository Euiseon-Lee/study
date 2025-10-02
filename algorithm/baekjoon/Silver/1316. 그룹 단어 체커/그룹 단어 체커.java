import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Map<Character, Boolean> map = new HashMap<>();
            char chPrev = word.charAt(0);
            map.put(chPrev, true);
            boolean isRelay = true;
            for (int j = 1; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (chPrev != ch) {
                    if (map.containsKey(ch)) {
                        isRelay = false;
                        break;
                    } else {
                        chPrev = ch;
                        map.put(ch, true);
                    }
                }
            }
            if (isRelay) answer++;
        }
        System.out.println(answer);
    }
}
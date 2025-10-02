import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean[] used = new boolean[26];
            char prev = 0;
            boolean isGroupWord = true;

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (ch != prev) {
                    if (used[ch - 'a']) {
                        isGroupWord = false;
                        break;
                    }
                    used[ch - 'a'] = true;
                    prev = ch;
                }
            }
            if (isGroupWord) answer++;
        }
        System.out.println(answer);
    }
}

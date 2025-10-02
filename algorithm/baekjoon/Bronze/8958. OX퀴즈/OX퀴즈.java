import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int weight = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String score = br.readLine();
            for (int j = 0; j < score.length(); j++) {
                char ch = score.charAt(j);
                if (ch == 'O') {
                    weight += 1;
                    answer += weight;
                } else {
                    weight = 0;
                }
            }
            sb.append(answer + "\n");
            weight = 0;
            answer = 0;
        }
        System.out.println(sb);
    }
}
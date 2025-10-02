import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String score = br.readLine();
            int streak = 0;
            int totalScore = 0;

            for (int j = 0; j < score.length(); j++) {
                if (score.charAt(j) == 'O') {
                    streak++;
                    totalScore += streak;
                } else {
                    streak = 0;
                }
            }
            sb.append(totalScore).append('\n');
        }

        System.out.print(sb);
    }
}
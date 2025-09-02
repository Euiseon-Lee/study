import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pokemonCount = Integer.parseInt(st.nextToken());
        int questionCount = Integer.parseInt(st.nextToken());

        String[] pokemonName = new String[pokemonCount + 1];
        Map pokemonNo = new HashMap();
        for (int i = 1; i <= pokemonCount; i++) {
            String temp = br.readLine();
            pokemonName[i] = temp;
            pokemonNo.put(temp, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questionCount; i++) {
            String question = br.readLine();

            if (Character.isDigit(question.charAt(0))) {
                sb.append(pokemonName[Integer.parseInt(question)]).append('\n');
            } else {
                sb.append(pokemonNo.get(question)).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCount; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (!cards.containsKey(card)) {
                cards.put(card, 1);
            } else  {
                cards.put(card, cards.get(card) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int targetCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < targetCount; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(cards.getOrDefault(target, 0)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
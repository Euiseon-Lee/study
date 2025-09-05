import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> cardStack = new ArrayDeque<>();
        int[] tech = new int[count];
        for (int i = 0; i < count; i++) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            tech[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = count - 1, card = 1; i >= 0; i--, card++) {
            int t = tech[i];
            switch (t) {
                case 1:
                    cardStack.addFirst(card);
                    break;
                case 2:
                    if (cardStack.isEmpty()) {
                        cardStack.addFirst(card);
                    } else {
                        Integer first = cardStack.pollFirst();
                        cardStack.addFirst(card);
                        cardStack.addFirst(first);
                    }
                    break;
                case 3:
                    cardStack.addLast(card);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int card : cardStack) {
            sb.append(card).append(" ");
        }
        System.out.println(sb.toString());
    }
}
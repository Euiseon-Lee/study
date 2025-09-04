import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lastCard = Integer.parseInt(br.readLine());
        Deque<Integer> cardStack = new ArrayDeque<>();
        for (int i = 1; i <= lastCard; i++) {
            cardStack.addLast(i);
        }

        while (cardStack.size() != 1) {
            cardStack.removeFirst();
            Integer card = cardStack.pollFirst();
            cardStack.addLast(card);
        }
        System.out.println(cardStack.peek());
    }
}
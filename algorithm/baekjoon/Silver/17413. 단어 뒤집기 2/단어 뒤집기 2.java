import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean inTag = false;
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                answer.append(temp.reverse());
                temp = new StringBuilder();
                inTag = true;
            } else if (c == '>') {
                inTag = false;
                answer.append(c);
                continue;
            }

            if (inTag) {
                answer.append(c);
            } else {
                if (c == ' ') {
                    answer.append(temp.reverse());
                    temp = new StringBuilder();
                    answer.append(c);
                } else {
                    temp.append(c);
                }
            }
        }
        answer.append(temp.reverse());
        System.out.println(answer.toString());
    }
}
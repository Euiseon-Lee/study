import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int index = 0;
        int count = 0;
        while (index < word.length()) {
            char ch = word.charAt(index);
            if (index != word.length() - 1) {
                char chNext = word.charAt(index + 1);
                if (ch == 'c' || ch == 's' || ch == 'z') {
                    if (chNext== '=' || chNext== '-') index++;
                } else if (ch == 'd') {
                    if (chNext== '-') {
                        index++;
                    } else if (index + 2 <= word.length() - 1) {
                        if (chNext== 'z' && word.charAt(index + 2) == '=') index += 2;
                    }
                } else if (ch == 'n' || ch == 'l') {
                    if (chNext== 'j') index++;
                }
            }
            index++;
            count++;
        }
        System.out.print(count);
    }
}
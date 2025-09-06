import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.isEmpty() || s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_' || s.contains("__")) {
            System.out.println("Error!");
            return;
        }
        boolean hasUpperCase = false;
        boolean hasUnderscore = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '_') hasUnderscore = true;
            else if (Character.isUpperCase(ch)) hasUpperCase = true;
            else if (!Character.isLowerCase(ch)) { // 허용 문자: 소문자, '_', 대문자
                System.out.println("Error!");
                return;
            }
        }

        if (hasUpperCase && hasUnderscore) {
            System.out.println("Error!");
            return;
        }

        if (!hasUnderscore) {
            if (!Character.isLowerCase(s.charAt(0))) {
                System.out.println("Error!");
                return;
            }
            StringBuilder sb = new StringBuilder(s.length() + 8);
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isUpperCase(ch)) {
                    sb.append('_').append(Character.toLowerCase(ch));
                } else {
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(ch == '_' || Character.isLowerCase(ch))) {
                System.out.println("Error!");
                return;
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        boolean up = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '_') {
                up = true;
            } else {
                if (up) {
                    sb.append(Character.toUpperCase(ch));
                    up = false;
                } else {
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 3613 - Java vs C++
         *
         * [판정 규칙]
         * - 공통 금지: 대문자와 '_'가 동시에 존재하면 Error!
         * - Java: 첫 글자 소문자, '_' 없음, 나머지는 [a-zA-Z]
         * - C++: [a-z_]+, 시작/끝 '_' 금지, "__" 금지
         *
         * [변환]
         * - Java -> C++: 대문자 X → '_' + toLowerCase(X)
         * - C++ -> Java: '_' 다음 글자 대문자, '_' 제거
         *
         * [로직 구조]
         * 1) 빠른 에러 체크(시작/끝 '_', "__")
         * 2) 스캔하여 hasUpper/hasUnderscore 결정
         * 3) 혼합 스타일(hasUpper && hasUnderscore) → Error!
         * 4) '_' 유무로 분기하여 Java 또는 C++ 판정/변환
         *
         * [성능]
         * - 한 번의 스캔 O(n), StringBuilder 이용
         *
         * [보완 포인트]
         * - 정규식 과의존 지양: 엣지 케이스(시작/끝 '_', "__")는 직접 체크가 안전
         * - char 산술(±32) 대신 Character API 사용 → 가독성/안전성↑
         */
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

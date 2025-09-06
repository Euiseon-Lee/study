import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  /**
   * 🧩 BOJ 3613 - Java vs C++ (정규표현식 접근)
   *
   * [판정 정규식]
   * - Java  : ^[a-z][a-zA-Z]*$        (첫 글자 소문자, '_' 없음)
   * - C++   : ^[a-z]+(_[a-z]+)*$      (소문자 단어 + '_'로만 연결, 연속/양끝 '_' 없음)
   *
   * [변환 규칙]
   * - Java → C++ : 대문자 X를 '_' + toLowerCase(X) 로 치환
   * - C++  → Java: '_' 다음 글자를 대문자로 치환, '_' 제거
   *
   * [왜 이 패턴이 안전한가]
   * - 혼합(대문자와 '_')은 두 패턴 모두 불일치하므로 자동으로 Error!
   * - C++ 정규식이 시작/끝/연속 '_'를 원천 차단 → 별도 예외 처리 불요
   *
   * [성능]
   * - 판정 1회 + 선형 변환: O(n)
   */
    private static final String JAVA = "^[a-z][a-zA-Z]*$";
    private static final String CPP  = "^[a-z]+(_[a-z]+)*$";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.matches(JAVA)) {
            System.out.println(javaToCpp(s));
        } else if (s.matches(CPP)) {
            System.out.println(cppToJava(s));
        } else {
            System.out.println("Error!");
        }
    }

    private static String javaToCpp(String s) {
        StringBuilder sb = new StringBuilder(s.length() + 8);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append('_').append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static String cppToJava(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        boolean up = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '_') {
                up = true;
            } else {
                sb.append(up ? Character.toUpperCase(ch) : ch);
                up = false;
            }
        }
        return sb.toString();
    }
}

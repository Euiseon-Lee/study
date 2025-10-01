import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔡 BOJ 2941 - 크로아티아 알파벳
         *
         * 📌 로직 개요
         * - 문자열을 순회하며 크로아티아 알파벳(2~3글자)을 만나면 index를 건너뛰고 count 증가
         * - 규칙:
         *   c=, c-, dz=, d-, lj, nj, s=, z=
         * - 나머지는 일반 문자로 1개 처리
         *
         * ⏱️ 복잡도
         * - 시간: O(n)
         * - 공간: O(1)
         *
         * ✅ 장점
         * - index 조절 방식으로 문자열 전체를 한 번만 순회
         * - 불필요한 자료구조 없이 조건문만으로 해결
         *
         * ⚠️ 주의
         * - dz=는 세 글자를 하나로 → 반드시 따로 처리 필요
         * - z=는 dz=와 중복되므로 d-분기 이후에 검사해야 안전
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int index = 0;
        int count = 0;

        while (index < word.length()) {
            char ch = word.charAt(index);
            if (index < word.length() - 1) {
                char chNext = word.charAt(index + 1);
                if (ch == 'c' && (chNext == '=' || chNext == '-')) {
                    index++;
                } else if (ch == 'd') {
                    if (chNext == '-') {
                        index++;
                    } else if (index + 2 < word.length()) {
                        if (chNext == 'z' && word.charAt(index + 2) == '=') {
                            index += 2;
                        }
                    }
                } else if ((ch == 'l' || ch == 'n') && chNext == 'j') {
                    index++;
                } else if ((ch == 's' || ch == 'z') && chNext == '=') {
                    index++;
                }
            }
            index++;
            count++;
        }
        System.out.println(count);
    }
}


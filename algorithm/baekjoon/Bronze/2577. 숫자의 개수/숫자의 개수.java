import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 🔢 BOJ 2577 - 숫자의 개수
         *
         * 📌 문제 요약
         * - 세 자연수 A, B, C의 곱을 계산
         * - 결과값을 구성하는 숫자(0~9)가 각각 몇 번 등장하는지 출력
         *
         * 🧱 로직 구조
         * 1) 입력: 세 정수를 각각 읽음
         * 2) 곱셈 결과를 문자열로 변환 (String.valueOf)
         * 3) 각 자리 문자를 순회하며 숫자 빈도 카운트
         *    → numbers[ch - '0']++
         * 4) 0~9까지 각 숫자의 등장 횟수를 순서대로 출력
         *
         * ⏱️ 복잡도
         * - 시간: O(d) (d는 결과값의 자릿수)
         * - 공간: O(1)
         *
         * ✅ 장점
         * - BufferedReader + StringBuilder로 I/O 효율 높음
         * - String.valueOf() 사용으로 null-safe
         * - 문제 의도를 1:1 반영한 명확한 구조
         *
         * ⚙️ 예시
         *  입력:
         *   150
         *   266
         *   427
         *  출력:
         *   3
         *   1
         *   0
         *   2
         *   0
         *   0
         *   0
         *   2
         *   0
         *   0
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String result = String.valueOf(a * b * c);
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[10];
        for (int i = 0; i < result.length(); i++) {
            numbers[result.charAt(i) - '0']++;
        }
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append('\n');
        }
        System.out.print(sb);
    }

}

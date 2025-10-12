import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 🔢 BOJ 1427 - 소트인사이드
         *
         * 📌 문제 요약
         * - 입력된 정수 N의 각 자릿수를 내림차순으로 정렬하여 출력
         * - 예: 2143 → 4321
         *
         * 🧱 로직 구조
         * 1) 자릿수별 빈도 카운트 (0~9)
         *    → numbers[digit]++
         * 2) 9부터 0까지 순회하며 등장 횟수만큼 repeat()
         *    → StringBuilder로 효율적 조합
         * 3) 최종 문자열 출력
         *
         * ⏱️ 복잡도
         * - 시간: O(n) (정렬 불필요, 카운트 정렬 구조)
         * - 공간: O(1) (숫자 10개 고정 배열)
         *
         * ✅ 장점
         * - 정렬 대신 빈도 기반 조합으로 빠름
         * - int 오버플로우 걱정 없이 문자열 처리
         * - StringBuilder + repeat() 활용으로 가독성·성능 균형
         *
         * ⚙️ 예시
         *  입력: 2143
         *  출력: 4321
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] numbers = new int[10];
        for (int i = 0; i < num.length(); i++) {
            numbers[num.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            String number = String.valueOf(i);
            sb.append(number.repeat(numbers[i]));
        }
        System.out.println(sb);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔁 BOJ 10988 - 팰린드롬 확인 (Deque 기반 좌반부 스택 비교)
         *
         * 📌 문제 요약
         * - 문자열이 앞뒤 대칭(팰린드롬)이면 1, 아니면 0을 출력한다.
         *
         * 🧱 로직 구조
         * - 길이 n, 중앙 mid = n/2
         * - i < mid  : 왼쪽 절반을 deque.addFirst(ch)로 스택화
         * - i >= mid : 홀수이고 i == mid면 중앙은 스킵
         *              그 외에는 deque.removeFirst()와 현재 문자 비교
         * - 하나라도 다르면 mismatch = true로 표시 후 종료
         * - 최종 판정: (!mismatch && deque.isEmpty()) ? 1 : 0
         *
         * ⏱️ 복잡도
         * - 시간: O(n) (단일 패스)
         * - 공간: O(n) (좌반부 저장)
         *
         * ✅ 장점
         * - 전반부를 스택으로 버퍼링하고 후반부를 읽으면서 즉시 비교 → 구현 직관적
         * - 중앙 문자 분기만 처리하면 짝/홀수 공통화
         * - 불일치 즉시 중단으로 평균 성능 유리
         *
         * ⚠️ 주의
         * - 불일치 시 덱이 우연히 비어도 팰린드롬이 아님 → mismatch 플래그로 최종 판정
         * - removeFirst()는 빈 덱에서 호출 금지(본 로직에서는 인덱스 불변식으로 안전)
         *
         * 🧠 대안/비교
         * - 투 포인터 i/j로 s.charAt(i)와 s.charAt(j) 비교하면서 i++, j-- 진행하면 O(1) 공간
         * - 본 해법은 "스택 패턴 체득" 및 스트리밍 비교 관점에서 유익
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        boolean isOdd = word.length() % 2 == 1;
        int mid = word.length() / 2;
        boolean mismatch = false;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char ch =  word.charAt(i);
            if (i < mid) {
                deque.addFirst(ch);
            } else {
                if (isOdd && i == mid) {
                    continue;
                }
                if (deque.removeFirst() != ch) {
                    mismatch = true;
                    break;
                }
            }
        }
        System.out.print(!mismatch && deque.isEmpty() ? 1 : 0);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔁 BOJ 10988 - 팰린드롬 확인
         *
         * 📌 문제 요구
         * - 주어진 문자열이 팰린드롬(앞뒤 대칭)인지 확인
         * - 팰린드롬이면 1, 아니면 0 출력
         *
         * 🧱 시도한 풀이 방식들
         *
         * 1) Deque 버전
         * - 문자열 전반부(i < mid)를 Deque에 push (좌반부 스택화)
         * - 후반부(i >= mid)에서 pop 하며 비교
         * - 홀수 길이일 땐 중앙 문자 스킵
         * - 불일치 발생 시 mismatch 처리, 끝까지 통과하면 팰린드롬
         * - 시간 O(n), 공간 O(n)
         * - 장점: "좌반부 버퍼링 → 우반부 스트리밍 비교" 패턴 체득 가능
         * - 단점: 불필요한 추가 메모리 사용
         *
         * 2) for-loop + mismatch 플래그
         * - mid = (n / 2) + (n % 2)
         * - 0..mid-1까지 word[i]와 word[n-1-i] 비교
         * - 불일치 발견 시 mismatch = true, 탈출
         * - 최종 판정: mismatch ? 0 : 1
         * - 시간 O(n), 공간 O(1)
         * - 장점: 직관적, 코드 간결
         * - 단점: mid 계산 등 약간의 주의 필요
         *
         * 3) while + 투 포인터 (최종 선택)
         * - i=0, j=n-1에서 시작해 중앙으로 수렴
         * - word[i] != word[j] 발견 시 0, 끝까지 통과하면 1
         * - 시간 O(n), 공간 O(1)
         * - 장점: 메모리 최적, 구현 단순, 문제 의도와 가장 일치
         *
         * ✅ 결론
         * - Deque 버전: 자료구조 활용 연습용
         * - for-loop 버전: 불일치 플래그 활용으로 안전성 높음
         * - while 버전: 가장 최적화된 해법, 커밋 시 채택
         *
         * ⏱️ 복잡도(최종 while 버전)
         * - 시간: O(n) (조기 종료 가능)
         * - 공간: O(1)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int n = word.length();
        int i = 0, j = n - 1;
        int answer = 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                answer = 0;
                break;
            }
            i++;
            j--;
        }
        System.out.print(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🏢 BOJ 2775 부녀회장이 될테야 – 점화식 기반 1차원 DP
         *
         * 💡 핵심 점화식
         * - f(0, n) = n
         * - f(k, n) = f(k, n-1) + f(k-1, n),  f(k,1)=1
         *   → 같은 층의 왼쪽 누적 + 아래층 같은 호수
         *
         * 🔁 해법 개요(1차원 DP)
         * - dp[i] = 현재 층의 i호 인원
         * - 0층 초기화: dp[i] = i
         * - 각 층마다 좌→우로 누적: dp[i] += dp[i-1] (i=2..n)
         *
         * ⏱️ 복잡도
         * - 시간: O(k·n), 공간: O(n)
         * - 2775의 입력 제약(일반적으로 k,n ≤ 14)에서 매우 빠름
         *
         * ✅ 구현 평가
         * - 점화식을 코드로 직결 → 하드코딩/예외 분기 제거
         * - StringBuilder 일괄 출력으로 I/O 효율 확보
         *
         * 🛠️ 보완 포인트
         * 1) 전처리 테이블(선택): 15×15를 한 번 채운 뒤 질의 즉시 응답
         * 2) 다중 테스트 최적화(선택): T가 크고 k,n 범위 고정이면 전처리 이점 큼
         * 3) 형 안전성: 결과는 int 범위 내(이 문제 범위), 그래도 long 변환 여지 인지
         *
         * 🧪 테스트 힌트
         * - 최소값: k=0, n=1 → 1
         * - 동일 층 증가: (k=1, n=1..5) → 1,3,6,10,15
         * - 랜덤 케이스를 DP·조합(C(n+k, k+1))과 대조 검증
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) dp[i] = i;

            for (int floor = 1; floor <= k; floor++) {
                for (int room = 2; room <= n; room++) {
                    dp[room] += dp[room - 1];
                }
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }

}

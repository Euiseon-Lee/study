import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
		/**
		 * 🏨 BOJ 10250 - ACM 호텔 (층/호수 매핑)
		 *
		 * 📌 문제 요약
		 * - 호텔 H층, 각 층 W개 방. 손님 N번째 도착 시 위층부터 채워 배정.
		 * - 출력 형식: YYXX (층*100 + 호)
		 *
		 * 🧠 핵심 수식 (1-based 순번 → 2차원 좌표)
		 * - y = (N - 1) % H + 1   // 층
		 * - x = (N - 1) / H + 1   // 호
		 * - answer = y * 100 + x
		 *
		 * 🧱 로직 구조
		 * 1) T번 반복:
		 *    - 입력: H, W(미사용), N
		 *    - y, x 계산 후 answer 출력
		 *
		 * ⏱️ 복잡도
		 * - 각 테스트 O(1), 총 O(T)
		 *
		 * ✅ 장점
		 * - (N-1) 보정으로 if/else 없이 수식 한 번에 해결 가능
		 * - StringBuilder로 I/O 호출 최소화
		 *
		 * ⚠️ 주의
		 * - W는 계산에 사용되지 않음(문제 규칙상 위층부터 채움)
		 * - N % H == 0 처리도 수식으로 자연스럽게 해결됨
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            st.nextToken();               // W (미사용)
            int N = Integer.parseInt(st.nextToken());
            int y = (N - 1) % H + 1;      // 층
            int x = (N - 1) / H + 1;      // 호
            sb.append(y * 100 + x).append('\n');
        }
        System.out.print(sb);
    }
}



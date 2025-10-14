import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
		/**
		 * 📐 BOJ 4153 - 직각삼각형
		 *
		 * 📌 문제 요약
		 * - 세 변 a, b, c가 주어질 때 직각삼각형인지 판정한다.
		 * - 입력이 "0 0 0"이면 종료.
		 *
		 * 🧠 핵심 아이디어
		 * - 세 변 중 가장 긴 변을 z라 할 때, x^2 + y^2 == z^2 이면 직각.
		 * - 세 변을 정렬하여 s[2]를 최댓값으로 두면 조건문 1개로 판정 가능.
		 *
		 * 🧱 로직 구조
		 * 1) 한 줄 읽고 a,b,c 파싱 → 모두 0이면 종료
		 * 2) 세 변을 정렬: int[] s = {a,b,c}; Arrays.sort(s)
		 * 3) x^2 + y^2 == z^2 ? "right" : "wrong" 출력
		 *
		 * ⏱️ 복잡도
		 * - 각 케이스 O(1) (정렬을 써도 고정 3개 → 상수 시간)
		 *
		 * ✅ 장점
		 * - 정렬 후 단일 조건으로 가독성↑, 중복 연산↓
		 * - StringBuilder 누적으로 I/O 호출 최소화
		 *
		 * ⚠️ 보완 포인트
		 * - 제곱 연산은 잠재적 오버플로를 고려해 long 캐스팅 후 비교 권장
		 *   (문제 입력 범위에선 int로도 통과하나, 습관적으로 안전하게)
		 * - 입력 라인 단위로 읽고 종료 조건을 먼저 판단하면 while 조건이 더 명확해짐
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

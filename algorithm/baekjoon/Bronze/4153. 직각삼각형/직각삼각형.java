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
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) break;

            int[] s = {a, b, c};
            Arrays.sort(s);
            long x = s[0], y = s[1], z = s[2]; // 안전한 제곱 비교
            sb.append(x * x + y * y == z * z ? "right" : "wrong").append('\n');
        }
        System.out.print(sb);
    }
}

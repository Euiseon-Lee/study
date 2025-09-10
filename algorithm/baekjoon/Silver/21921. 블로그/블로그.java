import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 슬라이딩 윈도우(BOJ 21921) – 길이 X 구간 합의 최댓값과 빈도
         *
         * ✅ 로직 개요
         *  1) 초기 구간(0~X-1) 합을 계산하여 windowSum, max로 설정.
         *  2) i를 X부터 N-1까지 증가시키며
         *     - windowSum = windowSum - visitors[i - X] + visitors[i]
         *     - max 갱신 규칙:
         *       * windowSum > max   → max = windowSum, count = 1
         *       * windowSum == max  → count++
         *
         * ✅ 성능 분석
         *  - 한 칸 이동당 O(1) → 전체 O(N), 추가 메모리 O(1).
         *  - N·X가 커져도 선형으로 처리 가능.
         *
         * ✅ 실무 활용도
         *  - 트래픽, 방문자, 매출 등 연속 구간 집계에 직결되는 패턴.
         *  - 로그 스트림에서도 동일 원리 적용 가능(슬라이딩 집계).
         *
         * ✅ 보완 포인트
         *  - 변수 통일: startSum/compareSum → windowSum (가독성·안정성 향상).
         *  - 누적합·최댓값은 long 권장(실무 데이터의 상한 여유).
         *  - 입력 토큰이 여러 줄로 올 수 있는 환경에선 토큰 부족 시 다음 줄 읽기 처리.
         *
         * ✅ 엣지/출력 규칙
         *  - n == x: 초기 합이 곧 결과.
         *  - 모든 구간 합이 0 → "SAD"만 출력(두 번째 줄 생략).
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalDays = Integer.parseInt(st.nextToken());
        int checkDays = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[totalDays];
        for (int i = 0; i < totalDays; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
        long windowSum = 0;
        for (int i = 0; i < checkDays; i++) windowSum += visitors[i];

        long maxVisitors = windowSum;
        int maxCount = (maxVisitors > 0) ? 1 : 1; // 초기 윈도우도 1회로 카운트
        for (int i = checkDays; i < totalDays; i++) {
            windowSum += visitors[i] - visitors[i - checkDays];
            if (windowSum > maxVisitors) {
                maxVisitors = windowSum;
                maxCount = 1;
            } else if (windowSum == maxVisitors) {
                maxCount++;
            }
        }

        if (maxVisitors == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitors);
            System.out.println(maxCount);
        }
    }
}


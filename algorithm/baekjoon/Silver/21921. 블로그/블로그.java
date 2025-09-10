import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 21921 – 방문자 통계 (슬라이딩 윈도우)
         *
         * ✅ 문제 요약
         *  길이 X의 모든 연속 구간 합 중 최댓값과 그 빈도를 구한다. 최댓값이 0이면 "SAD"만 출력한다.
         *
         * ✅ 기존 코드 요약
         *  - 초기 구간(0~X-1) 합을 startSum으로 계산.
         *  - 한 칸씩 이동하며 compareSum = compareSum - visitors[i-1] + visitors[i+X-1].
         *  - maxVisitors/sameVisitors 갱신, maxVisitors==0이면 "SAD" 처리.
         *
         * 🔧 개선 포인트
         *  1) 변수 통일: startSum/compareSum → windowSum 하나로 일원화(가독성/실수 방지).
         *  2) 형 안전성: 누적합·최댓값은 long 권장(실무/경계 입력 대비).
         *  3) 입력 견고성: 토큰 부족 시 다음 줄 재읽기 패턴 준비(실무/유사문제 대응).
         *  4) 명명 일관: totalDays/checkDays → n/x 등 도메인+알고리즘 의도 드러나는 이름 권장.
         *  5) 불필요 대입 제거: 루프 말미 startSum = compareSum는 제거 가능(단일 변수로 대체).
         *
         * ⚙️ 성능 분석
         *  초기 합 O(X) + (N-X)회 한 칸 이동 O(1) → 전체 O(N), 추가 메모리 O(1).
         *  구간합 배열 저장/재계산 없음 → 시간초과 원인 제거.
         *
         * 🧪 엣지/테스트
         *  - n == x: 초기 합이 곧 결과, count=1.
         *  - 모든 방문자 수가 0: "SAD"만 출력(두 번째 줄 생략).
         *  - 경계치: x=1, x=n, 큰 값(합이 int 경계 근처) 검증.
         *
         * 🛠 실무 활용도
         *  트래픽/매출/센서 데이터의 고정 길이 이동 합계에 그대로 적용 가능.
         *  스트림 처리/배치 모두에서 사용되는 전형 패턴으로 유지보수성 높음.
         *
         * 🔐 안정성
         *  입력 제약이 불명확한 환경에서는 숫자 파싱 예외, 음수/범위 초과에 대한 방어 코드 고려.
         *
         * 📈 개발 실력 진단 요약 (2025-09-11)
         *  - 현재 레벨: 실무형 구조 설계 Level 3 (상위 40~60%)
         *  - 강점: 패턴 전환 속도(슬라이딩 윈도우), 불필요 루프 제거, 상수화 습관.
         *  - 보완: 초기 복잡도 선택 선행, long 우선 채택, 입력 견고성, 테스트 3종(기본/엣지/랜덤) 상시화.
         *  - 단기 과제: windowSum 단일 변수화, 윈도우·투포인터·누적합 20제, JUnit5로 3케이스 템플릿 고정.
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



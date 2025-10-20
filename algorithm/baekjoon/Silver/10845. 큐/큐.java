import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📦 BOJ 10845 큐 – Deque 기반 큐 명령 처리 (설명 우선 리뷰)
         *
         * [로직 구조]
         * - 입력된 명령 N개를 순차 처리
         * - push X는 큐에 삽입, pop/size/empty/front/back는 상태 조회/변경
         * - ArrayDeque를 큐로 사용하고 StringBuilder로 결과를 누적 출력
         *
         * [성능 분석]
         * - 각 연산 평균 O(1) (ArrayDeque의 양끝 연산)
         * - I/O는 BufferedReader + StringBuilder로 병목 최소화
         * - 불필요한 문자열 탐색(contains("push")) 제거 시 미세 비용 감소
         *
         * [실무 활용도]
         * - 작업 큐, 이벤트 큐 등에서 즉시 사용 가능한 패턴
         * - 협업 관점에서 front/back 방향을 직관적으로 맞추는 것이 유지보수에 유리
         *
         * [보완 포인트]
         * 1) 방향 통일
         *    - front = peekFirst/pollFirst, back = peekLast/addLast로 매핑
         * 2) 파싱 단순화
         *    - "push X"는 startsWith("push") 후 substring(5)로 정수 추출
         *    - StringTokenizer 및 contains 탐색 제거 → 가독성/미세 성능 개선
         * 3) 개행 처리 일관화
         *    - 각 case에서 즉시 '\n'을 append하여 조건부 개행 제거
         * 4) 초기 용량 지정(선택)
         *    - new ArrayDeque<>(n)으로 내부 리사이즈 가능성 축소
         *
         * [결론]
         * - 기존 코드도 정답이며 성능상 문제 없음
         * - 위 보완으로 가독성과 안정성을 높이고, 불필요한 오버헤드를 줄일 수 있음
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                q.addLast(Integer.parseInt(cmd.substring(5)));
                continue;
            }
            switch (cmd) {
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.pollFirst()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}


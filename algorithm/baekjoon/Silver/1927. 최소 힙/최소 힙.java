import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 1927 최소 힙 – 자료구조 선택과 성능 관점 리뷰
         *
         * 💡 로직 구조
         * - 입력 N회에 대해 정수 x를 처리
         *   • x == 0 : 현재 구조에서 최소값을 꺼내 출력(없으면 0)
         *   • x != 0 : x를 구조에 삽입
         *
         * 🧠 자료구조 선택 평가
         * - 현재 풀이: TreeMap<Integer, Integer>로 멀티셋 구현
         *   • 삽입/삭제/최솟값 조회: O(log U), U=서로 다른 키 개수
         *   • firstKey()로 최소값, 카운트 감소 후 0이면 remove
         * - 대안(권장): PriorityQueue<Integer> (자바 표준 최소 힙)
         *   • 삽입 add, 최소 poll: O(log N), N=원소 수
         *   • 중복 자연 처리(카운팅 불필요) → 코드 단순/오버헤드 감소
         *
         * ⏱️ 성능 분석
         * - 둘 다 대략 O(log N) 급이지만 실제 상수 비용에서 PQ가 유리
         *   • TreeMap: 레드-블랙 트리 회전 + get/put/remove 오브젝트 경로 비용
         *   • PQ: 배열 기반 힙 상하향 재배치만 수행, 토막 코드 경량
         * - 출력은 StringBuilder로 모아서 한 번에 출력 → I/O 효율적
         *
         * 🧪 엣지 케이스
         * - 비어 있을 때 x == 0 요청 → 0 출력 (요구사항 충족)
         * - 모든 입력이 0인 경우, 모든 입력이 양수인 경우 등 정상 동작
         *
         * 🛠️ 보완 포인트
         * 1) 자료구조 단순화: PriorityQueue<Integer>로 치환 → 코드/메모리/상수 시간 이득
         * 2) 출력: sb.append(값).append('\n') 형태로 일관성 유지 (이미 잘 적용)
         * 3) I/O: BufferedReader/StringBuilder 조합은 적절, 추가 최적화 불필요
         *
         * 🧩 실무 활용도
         * - 최소값 반복 추출(작업 스케줄링, 타임아웃 관리, 이벤트 큐)에선 최소 힙이 표준
         * - 카운팅이 꼭 필요할 때만 정렬 맵/트리 멀티셋 패턴을 선택
         */  
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            final int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            } else {
                pq.add(x);
            }
        }
        System.out.print(sb);
    }
}

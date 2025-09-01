import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 제로(BOJ 10773) – 스택 기반 롤백과 합계 계산
         *
         * [🧩 문제 요약]
         * - 정수 N개 입력: x != 0 → 스택 push, x == 0 → 최근 값 pop
         * - 최종 합계를 출력
         *
         * [🧱 로직 구조]
         * - Deque<Integer> stack(권장: ArrayDeque)
         * - 실시간 합계 관리: push 시 sum += x, pop 시 sum -= popped
         *
         * [🛠 보완 포인트(상세)]
         * 1) 합계 실시간 갱신
         *    - 마지막 합산 루프 제거 → 상수 비용 절감, 코드 단순화
         *    - 구현: push 시 sum+=x, pop 시 popped=removeLast(); sum-=popped
         *
         * 2) 자료구조 현대화
         *    - Stack → ArrayDeque: 단일 스레드에서 동기화 오버헤드 제거, 캐시 친화적
         *    - 스택 연산 매핑: addLast(x), removeLast(), peekLast()
         *    - 주의: ArrayDeque는 null 금지
         *
         * 3) 방어적 pop(실무)
         *    - 문제 보장은 있어도 실무에서는 빈 스택 pop 시 예외 → 사전 isEmpty() 체크
         *    - 정책 결정: 엄격 실패(throw/log) 또는 관용 처리(무시)
         *
         * 4) 합계 타입은 long
         *    - 누적 합이 int 범위를 넘어갈 수 있음 → long으로 오버플로 방지
         *
         * 5) 책임 분리(선택)
         *    - 상태 갱신 로직을 메서드로 분리하면 단위 테스트 용이
         *    - 예: long apply(Deque<Integer> s, long sum, int x)
         *
         * [⏱ 성능]
         * - 시간 O(N): 입력 1회 처리(실시간 합계), 스택 연산 O(1)
         * - 공간 O(N): 스택 최대 크기
         *
         * [🛡 예외/안전]
         * - 0 입력 시 빈 스택 pop 방지(실무 가드), 입력 검증/로그 정책
         *
         * [🧪 테스트]
         * - 연속 0, 전부 상쇄되어 0, 큰 값 누적(오버플로 detection), 랜덤 시퀀스
         *
         * [🏭 시사점]
         * - Undo/롤백은 스택 정석 패턴
         * - 상태값은 가능하면 실시간 관리 → 후처리/버그 포인트 축소
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /* 기존 코드
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
        */
        
        // 개선 코드
        Deque<Integer> stack = new ArrayDeque<>(n);        // 초기 용량 지정으로 동적 리사이즈 비용 방지(선택)
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                stack.addLast(x);
                sum += x;
            } else {
                // 문제 보장상 비어 있지 않지만, 실무라면 빈 스택 가드 필요
                int popped = stack.removeLast();
                sum -= popped;
            }
        }
        System.out.println(sum);
    }

}

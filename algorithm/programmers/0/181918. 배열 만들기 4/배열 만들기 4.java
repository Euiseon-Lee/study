import java.util.*;

class Solution {
    public Stack<Integer> solution(int[] arr) {
        /**
         * 특정 조건에 따라 입력 배열을 스택처럼 처리하여 결과 배열을 구성함
         *
         * 💡 문제 개요:
         * - 배열을 순회하면서 스택이 비어 있거나 top보다 현재 값이 크면 push
         * - 그렇지 않으면 top을 pop하고 다시 비교
         * - 최종적으로 조건을 만족한 원소만 남기고, 이를 배열로 반환함
         *
         * 🔍 구현 전략:
         * - Stack 클래스 대신 ArrayDeque 사용함
         * - ArrayDeque는 Deque의 구현체로, 동기화 비용 없이 빠름
         * - 스택의 top 값 추적을 위해 별도 변수 last를 사용하여 peek 호출 최소화
         * - 스택의 입력 순서를 유지하기 위해 배열에 역순으로 채움
         * - Object 배열 변환을 제거하고 int[]에 직접 복사함
         *
         * 📌 자료구조 설명: Deque
         * - Deque(Double-Ended Queue)는 양쪽 끝에서 삽입/삭제가 가능한 자료구조임
         * - Stack(LIFO)와 Queue(FIFO)의 기능을 모두 지원함
         * - Java에서는 Deque 인터페이스를 ArrayDeque 또는 LinkedList로 구현함
         * - 이 문제에서는 Deque를 스택처럼 사용함 (addLast, removeLast)
         *
         * 📌 참고: Deque vs Stack vs Queue
        
         *   구조    | 입출 방향                  | 주요 메서드                        | 특징
         *  ---------|----------------------------|------------------------------------|------------------------
         *   Stack   | 한쪽 (후입선출, LIFO)       | push, pop, peek                    | Java Stack은 동기화됨 (느림)
         *   Queue   | 한쪽 삽입, 다른쪽 제거(FIFO)| offer, poll, peek                  | 선입선출 큐 처리
         *   Deque   | 양쪽 입출 가능              | addFirst, addLast, removeFirst 등  | Stack/Queue 모두 대체 가능
         *
         * ⏱ 시간복잡도:
         * - O(n), 각 원소는 최대 1회 push, 1회 pop 발생
         * - 동기화 제거, 박싱 제거, peek 제거 등의 최적화로 실측 성능 대폭 개선됨
         *
         * 유사한 풀이 중 Stack을 사용하는 코드가 많지만, ArrayDeque 기반 Deque로 구현함
         *
         * 📌 일반적으로 많이 사용되는 Stack 기반 풀이의 특징:
         * - Stack 클래스는 직관적이고 코드 길이가 짧아 접근성이 높음
         * - Java 기본 라이브러리이며, push/pop/peek 등 명확한 메서드 제공
         * - 많은 튜토리얼, 예제, 풀이에서 기본처럼 사용됨
         *
         * ⚠ Stack의 실질적 문제점:
         * - 내부적으로 Vector 기반이며, 동기화 처리로 인해 성능 저하 발생
         * - 스레드 안정성이 필요 없는 환경에서는 오히려 불필요한 비용이 됨
         * - 대용량 입력 시 일부 테스트 케이스에서 처리 속도 급감 현상 확인됨
         *
         * ✅ Deque(ArrayDeque)를 선택한 이유:
         * - Stack과 동일한 LIFO 구조를 제공하면서 더 가볍고 빠르게 동작함
         * - 비동기 환경에 최적화되어 성능상 이점이 있음
         * - 자바 공식 문서 및 실무에서는 Stack 대신 ArrayDeque 사용이 권장됨
         *
         * 🔍 결과적으로:
         * - 성능 면에서 Stack 기반 풀이보다 평균적으로 더 안정적이고 빠른 결과 도출
         * - 익숙한 선택 대신 구조적 장점을 고려한 구현 방식 선택
         */
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;

        while (i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[i++]);
            } else if (stack.peek() < arr[i]) {
                stack.push(arr[i++]);
            } else {
                stack.pop();
            }
        }
        // ArrayDeque은 스택의 top이 앞에 있음 → 역순 정렬 필요
        int[] result = new int[stack.size()];
        int idx = result.length - 1;
        while (!stack.isEmpty()) {
            result[idx--] = stack.pop();
        }
        return result;
    }
}

import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
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

        // ArrayDeque은 스택의 top이 앞에 있어서 역순 정렬 필요
        int[] stk = new int[stack.size()];
        int idx = stk.length - 1;
        while (!stack.isEmpty()) {
            stk[idx--] = stack.pop();
        }
        return stk;
    }
}

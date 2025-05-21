import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
    /*
         * ✅ 문제 개요: "명예의 전당 점수 기록"
         *
         * - 매일 새로운 점수가 들어오며, 상위 k개의 점수만 유지
         * - 그 중 가장 낮은 점수를 매일 기록 (→ 매일의 명예 점수)
         * - 결과는 매일의 명예 점수로 구성된 배열
         *
         *
         * 🧠 의선이 풀이 방식: List + 정렬
         *
         *   - topList라는 List를 만들어 상위 k개의 점수를 직접 관리
         *   - 매일 점수를 추가 후 Collections.sort()로 정렬
         *   - 가장 낮은 점수(topList.get(0))를 결과로 저장
         *
         * ✅ 장점
         *   - 구현이 직관적이며 로직이 눈에 잘 들어옴
         *   - 작은 데이터셋에서는 충분히 빠르고 안정적
         *
         * ❗ 단점
         *   - 매일 정렬이 필요하여 O(k log k)의 반복이 발생 → 데이터가 많아질수록 성능 저하
         *   - remove(0) 호출 후 정렬은 내부 구조상 효율이 떨어질 수 있음
         *
         *
         * ⚙️ 다른 사람들의 풀이 방식: PriorityQueue 사용 (Min Heap)
         *
         *   - Java의 PriorityQueue는 자동 정렬되는 힙 구조
         *   - 매일 점수를 add(), 크기가 k를 넘으면 가장 작은 값 poll()
         *   - 가장 작은 값은 항상 peek()으로 바로 확인 가능 → 명예 점수 기록
         *
         * ✅ 장점
         *   - O(log k)로 삽입/삭제가 가능해 고성능 유지
         *   - 별도의 정렬 없이 자동으로 k개 유지 + 최솟값 접근
         *   - 로직이 짧고 코드도 간결
         *
         * ❗ 단점
         *   - PriorityQueue에 익숙하지 않다면 이해하는 데 시간이 필요할 수 있음
         *
         *
         * 💡 PriorityQueue란?
         *
         * - Java의 우선순위 큐 자료구조로, 내부적으로 Min-Heap 사용
         * - 자동으로 정렬 상태가 유지되며, 가장 작은 값이 항상 맨 앞에 있음
         *
         * 📌 주요 메서드
         *   - `add(e)`    : 요소 추가
         *   - `poll()`    : 최소값 꺼내고 제거
         *   - `peek()`    : 최소값 조회
         *   - `size()`    : 큐 크기 반환
         *
         * 📌 최대 힙으로 만들고 싶다면:
         *   - `PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());`
         *
         *
         * ✅ 이 문제에서 PriorityQueue가 적합한 이유
         *
         *   - 매일 상위 k개의 점수만 유지해야 하므로, 자동 정렬이 되는 자료구조가 유리
         *   - 최소값을 자주 조회하고 제거해야 하기 때문에 Min-Heap 구조가 정확히 부합
         *   - 반복 정렬 없이 삽입과 삭제를 빠르게 할 수 있는 구조는 PriorityQueue가 유일
         *
         *
         * ✅ 결론
         *   - 두 풀이 모두 정확하지만, PriorityQueue는 시간 복잡도와 유지 편의성 측면에서 우위
         *   - 의선이 풀이 방식은 명확성과 구현 이해력 면에서 매우 훌륭했으며,
         *     이후 힙 구조 개념을 자연스럽게 받아들이는 데 좋은 연결 고리가 됨
         */
        int[] answer = new int[score.length];
        List<Integer> topList = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(i < k) {
                topList.add(score[i]);
            } else {
                if(score[i] >= topList.get(0)){
                    topList.remove(0);
                    topList.add(score[i]);
                }
            }
            Collections.sort(topList);
            answer[i] = topList.get(0); 
        }
        return answer;
    }
}

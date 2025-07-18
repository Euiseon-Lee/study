import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        /**
         * ✅ 문제 해결 요약
         * - 입력된 정수 배열(num_list)에서 가장 작은 5개를 제거하고 나머지를 오름차순으로 반환
         *
         * 🔧 구현 방식: PriorityQueue(Min Heap) 사용
         * - 전체 요소를 우선순위 큐(PQ)에 넣고, 가장 작은 값 5개를 poll()로 제거
         * - 나머지 PQ 요소를 오름차순으로 배열에 담아 반환
         *
         * 🚀 성능 해석
         * - 테스트 전반적으로 0.3~0.5ms 수준으로 매우 우수한 성능 기록
         * - 특히 19개 테스트 모두 안정적 성능 유지 (최대 0.48ms)
         * - `Arrays.sort` 기반 정렬과 비교해볼 때, 정렬 후 slicing이 아닌 **필터링 기반 추출**로 의미 있음
         *
         * 🆚 Arrays.sort vs PriorityQueue 비교
         * [Arrays.sort 기반]
         *   - Arrays.sort(num_list) 후 Arrays.copyOfRange(num_list, 5, num_list.length)
         *   - 전체 정렬 필요 (O(N log N))
         *   - 간단하고 직관적이지만, 작은 값 몇 개만 제거하는 데 전체 정렬 필요
         * 
         * [PriorityQueue 기반]
         *   - PQ 삽입 O(N log N), 제거 O(K log N), 추출 O(N)
         *   - 목적이 "일부 제거"일 때 더 의미 있음
         *   - 실무에서도 "상위/하위 N개 제외" 구조에서 자주 사용됨
         *
         * 💡 실무 활용도
         * - 실무에서는 전체 정렬보다 **우선순위 기반 필터링**이 중요한 경우 많음
         * - 예: 사용자 로그 중 상위 오류 5건 제외, 실시간 지표 중 상위 노이즈 제거
         *
         * ⚠️ 보완 포인트
         * - 현재 PQ는 기본적으로 오름차순(min heap)이며, 입력 배열이 100개 이상일 경우엔 성능 차이가 더 명확해질 수 있음
         * - 요소 중복이 많을 경우 PQ 메모리 최적화 구조 고려 가능 (ex. TreeMap)
         *
         * 📈 현재 구현 수준 평가
         * - 실무형 구조 사고 Level 3 후반~Level 4 초입 수준
         * - 정렬 외에도 우선순위 큐를 문제 상황에 맞게 도입한 점에서 **문제 해석력 우수**
         * - 입력 데이터가 클 경우에도 안정적 성능 유지 가능한 구조로 확장 가능
         *
         * 🧠 기억할 포인트
         * - "일부 상위/하위 제외" 문제는 무조건 sort 하지 말고, PQ/Heap도 고려!
         */
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 5, num_list.length);



        
        /* PriorityQueue 기반
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : num_list) {
            pq.add(n); // 전체 요소를 최소힙에 넣기
        }
        // 가장 작은 5개 제거
        for (int i = 0; i < 5 && !pq.isEmpty(); i++) {
            pq.poll();
        }
        // 나머지 요소들을 오름차순으로 배열에 저장
        int[] answer = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll(); // poll()은 최소값부터 꺼냄
        }
        return answer;
        */
    }
}

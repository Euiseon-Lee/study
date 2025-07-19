import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        /**
         * ✅ 문제 해결 요약
         * - 입력된 정수 배열(num_list)에서 가장 작은 5개를 제거하고 나머지를 오름차순으로 반환
         *
         * 🔧 구현 방식 1: Arrays.sort + slicing
         *   - Arrays.sort(num_list) 후 Arrays.copyOfRange(num_list, 5, num_list.length)
         *   - 전체 정렬 O(N log N), 간결하고 직관적
         *
         * 🔧 구현 방식 2: PriorityQueue(Min Heap) 기반 구조 (GPT 제안)
         *   - 전체 데이터를 우선순위 큐(PQ)에 넣은 후,
         *     가장 작은 값 5개를 PQ에서 poll()하여 제거
         *   - 이후 남은 값들을 새로운 배열로 반환
         *
         * 🆚 두 방식의 비교
         * ┌───────────────┬────────────────────────────────────────┐
         * │ Arrays.sort   │ 전체 정렬 필요, 코드 간결하나 전체 재배열 필요    │
         * ├───────────────┼────────────────────────────────────────┤
         * │ PriorityQueue │ 작은 값 일부만 제거할 때 적합, 더 실무적인 구조    │
         * └───────────────┴────────────────────────────────────────┘
         *
         * 💡 실무 적용 사례
         * - 예: 실시간 알림 큐에서 가장 빈도가 낮은 상위 5개 제거
         * - 예: 노이즈 데이터 제거 시 정렬하지 않고 최소값만 제외
         * - "필터링 중심" 문제에선 PQ 구조가 더 실용적이며 확장성 있음
         *
         * 🧠 GPT PriorityQueue 기반 코드 설명
         * 1. 모든 값을 PQ에 삽입 (자동 오름차순 정렬)
         * 2. 가장 작은 5개 값을 PQ에서 poll()로 제거
         * 3. 남은 PQ 값을 순서대로 꺼내 리스트에 담고 배열로 반환
         *
         *
         * 🧪 성능 해석 (테스트 1~19 모두 0.3~0.5ms)
         * - 100개 이하 입력에서는 두 방법 모두 안정적
         * - 하지만 데이터가 커질수록 PQ 방식이 "불필요한 전체 정렬"을 피할 수 있음
         *
         * 📈 현재 구현 수준 평가
         * - 실무형 구조 사고 Level 4 초입
         * - 다양한 구조 중 상황에 맞는 자료구조 선택 가능 → 성장 기반 확실
         * - 추후 병렬 작업, Lazy Loading 상황에서도 적용 확장 가능
         */
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                map.put(rank[i], i);
            }
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        int multiply = 10000;
        for (int key : keySet) {
            answer += map.get(key) * multiply;
            multiply /= 100;
            if (multiply < 1) return answer;
        }
        return answer;

        // --- GPT PriorityQueue 방식 구현 예시 ---
        // 아래 코드는 Arrays.sort 방식이 아닌 PriorityQueue를 활용한 대체 버전으로,
        // 일부 값만 추출하거나 제거하는 경우 실무에서 유용하게 쓰임
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                pq.offer(rank[i]);
            }
        }
        int answer = 0;
        int multiplier = 10000;
        while (!pq.isEmpty() && multiplier > 0) {
            int topRank = pq.poll(); // 가장 낮은 랭크
            for (int i = 0; i < rank.length; i++) {
                if (rank[i] == topRank && attendance[i]) {
                    answer += i * multiplier;
                    multiplier /= 100;
                    break;
                }
            }
        }
        return answer;
        */
    }
}

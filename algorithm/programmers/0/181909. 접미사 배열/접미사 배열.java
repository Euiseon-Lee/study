import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        /**
         * 🔠 접미사 정렬 문제
         *
         * 문자열 my_string의 모든 접미사를 구한 뒤, 이를 사전순으로 정렬하여 문자열 배열로 반환함
         *
         * 현재 구현은 ArrayList에 substring(i)를 순차적으로 추가한 뒤,
         * Collections.sort()를 사용하여 사전순 정렬을 수행하고,
         * list.toArray(new String[0])을 통해 배열로 반환함
         *
         * ✅ 장점
         * - PriorityQueue 대신 List를 사용하여 모든 데이터를 한 번에 정렬함
         * - Collections.sort()는 내부적으로 TimSort 알고리즘을 사용하므로
         *   평균 및 최선 케이스에서 매우 빠름
         * - 배열 반환 시 new String[0]을 사용하여, 타입 정보를 전달하면서
         *   가독성 있고 안정적으로 처리함
         *
         * 🔍 list.toArray(new String[0]) 설명
         * - toArray(T[] a)는 리스트를 동일한 타입의 배열로 복사함
         * - new String[0]은 반환될 배열 타입을 명시하는 역할
         * - 리스트 크기보다 작은 배열이 주어질 경우, JVM이 자동으로 정확한 크기의 배열을 생성하여 채움
         * - Java 6 이후부터는 new String[0]을 사용하는 방식이 일반화되었으며,
         *   명확한 타입 전달과 내부 최적화를 통해 안정적이고 간결한 구조를 제공함
         *
         * 🛠 개선된 전체 코드 예시
         *
         *     List<String> list = new ArrayList<>();
         *     for (int i = 0; i < my_string.length(); i++) {
         *         list.add(my_string.substring(i));
         *     }
         *     Collections.sort(list);
         *     return list.toArray(new String[0]);
         *
         * ⏱ 성능
         * - 리스트 추가: O(n)
         * - 정렬: O(n log n)
         * - 배열 변환: O(n)
         * - 총 시간복잡도: O(n log n)
         *
         * 🧠 정리
         * - PriorityQueue를 사용하는 구조보다 전체 정렬이 필요한 경우엔 List 정렬 방식이 평균적으로 더 효율적임
         * - 특히 접미사를 한번에 정렬하는 문제에서는 List + sort + toArray 조합이 간결하고 직관적임
         * - toArray 사용 시 new String[0]은 타입 안전성과 최적화된 처리 방식 모두를 충족함
         */
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < my_string.length(); i++) {
            pq.add(my_string.substring(i));
        }
        String[] answer = new String[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}

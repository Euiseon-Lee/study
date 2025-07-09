import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        /**
         * ✅ 문제 요약  
         *  - 정수 배열 `num_list`에서 가장 작은 5개의 값을 오름차순으로 정렬하여 반환  
         *
         * 🔁 로직 구조  
         *  - `Arrays.sort(num_list)`로 오름차순 정렬  
         *  - 정렬된 배열에서 앞의 5개 요소를 `Arrays.copyOf()`로 복사해 반환  
         *
         * ✅ 코드 품질 평가  
         *  - 한 줄로 정렬 및 슬라이싱을 수행하여 간결함  
         *  - `copyOf()`는 배열 길이를 안전하게 제한할 수 있는 메서드로 적절히 사용됨  
         *
         * ⚠️ 주의할 점  
         *  - `Arrays.sort()`는 **입력 배열 자체를 변경함**  
         *    → 실무에서는 원본 배열이 필요한 경우 `clone()`을 먼저 사용하거나, stream을 통한 정렬 사용 고려  
         *  - 예: `int[] sorted = Arrays.stream(num_list).sorted().toArray();`  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(n log n) (배열 전체 정렬)  
         *  - 공간복잡도: O(1) (copyOf는 정렬된 배열에서 앞쪽만 참조)  
         *  - 테스트 결과: 0.32ms ~ 0.51ms로 전체적으로 빠르고 안정적인 처리  
         *
         * 🛠 실무 활용도  
         *  - 상위/하위 n개 요소를 추출할 때 자주 등장하는 패턴  
         *  - 원본 보존이 중요한 경우 clone() 또는 stream 정렬로 side effect 방지 필요  
         *  - 수가 많고 n이 작을 경우, 굳이 전체 정렬하지 않고 **우선순위 큐(힙)** 사용해도 O(n log k)로 최적화 가능  
         */
        Arrays.sort(num_list);
        return Arrays.copyOf(num_list, 5);
    }
}

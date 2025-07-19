import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        /**
         * ✅ 문제 해결 요약
         * - 주어진 배열 arr에서 delete_list에 포함되지 않은 요소만 추출하여 새로운 배열로 반환하는 문제
         *
         * 🔧 현재 구현 방식: 중첩 반복문 기반 필터링
         * - arr의 각 요소에 대해 delete_list를 순회하며 포함 여부를 검사
         * - 포함되지 않은 경우 ArrayList에 추가 후 배열로 변환
         * - 시간 복잡도: O(n × m) (n: arr.length, m: delete_list.length)
         *
         * ⚙️ 성능 해석 (문제 조건 기반)
         * - delete_list의 최대 길이: 100, 값 범위: 1~1000
         * - 따라서 단순 이중 반복문 구조도 전혀 문제가 되지 않음
         * - 테스트에서도 1.7ms~2.8ms 사이의 안정적 성능 확인
         *
         * 🆚 Set 구조 사용 여부 비교
         * [중첩 for문 방식]
         *   - 장점: 공간 사용 없음, 구현 직관적
         *   - 단점: delete_list 길이가 수천 이상이면 성능 저하 가능
         *
         * [Set 기반 구조 (HashSet)]
         *   - 장점: 포함 여부 O(1)로 빠르게 판별 가능 → O(n)
         *   - 단점: 약간의 메모리 사용 필요
         *
         * 🧠 실무 확장성 고려
         * - delete_list가 외부 데이터로 유동적일 경우 (ex. DB 필터, 사용자 그룹 제외 등)
         *   → Set 사용이 구조적으로 안전하며 유지보수에도 유리
         *
         * 📈 현재 구현 수준 평가
         * - 주어진 조건에서 최적의 구조 선택 판단 → 실무 구조 사고 Level 3.5 이상
         * - 다만, 조건이 확장될 경우를 고려한 리팩토링도 경험해보는 것이 좋음
         *
         * 💡 Set 기반 개선 코드 예시:
         *   Set<Integer> deleteSet = new HashSet<>();
         *   for (int n : delete_list) deleteSet.add(n);
         *   List<Integer> result = new ArrayList<>();
         *   for (int n : arr) if (!deleteSet.contains(n)) result.add(n);
         *   return result.stream().mapToInt(Integer::intValue).toArray();
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0, idx = 0; i < arr.length; i++) {
            int target = arr[i];
            for (int j = 0; j < delete_list.length; j++) {
                if (delete_list[j] == target) break;
                if (j == delete_list.length - 1) list.add(target);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

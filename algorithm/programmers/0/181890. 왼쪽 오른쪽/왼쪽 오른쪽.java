import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        /**
         * 📌 문자열 배열 내 특정 방향 문자(l 또는 r) 기준 절단 (String.join + indexOf 방식)
         *
         * ✅ 핵심 로직
         * - 문자열 배열을 하나의 문자열로 결합: String.join("", str_list)
         * - 결합된 문자열에서 'l', 'r'의 위치를 indexOf로 파악하여 비교
         * - 'l'이 먼저 나오면 왼쪽 구간 추출, 'r'이 먼저 나오면 오른쪽 구간 추출
         * - 모두 없을 경우 빈 배열 반환
         *
         * ✅ 성능 분석 및 한계
         * - 시간복잡도: O(n) 이상
         *   - join() 연산: 문자열 병합 비용 발생 (O(n))
         *   - indexOf(): 문자열 탐색 O(n)
         *   - copyOfRange(): 배열 추출 O(k)
         * - 총합적으로 n이 작을 땐 문제없으나, n이 커질 경우 메모리와 연산 낭비 증가
         *
         * ⚠️ 실무에서의 단점
         * - 문자열로 합칠 필요가 없는 상황임에도 불필요한 병합 작업 포함
         * - indexOf는 결합된 문자열 기준이므로 실제 배열의 인덱스와 다를 수 있어, 오류 가능성 존재
         * - 배열 내 위치 추적은 배열 자체를 순회하며 확인하는 방식이 더 직관적이며 안전함
         *
         * ✅ 실무적 대안
         * - for-loop로 str_list를 순회하며 첫 번째 'l' 또는 'r'의 인덱스를 직접 찾는 방식 권장
         * - 단일 루프(O(n))로 탐색과 절단 포인트 결정 → 메모리와 성능 모두 안정적
         *
         * ✅ 예시 코드 (현재 방식)
         *   - 테스트 기준 통과하지만, 실무에서는 지양할 패턴
         *
         * class Solution {
         *     public String[] solution(String[] str_list) {
         *         String joined = String.join("", str_list);
         *         int leftIdx = joined.indexOf("l");
         *         int rightIdx = joined.indexOf("r");
         * 
         *         // l, r 모두 없을 경우 → 빈 배열
         *         if (leftIdx == -1 && rightIdx == -1) return new String[0];
         * 
         *         // l이 먼저 나올 경우 → 왼쪽 추출
         *         if (leftIdx != -1 && (rightIdx == -1 || leftIdx < rightIdx)) {
         *             return Arrays.copyOfRange(str_list, 0, leftIdx);
         *         }
         * 
         *         // r이 먼저 나올 경우 → 오른쪽 추출
         *         if (rightIdx != -1 && (leftIdx == -1 || rightIdx < leftIdx)) {
         *             return Arrays.copyOfRange(str_list, rightIdx + 1, str_list.length);
         *         }
         * 
         *         return new String[0];
         *     }
         * }
         */
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                return Arrays.copyOfRange(str_list, 0, i);
            } else if (str_list[i].equals("r")) {
                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
            }
        }
        return new String[0];
    }
}

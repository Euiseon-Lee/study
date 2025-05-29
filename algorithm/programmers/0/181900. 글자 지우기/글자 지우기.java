import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        /**
         * 🔁 인덱스 역순 삭제로 안정성 확보한 문자 제거 로직
         *
         * ✅ 개선 포인트 (기존 방식과의 차이)
         * - 기존: 앞에서부터 제거 → 인덱스 보정(`deleteCharAt(indices[i] - i)`) 필요
         * - 개선: 뒤에서부터 제거 → 삭제 순서에 따른 시프트가 발생하지 않음 → 보정 불필요
         *
         * ✅ 이점
         * - 코드가 간결해지고 버그 발생 가능성 줄어듦
         * - 특히 보정 계산이 틀리기 쉬운 상황(복잡한 조건/불규칙한 인덱스)에서 안정적
         * - 성능 차이는 미세하지만, 코드 안정성과 유지보수 측면에서 실무에 적합
         *
         * ✅ 실무 팁
         * - **삭제는 역순, 삽입은 정순**이 기본 원칙
         * - 다수의 인덱스를 기반으로 삭제하는 경우, 항상 인덱스 시프트 유무를 고려할 것
         * - 정렬된 배열에서 뒤에서부터 접근하면 무효 연산 없이 정확한 삭제가 가능함
         *
         * ✅ 정리
         * - 이 방식은 단지 성능이 아닌, **코드의 신뢰성**을 높이는 전략이야
         * - 동작은 같더라도, 버그 가능성을 줄인 설계는 장기적으로 큰 차이를 만들어
         */
        StringBuilder answer = new StringBuilder(my_string);
        Arrays.sort(indices);
        /*
        for(int i = 0; i < indices.length; i++) {
            answer.deleteCharAt(indices[i] - i);
        }
        */
        for (int i = indices.length - 1; i >= 0; i--) {
            answer.deleteCharAt(indices[i]);
        }
        return answer.toString();
    }
}

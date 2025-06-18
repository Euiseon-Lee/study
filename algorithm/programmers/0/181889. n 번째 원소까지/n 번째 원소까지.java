import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        /**
         * 📌 정수 배열 자르기 - 앞에서 n개 추출
         *
         * ✅ 핵심 로직
         * - Arrays.copyOfRange() 메서드를 이용해 num_list의 앞에서부터 n개 요소만 잘라서 새로운 배열로 반환
         * - copyOfRange(arr, from, to)는 [from, to) 구간을 복사하는 표준 API임
         *
         * ✅ 성능 분석
         * - 시간복잡도: O(n) (실제 복사되는 원소 수만큼)
         * - 공간복잡도: O(n) (새 배열을 생성하므로)
         * - 매우 빠른 실행 속도 (테스트 결과 평균 0.02ms 이하)
         *
         * ✅ 실무 활용도
         * - 페이징 처리 시 "앞에서 일정 개수 추출"
         * - 상위 N개 데이터 처리, 미리보기 리스트 구성 등에 자주 사용
         * - 클린한 추출 방식으로 후속 필터링/정렬 전 사전 처리용으로 적합
         *
         * ✅ 보완 포인트
         * - 유효하지 않은 n 값(예: n > num_list.length)이 들어올 경우 ArrayIndexOutOfBoundsException 발생
         *   → 실무에서는 Math.min(n, num_list.length) 같은 보호 로직을 추가하는 게 좋음
         * - 배열이 null이거나 빈 배열인 경우 예외 처리를 해야 안전
         *
         * ✅ 예시 개선 코드 (방어 로직 추가)
         *   int safeN = Math.min(n, num_list.length);
         *   return Arrays.copyOfRange(num_list, 0, safeN);
         */
        return Arrays.copyOfRange(num_list, 0, n);
    }
}

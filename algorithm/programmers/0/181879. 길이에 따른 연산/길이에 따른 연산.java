class Solution {
    public int solution(int[] num_list) {
        /**
         * 📌 배열 길이에 따라 곱셈 또는 덧셈 연산 수행
         *
         * ✅ 핵심 로직
         * - 배열 길이가 11보다 작으면 모든 원소를 곱하고,
         *   11 이상이면 모든 원소를 더함
         * - 조건에 따라 boolean 플래그(`isMultiply`)로 분기하여 하나의 루프에서 처리
         *
         * ✅ 성능 분석
         * - 시간복잡도: O(n), n은 배열의 길이 (최대 1000 이하 가정 시 매우 우수)
         * - 공간복잡도: O(1), 누적 결과만 저장
         * - 테스트 기준 실행 시간: 0.02 ~ 0.04ms → 매우 빠름
         *
         * ✅ 실무 활용도
         * - 데이터 크기에 따라 처리 방식이 달라지는 **조건 기반 누산 구조** 예시
         * - 동적 계산 플래그를 조건문 밖으로 미리 분리하면 가독성과 성능에 모두 유리
         * - 실무에서는 `map-reduce` 연산 (ex: stream reduce) 또는 가변 조건 처리에서 유사 패턴 사용
         *
         * ✅ 보완 포인트
         * - 곱셈을 수행할 때 오버플로우 가능성이 있으므로 실무에서는 `long` 또는 `BigInteger`로 방어 필요
         * - 코드 가독성을 위해 `isMultiply ? a * b : a + b` 대신 명시적 분기 처리도 고려 가능
         *
         * ✅ 구조 요약
         * - 조건부 누산 패턴 (Conditional Accumulation)
         * - 분기 로직을 루프 외부에서 설정 → 루프 내 연산은 단순화
         */
        boolean isMultiply = num_list.length < 11;
        int answer = num_list[0];
        for (int i = 1; i < num_list.length; i++) {
            answer = isMultiply ? answer * num_list[i] : answer + num_list[i];
        }
        return answer;
    }
}

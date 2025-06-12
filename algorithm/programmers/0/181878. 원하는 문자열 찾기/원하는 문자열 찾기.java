class Solution {
    public int solution(String myString, String pat) {
        /**
         * 📌 문자열 포함 여부 대소문자 무시 비교
         *
         * ✅ 핵심 로직
         * - `myString`과 `pat`을 대문자로 변환 후, `contains()`를 이용해 포함 여부 판단
         * - 조건 연산자로 true면 1, false면 0을 반환
         *
         * ✅ 성능 관점
         * - `String.toUpperCase()`는 새 문자열 객체 생성 → 성능 상 단점 존재
         * - 두 번의 `toUpperCase()` 연산 후 `contains()`로 비교하므로 문자열 길이가 크면 비용 증가
         *
         * ✅ 실무 사용성
         * - 검색 엔진, 필터링 기능 등 대소문자 구분 없이 일치 여부 판단할 때 매우 유용
         * - 다만 성능이 중요한 상황에서는 `equalsIgnoreCase()` 또는 정규식 대안 고려 가능
         *
         * ✅ 보완 포인트
         * - `myString`이 매우 긴 경우, 대문자로 전환한 뒤 `contains` 하는 방식 대신 `regionMatches()`를 활용한 부분 비교가 성능상 유리할 수 있음
         * - 정규식 `(?i)` 패턴도 대안이 될 수 있음 (단, 가독성 감소 가능)
         */
        return myString.toUpperCase().contains(pat.toUpperCase()) ? 1 : 0;
    }
}

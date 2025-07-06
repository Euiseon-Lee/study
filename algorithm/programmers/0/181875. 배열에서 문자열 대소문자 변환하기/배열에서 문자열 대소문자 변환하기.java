class Solution {
    public String[] solution(String[] strArr) {
        /** 📌 인덱스 기반 대소문자 변환 문제 풀이 요약
         *
         * ✅ 핵심 로직
         * - 주어진 문자열 배열 `strArr`의 각 요소를 인덱스 기준으로
         *   짝수 인덱스는 소문자 (`toLowerCase()`), 홀수 인덱스는 대문자 (`toUpperCase()`)로 변환
         * - 조건문 없이 삼항 연산자(`? :`)를 통해 간결하게 처리
         *
         * ✅ 성능 분석
         * - 시간복잡도: O(n), n은 문자열 배열의 길이
         * - 공간복잡도: O(1), 입력 배열을 직접 수정하며 반환
         * - 실행 시간 평균 0.03~0.05ms로 매우 빠르게 동작함
         *
         * ✅ 실무 활용도
         * - 프론트 UI 정규화, 로그 필터링 등에서 인덱스 기반 텍스트 가공에 적합
         * - 다만 원본 배열을 수정하는 방식이라 불변성(immutability)을 유지해야 하는 환경에서는 부적합할 수 있음
         *
         * ✅ 보완 포인트
         * - 원본 배열을 보존하려면 `String[] result = Arrays.copyOf(strArr, strArr.length)` 후 처리
         * - 문자열이 null일 가능성은 제한사항에서 배제됐지만, 실무에서는 null 체크 필요
         * - 삼항 연산자가 익숙하지 않은 개발자에게는 가독성 저하 요소가 될 수 있으므로 협업 시 명시적 if-else도 고려
         *
         * ✅ 개선 예시 (불변성 보존용)
         * String[] result = new String[strArr.length];
         * for (int i = 0; i < strArr.length; i++) {
         *     result[i] = (i % 2 == 0) ? strArr[i].toLowerCase() : strArr[i].toUpperCase();
         * }
         * return result;
         */
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = i % 2 == 0 ? strArr[i].toLowerCase() : strArr[i].toUpperCase();
        }
        return strArr;
    }
}

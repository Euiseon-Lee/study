class Solution {
    public int solution(String s) {
        /**
         * 🔍 숫자 단어 치환 후 정수로 변환하는 문자열 파싱 문제
         *
         * ✅ 구현 평가
         * - "zero" ~ "nine"까지의 문자열을 모두 숫자로 바꾸는 요구사항을 정확히 반영함
         * - String.replaceAll()을 반복 호출하여 각 숫자 단어를 대응되는 숫자 문자열로 일괄 치환함
         * - 치환이 완료된 문자열을 Integer.parseInt로 변환하여 정수화함
         *
         * 🛠 실무적 구조 분석
         * - nums 배열을 인덱스로 직접 활용함으로써 단어와 숫자의 매핑을 명확히 유지함
         * - 불필요한 조건 분기 없이 치환 반복만으로 문제를 해결했으며, 코드 길이가 짧고 이해하기 쉬움
         * - 테스트 케이스 전반에서 안정적인 실행 속도를 보이며, 0.3~0.5ms 사이의 응답을 유지함
         *
         * ⚠️ replaceAll vs replace 차이
         * - replaceAll은 내부적으로 정규식을 사용하여 일치 항목을 치환함
         *   예: replaceAll("one", "1") → "oneoneone" → "111"
         * - replace는 단순한 문자열 기반의 치환이며, 성능과 안정성 측면에서 더 가볍고 빠름
         *   예: replace("one", "1") → "oneoneone" → "111"
         * - 둘 다 **모든 일치 항목을 치환**하며, replace는 첫 번째 항목만 바꾼다는 오해는 사실 아님
         * - 정규식이 필요 없는 경우에는 replace가 명확하게 더 적절한 선택임
         *
         * ✅ 개선 포인트
         * - 이 문제에서는 숫자 단어 자체를 단순 문자열로 치환하는 작업이기 때문에
         *   replaceAll → replace 로 변경하면 정규식 파싱 비용 없이 동일한 결과를 얻을 수 있음
         * - 예외적인 문자열(예: ".", "*", "\\")이 없다면 replace가 기본 선택지로 권장됨
         *
         * 🧠 정리
         * - 문제 요구사항을 정확히 해석하고, 가장 단순하고 직관적인 방식으로 구현함
         * - replaceAll 대신 replace를 사용하면 불필요한 정규식 해석을 줄일 수 있어 성능에 이점이 있음
         * - 코드 의도와 성능, 안정성까지 모두 고려한 깔끔한 구현 예시
         */
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven"
                      , "eight", "nine"};
        for (int i = 0; i < nums.length; i++) {
            s = s.replace(nums[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}

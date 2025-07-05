class Solution {
    public String solution(String my_string, String alp) {
        /** 🔡 소문자 1글자를 대문자로 치환 – replaceAll vs replace
        
         * ✅ 문제 전제
         * - alp는 반드시 1글자의 영소문자 (예: "a", "b", "c" …)
         * - my_string 역시 영소문자로만 구성 → 정규표현식 특수문자 입력 가능성 없음
         * → 이 경우 `replaceAll()`은 안전하게 동작하며 별도의 이스케이프 처리 불필요
        
         * ✅ replaceAll 사용의 의의
         * - 일반적으로 정규표현식 기반 치환을 할 때 쓰지만,
         *   이 문제에서는 **alp가 단일 소문자라는 보장**이 있기 때문에 성능상 큰 문제 없음
         * - 코드가 간결하고, 한 줄로 처리 가능하다는 장점 있음
        
         * ⚠️ 성능 관점 주의
         * - 내부적으로 Pattern 객체를 컴파일하며, replace보다 약간 더 비용이 큼
         *   → 문제의 문자열 길이 제한이 1,000이므로 체감 성능 차이는 거의 없음
         * - 단, 이 패턴이 반복 사용되거나 매우 빈번한 처리일 경우 `replace()`로의 변경이 성능에 도움 될 수 있음
        
         * ✅ 실무 팁
         * - `replaceAll()`은 보안성/성능 측면에서*입력값이 신뢰되지 않거나 정규식 특수문자를 포함할 수 있을 때는 피해야 함
         * - 지금처럼 입력 범위가 정해져 있고 제약이 엄격할 경우, 간결성을 위해 `replaceAll()` 선택 가능
         * - 코드 리뷰 시에는 "의도적 사용"이라는 설명 코멘트를 남기는 것이 좋음
        
         * ✅ 요약
         * - replaceAll: 지금 문제에선 정규표현식 해석 이슈 없음 → 정상 동작함
         * - replace: 일반적으로 더 안전하고 빠르며, 특수문자 이슈도 없음
         * - 지금 문제에선 둘 다 가능하며, replaceAll 선택이 잘못된 것은 아님
        
         * ✅ 대체 코드 (성능 우선 + 정규식 회피)
         *   return my_string.replace(alp.charAt(0), Character.toUpperCase(alp.charAt(0)));
         */
        return my_string.replaceAll(alp, alp.toUpperCase());
    }
}

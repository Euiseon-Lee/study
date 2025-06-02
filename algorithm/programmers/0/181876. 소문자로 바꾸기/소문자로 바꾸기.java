class Solution {
    public String solution(String myString) {
        /**
         * 🔍 문제 해결 로직 요약
         * - 입력 문자열을 모두 소문자로 변환
         * - Java의 toLowerCase()는 유니코드 기반으로 작동하며, Locale에 따라 결과가 달라질 수 있음
         *
         * ✅ 성능
         * - O(n): 문자열을 한 글자씩 순회하여 소문자로 변환
         * - 테스트 평균 0.01~0.03ms로, 성능상 이슈 없음
         *
         * 🌐 Locale 개념 설명
         * - Locale은 언어 + 국가 조합으로, 언어별 문자의 대소문자 규칙, 날짜/숫자 형식 등을 정의함
         *   예) Locale.ENGLISH → 영어, Locale.KOREA → 한국어, Locale("tr") → 터키어
         *
         * ⚠️ 주의 사례: 터키어 이슈
         * - "I".toLowerCase(Locale.US) → "i"
         * - "I".toLowerCase(new Locale("tr")) → "ı" (점 없는 소문자 i)
         *   → 시스템 로케일이 터키어이면 예기치 않은 결과 가능성 있음
         *
         * 🎯 실무 팁
         * - toLowerCase(), toUpperCase()는 Locale 영향을 받기 때문에 항상 명시적 설정이 안전
         *   ex) myString.toLowerCase(Locale.ROOT) ← 중립 로케일로 환경에 의존하지 않음
         * - Locale.ROOT는 언어/국가 정보가 없는 중립적 로케일로, 테스트나 서버사이드 로직에 권장
         * - 사용자 입력을 다루는 앱이라면, 사용자의 로케일을 받아서 변환하는 방식도 고려함
         *
         * 🧩 보완 포인트
         * - null 입력에 대한 안전 처리 습관화 (NPE 방지)
         * - 단순 API 호출도 로케일/유니코드 맥락을 이해하고 사용할 것 → 실무 대응력 강화
         */
        return myString.toLowerCase();
    }
}

class Solution {
    public String solution(String myString) {
        /** 🔡 문자열 소문자화 + 'a'만 대문자로 변환
         *
         * ✅ 문제 핵심
         * - 주어진 문자열을 모두 소문자로 바꾼 뒤, 문자 'a'만 'A'로 변환
         *
         * ✅ 네 원래 풀이 방식
         * - ASCII 범위 수동 계산 (c + 32) 방식으로 소문자화 진행
         * - 이후 `.replaceAll("a", "A")`로 정규표현식 기반 문자열 치환
         *
         * ⚠️ 성능 저하 원인
         * - replaceAll("a", "A")는 정규식 처리로 내부적으로 Pattern 객체 생성 및 매칭 수행 → 연산 비용 큼
         * - 문자열이 길어질수록 GC 및 연산량이 증가하여 성능 하락
         * - ASCII 수동 조작은 성능엔 영향 적지만, 가독성과 유지보수성이 떨어짐
         *
         * ✅ 개선 코드 (빠른 실행시간)
         *   StringBuilder sb = new StringBuilder();
         *   for (char c : myString.toCharArray()) {
         *       char lower = Character.toLowerCase(c);
         *       sb.append(lower == 'a' ? 'A' : lower);
         *   }
         *   return sb.toString();
         *
         * ✅ 성능 이점
         * - Character.toLowerCase(): JDK 최적화된 native 메서드로 빠름
         * - replaceAll 제거 → 정규식 패턴 매칭 비용 제거
         * - StringBuilder 사용으로 문자열 누적 시 힙 메모리 사용 최소화
         * - 전체 로직이 단일 루프로 구성되어 O(n) 시간복잡도 유지
         *
         * ✅ 실무 팁
         * - 정규표현식은 성능이 중요한 문자열 처리 루틴에서 가급적 피할 것
         * - 반복적 문자열 변경이 필요할 경우 StringBuilder를 사용하여 GC/성능 최적화
         * - 문자열 로직은 명시적 분기와 순회로 처리하면 디버깅과 유지보수에 유리
         */
        StringBuilder answer = new StringBuilder();
        for (char c : myString.toCharArray()) {
            answer.append(Character.toString(c + (c > 65 && c < 97 ? 32 : 0)));
        }
        return answer.toString().replaceAll("a", "A");
    }
}

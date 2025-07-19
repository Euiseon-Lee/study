class Solution {
    public int solution(String my_string, String target) {
        /**
         * ✅ 문제 해결 요약
         * - 문자열 my_string 내에 부분 문자열 target이 포함되어 있는지 검사
         * - 포함 시 1, 아니면 0 반환
         *
         * 🔧 사용 메서드: String.contains(CharSequence)
         *   - 내부적으로 indexOf(target) >= 0 방식
         *
         * 💡 실무 활용
         * - 검색 기능(검색어 포함 여부 판단)
         * - 입력 검증(특정 키워드 필터링 등)
         * - 단순 조건 분기 시 매우 빠른 대응 구조
         *
         * 🧪 성능
         * - O(N*M) 수준 (my_string 길이 * target 길이)
         *   → 일반 텍스트에서 매우 빠르고, 정규표현식보다 경량
         *
         * 📌 대체 메서드 비교
         * - contains() → 포함 여부(boolean)
         * - indexOf() → 위치 반환(-1이면 미포함)
         * - matches() → 정규식 기반 매칭 (비교적 느림)
         */        
        return my_string.contains(target) ? 1 : 0;
    }
}

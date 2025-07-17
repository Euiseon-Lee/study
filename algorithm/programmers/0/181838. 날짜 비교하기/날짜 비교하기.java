class Solution {
    public int solution(int[] date1, int[] date2) {
        /**
         * ✅ 문제 해결 전략 요약
         *
         * 📌 목적: 두 날짜 배열(date1, date2)을 비교하여 date1이 빠르면 1, 아니면 0 반환
         *
         * 🧭 비교 방식:
         *   1️⃣ 연도 비교 → 작으면 무조건 빠름
         *   2️⃣ 연도가 같으면 월 비교
         *   3️⃣ 월도 같으면 일 비교
         *   4️⃣ 모든 항목이 동일하거나 date1이 늦으면 0 반환
         *
         * ⚙️ 성능 이점:
         *   - 비교 최대 3회 → 시간복잡도 O(1)
         *   - 불필요한 연산 없음 → 조건 일치 즉시 리턴
         *
         * 💼 실무 관점:
         *   - 실제 업무에서는 LocalDate, Date, Calendar 클래스를 사용해 비교
         *     예: `LocalDate.of(...)` → `.isBefore()`, `.compareTo()` 활용
         *   - 그러나 알고리즘 문제에선 가볍고 빠른 배열 비교 방식이 효율적
         *
         * 🧠 현재 실력 피드백:
         *   🎯 GPT 기준 Level 3 후반
         *   🔍 조건 분기와 반복 최소화를 잘 이해하고 있음
         *   ☑️ 안정적인 조건 판단 흐름 → 오류 가능성 낮고 실용적 구조
         */
        for (int i = 0; i < date1.length; i++) {
            if (date1[i] < date2[i]) {
                return 1;
            } else if (date1[i] > date2[i]) {
                return 0;
            }
        }
        return 0;
    }
}

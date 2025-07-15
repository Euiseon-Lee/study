class Solution {
    public int solution(String[] order) {
        /**
         * ✅ 문제 요약
         *  - 메뉴 배열에서 각 주문 항목에 따라 아메리카노(4500원) 또는 카페라떼(5000원)로 분기하여 총 금액 계산
         *  - 메뉴가 불완전하거나 "anything"인 경우 차가운 아메리카노(4500원)로 처리
         *
         * ✅ 핵심 분기 처리 구조
         *  🎯 완전 문자열 (hot/ice + 메뉴 조합): 가격만 판단하면 됨
         *  ❗ 부분 문자열 ("cafelatte", "americano", "anything") → 별도 처리 필요
         *      → "anything"은 아메리카노로 간주
         *
         * ✅ 현재 코드 방식
         *  ✅ 장점: contains("cafelatte")만으로 분기 처리 → 간단
         *  ⚠️ 단점:
         *    - "americano"로 끝나는 문자열은 cafelatte가 아닌데도 false → 명확하진 않음
         *    - "anything"도 "americano"로 취급되므로 의도 파악이 불명확해짐
         *
         * ✅ 추천 개선 코드 (명시적 처리)
         *  for (String str : order) {
         *      if (str.equals("cafelatte") || str.contains("cafelatte")) {
         *          answer += 5000;
         *      } else {
         *          answer += 4500;
         *      }
         *  }
         *  📌 또는: Set을 활용한 정확한 문자열 매핑 방식으로도 개선 가능
         *
         * ✅ 성능
         *  ⚡ 시간 복잡도: O(n * m) 수준 (n = order 길이, m = 문자열 평균 길이)
         *  ✅ 테스트 전량 통과, 최대 0.77ms → 문제 없음
         *
         * ✅ 실무형 수준 평가
         *  - 레벨 3: 명확한 조건문 분기는 필요하나, 실제 로직 구조는 잘 반영됨
         *  - 개선을 통해 실무 품질 레벨 4 수준 도달 가능
         */
        int answer = 0;
        for (String str : order) {
            if (str.contains("cafelatte")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }
        return answer;
    }
}

class Solution {
    public String solution(String[] str_list, String ex) {
        /**
         * ✅ 문제 요약
         *  - 문자열 배열 str_list에서 특정 문자열 ex를 포함하지 않는 문자열만 골라
         *    모두 이어붙인 결과 문자열을 반환하는 문제
         *
         * 🔁 기존 코드 흐름
         *  - StringBuilder sb 초기화
         *  - 배열 순회하면서 각 문자열이 ex를 포함하지 않을 경우만 sb에 추가
         *  - 최종적으로 sb.toString() 반환
         *
         * 💡 개선 포인트
         *  - 성능상 큰 문제는 없지만, 다음과 같은 미세 최적화 가능
         *    1) 향상된 for문 사용으로 가독성 향상 가능
         *    2) str.contains(ex)의 경우 ex가 null일 경우 NPE 발생 → 실무에서는 방어 로직 필요
         *    3) 예외가 아니라면 현재 구조는 거의 최적 수준
         *
         * ⚙️ 성능 분석
         *  - 시간복잡도: O(n * m) (n = str_list.length, m = 평균 문자열 길이)
         *  - contains는 내부적으로 indexOf를 호출 → 최악 O(m), 평균 매우 빠름
         *  - StringBuilder 사용 → 문자열 누적 시 concat보다 훨씬 효율적
         *  - 테스트 결과 모든 케이스에서 0.03 ~ 0.06ms로 안정적이고 빠름
         *
         * 🧠 배열 및 문자열 처리 팁
         *  - 문자열 누적 시 반드시 StringBuilder 사용 (+=로 누적 시 O(n²) 발생 가능)
         *  - 조건 필터링과 누적을 분리하면 Stream 활용도 가능 → 실무 확장성 향상
         *
         * 🛠 실무 활용도
         *  - 이메일 필터링, 로그 라인 필터, 특정 키워드 제거 등 다양한 실무 시나리오에 자주 등장
         *  - 로직이 명확하고 확장도 쉬운 구조
         *
         * 🧠 현재 구현 수준 평가
         *  - 문자열 누적 최적화, 조건 분기 구조, 내장 메서드 사용에서 실무 구조 사고 Level 3 상위 수준
         *  - 성능 감각과 코드 간결성 사이 균형 잘 잡힘
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str_list.length; i++) {
            if (!str_list[i].contains(ex)) sb.append(str_list[i]);
        }
        return sb.toString();
    }
}

class Solution {
    public String solution(int q, int r, String code) {
        /**
         * 🔍 문제 해결 로직 요약
         * - 주어진 문자열 code에서 인덱스 % q == r인 문자만 추출하여 새로운 문자열로 반환
         * - for (int i = r; i < code.length(); i += q) 구조로 반복하여 조건에 맞는 인덱스만 처리
         *
         * ✅ 성능
         * - O(n/q): 전체 문자열을 순회하지 않고 필요한 인덱스만 건너뛰며 처리
         * - StringBuilder 사용 → 문자열 누적 시 불필요한 메모리 할당 방지
         * - 테스트 평균 0.03~0.06ms, 모든 케이스 빠르고 안정적
         *
         * 🎯 실무 팁
         * - 반복 규칙이 명확할 때는 stream보다 반복문이 성능과 예외 처리 면에서 유리
         * - 나머지 조건 필터링은 고정 포맷의 텍스트 파싱, 정해진 패턴 추출 등에 자주 활용됨
         *
         * 🧩 Stream 대체 예시 (Java 8+)
         *   public String solution(int q, int r, String code) {
         *       return IntStream.range(0, code.length())
         *                       .filter(i -> i % q == r)
         *                       .mapToObj(i -> String.valueOf(code.charAt(i)))
         *                       .collect(Collectors.joining());
         *   }
         *   - IntStream.range → 0부터 code.length()까지 인덱스 생성
         *   - filter → i % q == r 조건 만족하는 인덱스만 통과
         *   - mapToObj → 각 인덱스를 문자열(char → String)로 변환
         *   - collect → StringBuilder 기반 join으로 최종 문자열 생성
         *
         * 🌐 Stream 사용 시 고려할 점
         * - 장점
         *   * 코드의 의도를 '무엇을 할 것인가' 중심으로 선언적으로 표현 가능
         *   * 필터링, 매핑, 수집 등 연산을 연쇄적으로 연결 가능 (파이프라인 구성)
         *   * 중간에 디버깅이 필요한 경우 peek() 메서드로 값 확인 가능
         * - 단점
         *   * mapToObj → String.valueOf → 매번 새로운 객체 생성 → GC 부하 증가
         *   * filter/map처럼 중간 연산은 람다 호출이 반복되어 성능이 일반 for문보다 느림
         *   * 디버깅이 어렵고, 중간 흐름 제어 (break, continue, return)가 불가능
         * - 성능 측면 요약
         *   * 1,000개 미만 데이터: for문과 큰 차이 없음, stream 사용 가능
         *   * 수천~수만 건 이상 반복: for문이 압도적으로 빠름
         *   * 고성능이 요구되는 반복문 내부에서는 stream 사용 지양
         *
         * 🧠 구조적 사고 평가
         * - 수학적 조건(i % q == r)을 반복 인덱스로 변환하여 직접 추출
         * - stream으로도 문제 해결 가능하지만, 이 경우 for문이 더 직관적이고 효율적
         * - 반복문과 stream의 선택 기준을 실무적 성능 감각으로 판단한 점이 강점
         */
        StringBuilder answer = new StringBuilder();
        for (int i = r; i < code.length(); i += q) {
            answer.append(code.charAt(i));
        }     
        return answer.toString();
    }
}

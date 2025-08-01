class Solution {
    public int solution(double flo) {
        /**
         * ✅ 문제 해결 요약
         * - double 타입 소수를 입력받아, 소수점 아래를 버린 정수형 값 반환
         *
         * 🔧 핵심 로직
         *   - (int) flo : 소수점 이하 버림 (내림 아님)
         *   - / 1 연산은 불필요한 코드이며 제거 가능
         *
         * 🧠 실무 응용 포인트
         *   - 소수점 이하 제거 → 금융 소수점 절삭, 단위 변환 등에 사용
         *   - 타입 캐스팅 주의: 음수일 경우 (int)-1.9 == -1 이므로 내림이 아님
         *
         * ✅ 예시
         *   - flo = 3.99 → (int) flo = 3
         *   - flo = -3.99 → (int) flo = -3
         *
         * ⚠️ 보완 포인트
         *   - `/ 1` 연산은 정수 결과를 다시 정수로 나누는 불필요한 연산 → 제거 권장
         */
        return (int) flo;
    }
}

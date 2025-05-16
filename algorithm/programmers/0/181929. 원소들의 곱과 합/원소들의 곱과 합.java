class Solution {
    public int solution(int[] num_list) {
        int product = 1, sum = 0;
    
        for (int num : num_list) {
            product *= num;
            sum += num;
        }

        /*
         * ✅ Math.pow vs 정수 곱셈
         * - Math.pow(a, 2)는 내부적으로 double 연산을 사용하고 결과도 double로 반환됨
         *   → 형변환 비용 + 부동소수점 연산 오버헤드 존재
         *
         * - a * a는 정수 곱셈으로 훨씬 빠르고 가볍다
         *
         * 💡 성능 테스트 결과:
         *   - Math.pow: 평균 0.04~0.06ms
         *   - 정수 곱셈: 평균 0.01~0.02ms
         *   → 정수 곱셈 방식이 최대 5배 가까이 빠름
         *
         * ✅ Math.pow vs 직접 연산 - 일반화 팁
         *
         * [제곱, 세제곱 등 정수 연산일 경우]
         * - Math.pow(a, n)은 double을 반환하며, 내부적으로 지수(log) 기반 계산을 수행함
         *   → 정수 정확도 보장이 필요하거나 루프 내에서 자주 호출되는 경우 성능 저하 발생 가능
         *
         * [추천 방식 요약]
         * - a^2 : Math.pow(a, 2) → ❌ →  ✅ a * a
         * - a^3 : Math.pow(a, 3) → ❌ →  ✅ a * a * a
         * - a^4~a^6 : 직접 곱셈 or 유틸 함수로 정의 (예: pow4(a) = a*a*a*a)
         * - a^0.5 (루트) : Math.sqrt(a) ✅ (정수 대체 불가)
         *
         * 💡 팁:
         * - pow 결과를 (int)로 캐스팅하면 부동소수점 오차가 생길 수 있음 (예: (int)Math.pow(10, 2) == 99일 수도!)
         * - 항상 int 연산이 가능한 경우에는 명시적 곱셈을 우선 고려
         */
        //return product < (int) Math.pow(sum, 2) ? 1 : 0;
        return product < (sum * sum) ? 1 : 0;
    }
}

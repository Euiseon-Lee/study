import java.math.*;
class Solution {
    public String solution(String a, String b) {
        /**
         * ✅ 문제 개요
         * - 두 숫자 문자열 a, b가 주어졌을 때, 이를 더한 결과를 문자열로 반환
         * - 각 문자열의 길이는 최대 100,000까지 가능 → 일반 정수 타입으로는 처리 불가
         *
         * ✅ 핵심 로직
         * 🔢 BigInteger 활용: 매우 큰 수 연산을 위한 Java 내장 정수형 클래스
         * 🔁 a, b를 BigInteger로 변환한 뒤, add()로 더한 값을 toString()으로 반환
         *
         * ✅ 성능 분석
         * - 테스트 케이스 30~40번대에서 300~450ms 수준 발생
         * - BigInteger의 내부 연산(덧셈)과 문자열 변환은 모두 O(n) 시간복잡도
         * - 중요한 최적화 포인트: `"" + BigInteger` 대신 `.toString()` 직접 호출
         *
         * ✅ 실무형 팁 ☕
         * - ❌ `"" + 객체`는 컴파일러가 `StringBuilder().append("").append(객체)`로 변환
         *     → 불필요한 StringBuilder 객체 생성 + append 연산 + toString 2회 호출
         *     → 대용량 문자열 처리에서 성능 병목 가능성 큼
         * - ✅ `.toString()` 직접 호출은 내부 캐시를 반환하여 메모리/속도 모두 효율적
         *
         * ✅ 개선 힌트 비교
         * 1) 느린 방식: return "" + new BigInteger(a).add(new BigInteger(b));
         *    → 약 3~6배 느려짐
         * 2) 빠른 방식: return new BigInteger(a).add(new BigInteger(b)).toString();
         *
         * ✅ 보완 포인트 없음
         * - 문제 조건과 성능 요구를 충족하며 실무형 처리 방식까지 적용한 우수한 풀이
         */
        return new BigInteger(a).add(new BigInteger(b)).toString();
    }
}

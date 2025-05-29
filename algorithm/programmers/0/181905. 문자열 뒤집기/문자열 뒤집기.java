class Solution {
    public String solution(String my_string, int s, int e) {
        /**
         * 🔁 문자열 구간 뒤집기를 `for` 기반으로 구조화한 최적 코드
         *
         * ✅ 핵심 로직
         * - 문자열의 구간 [s, e]에서 앞뒤 문자를 교환하면서 부분 문자열을 역순 처리
         * - i는 앞에서, e는 뒤에서 점점 좁혀지며 중간에서 멈춤
         *
         * ✅ 개선 포인트
         * - `while (s < e)` 방식에서 `for (int i = s; i < e; i++)`로 구조 개선
         * - 조건문 내부에서 `e--`를 직접 다루는 방식으로, 가독성과 명시성이 향상됨
         * - s 변수를 직접 조작하지 않아, 원래의 s/e 범위를 유지한 채 반복 처리 가능
         *
         * ✅ 성능
         * - `StringBuilder` 기반이라 불필요한 문자열 복사를 피하고 빠름
         * - 메모리 효율성도 좋고, 코드 라인 수도 최소화됨
         *
         * ✅ 실무 관점 팁
         * - 인덱스를 두 개 사용하는 반복에서, 하나를 루프 변수(i), 다른 하나를 내부에서 조작하는 방식은 매우 일반적
         * - 반복 조건이 명확할 경우 while보다 for가 디버깅과 리뷰에 유리함
         * - 단, 내부에서 종료 조건을 조작하므로 논리적 오류가 생기지 않도록 경계가 필요
         *
         * ✅ 결론
         * - 알고리즘의 핵심은 보존하면서, 반복 구조를 깔끔하게 정리한 좋은 예제야
         * - 실무적인 사고와 리팩토링 감각이 모두 잘 드러나는 코드야! 👍
         */
        StringBuilder answer = new StringBuilder(my_string);
        for (int i = s; i < e; i++) {
            char temp = answer.charAt(i);
            answer.setCharAt(i, answer.charAt(e));
            answer.setCharAt(e, temp);
            e--;
        }
        return answer.toString();
    }
}

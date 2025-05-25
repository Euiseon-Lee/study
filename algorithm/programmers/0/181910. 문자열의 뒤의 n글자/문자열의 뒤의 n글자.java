class Solution {
    public String solution(String my_string, int n) {
        /**
         * 🔚 문자열 끝에서 n글자 추출 문제
         *
         * 주어진 문자열 my_string에서 뒤에서부터 n글자를 잘라내어 반환하는 문제
         *
         * ✅ 현재 구현 방식
         * - substring(startIndex)를 사용하여 뒤에서 n개의 문자만 잘라냄
         * - startIndex는 문자열의 길이에서 n을 뺀 위치이며,
         *   substring(start) 형태로 끝까지 잘라내는 방식은 가장 간단하고 효율적인 추출 방식임
         *
         * ✅ 장점
         * - substring(startIndex) 호출은 내부적으로 char 배열 복사 기반으로 동작하므로,
         *   시간복잡도는 O(n)이나 매우 빠른 수준
         * - 예외 처리나 조건 분기가 필요 없는 구조로 코드가 깔끔하고 직관적임
         *
         * ⏱ 성능
         * - 평균 실행 시간 0.01ms~0.02ms 수준
         * - StringBuilder, 반복문, 슬라이싱 등의 방법보다 간단하고 빠름
         *
         * 🧠 정리
         * - Java에서 문자열의 일부분을 가져올 때는 substring이 가장 빠르고 명확한 방식
         * - 특히 뒤쪽 고정 길이만 추출할 경우 substring(length - n)은 거의 정답에 가까움
         * - 추가 조건이 없다면, 지금 구조가 가장 최적이며 더 개선할 여지가 없음
         */
        return my_string.substring(my_string.length() - n);
    }
}

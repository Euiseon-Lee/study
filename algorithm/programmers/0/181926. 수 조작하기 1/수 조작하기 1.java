class Solution {
    public int solution(int n, String control) {
        /*
         * ✅ 문자열 순회 방식 변경 및 성능 개선 주석
         *
         * [처음에는 String.toCharArray() 사용]
         *   for (char c : control.toCharArray()) {
         *       switch (c) { ... }
         *   }
         *
         * - toCharArray()는 내부적으로 문자열의 모든 문자(char)를
         *   새로운 char[] 배열에 1:1 복사(copy)하여 반환하는 메서드
         *
         *   예: "wsad".toCharArray() →
         *       힙 메모리에 [w, s, a, d]라는 새 배열을 만들고 값을 복사함
         *
         * - 즉, 문자열 길이가 n이라면:
         *   → 시간 복잡도: O(n) (char 복사)
         *   → 공간 복잡도: O(n) (char 배열 생성)
         *   → 문자열이 길어질수록 GC(Garbage Collector) 부담 증가 가능
         *
         * [개선 후: String.charAt(i) 사용]
         *   for (int i = 0; i < control.length(); i++) {
         *       char c = control.charAt(i);
         *       switch (c) { ... }
         *   }
         *
         * - charAt(i)는 String 내부의 value[] 배열에서
         *   해당 인덱스의 문자에 직접 접근하므로 별도 배열 생성이 없음
         *   → 시간: O(1), 공간: O(1)
         *
         * ✅ 성능 비교 (테스트 기준):
         *   - toCharArray(): 최대 7.08ms, 평균 3~4ms
         *   - charAt(): 최대 6.08ms, 평균 1.5~3ms
         *
         * 💡 결론:
         *   - 긴 문자열 순회에서는 toCharArray()보다 charAt(i)를 사용하는 것이
         *     메모리 및 실행 성능 면에서 더 유리함
         *   - 특히 루프 안에서 반복 호출될 경우, toCharArray()는 복사 비용 누적됨
         */
        //for (char c : control.toCharArray()) {
        for (int i = 0; i < control.length(); i++) {
            char c = control.charAt(i);
            switch (c) {
                case 'w': n += 1;
                    break;
                case 's': n -= 1;
                    break;
                case 'd': n += 10;
                    break;
                case 'a': n -= 10;
                    break;
            }
        }
        return n;
    }
} 

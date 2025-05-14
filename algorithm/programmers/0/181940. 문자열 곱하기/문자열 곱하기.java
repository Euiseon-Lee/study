class Solution {
    public String solution(String my_string, int k) {
        /*
         * Java 11 이상에서 추가된 String.repeat(int count)를 사용하여
         * 주어진 문자열 my_string을 k번 반복한 결과를 반환한다.
         *
         * - 내부적으로 StringBuilder를 사용하여 성능 최적화되어 있음
         * - Java 11 이상에서만 사용 가능 (하위 호환이 필요하다면 루프 + append 사용)
         * - k가 0이면 빈 문자열 반환, k가 음수면 IllegalArgumentException 발생 가능성 있음
         *
         * 대안:
         * StringBuilder sb = new StringBuilder();
         * for (int i = 0; i < k; i++) sb.append(my_string);
         * return sb.toString();
         */
        return my_string.repeat(k);
    }
}

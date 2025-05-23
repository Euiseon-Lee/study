import java.util.*;
class Solution {
    public int[] solution(int n) {
        /*
         * ✅ 콜라츠 수열 생성 문제
         *
         * - 주어진 자연수 n을 시작으로, 콜라츠 추측에 따라 수열 생성
         *   짝수: n / 2, 홀수: 3n + 1, 1이 될 때까지 반복
         *   예: n = 10 → [10, 5, 16, 8, 4, 2, 1]
         *
         * 🔍 핵심 구현
         *   - List<Integer>에 값을 누적하고, 마지막에 int[]로 변환
         *   - stream().mapToInt().toArray()로 간결하게 처리
         *
         * ✅ 기존 구현 방식
         *   - while 루프 내 조건 분기(짝수/홀수)로 n 갱신
         *   - list.add(n)을 통해 순서대로 저장
         *
         * ❗ 개선 가능 포인트
         *   - list → 배열 변환 시 mapToInt(Integer::intValue)로 가독성 향상 가능
         *   - 입력값이 클 경우 int 범위를 초과할 수 있으므로 long 고려 가능
         *
         * ⏱ 성능
         *   - 시간복잡도 O(k), k는 수열 길이
         *   - 평균 2~4ms 수준으로 안정적 성능
         */
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (3 * n) + 1;
            }
            list.add(n);
        }
        int[] answer = list.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }
}

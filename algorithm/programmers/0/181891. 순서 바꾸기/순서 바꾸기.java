import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        /**
         * 📌 배열 회전 문제 풀이 요약
         *
         * ✅ 핵심 로직
         * - 주어진 배열 `num_list`를 인덱스 `n`을 기준으로 앞뒤를 나누어 회전
         *   예: [0,1,2,3,4], n=2 → [2,3,4,0,1]
         * - `Arrays.copyOfRange()`를 이용해 `n ~ 끝`까지 먼저 복사
         * - 남은 `0 ~ n-1`까지의 값을 이어붙여 새 배열 생성
         *
         * ✅ 성능 및 구조
         * - 시간복잡도: O(N) — 전체 배열을 두 번 순회
         * - 공간복잡도: O(N) — `answer` 배열과 임시 `preArr` 배열 사용
         * - 불필요한 중간배열(`preArr`) 없이 index 연산만으로도 해결 가능
         *
         * ✅ 보완 포인트
         * - 현재는 `preArr`를 중간에 생성하지만, 성능 측면에서는 불필요
         * - 단일 루프로 바로 `answer`에 값을 채우는 방식이 더 효율적
         *   → 아래 개선 코드 참고
         *
         * ✅ 개선 코드 예시
         *   int len = num_list.length;
         *   int[] answer = new int[len];
         *   for (int i = 0; i < len; i++) {
         *       answer[i] = num_list[(i + n) % len];
         *   }
         *   return answer;
         *
         * ✅ 개선 장점
         * - 불필요한 배열 복사 제거
         * - 메모리 사용 최소화 + 성능 개선
         * - 코드 가독성도 더 우수
         */
        int[] answer = new int[num_list.length];
        int[] preArr = Arrays.copyOfRange(num_list, n, num_list.length);
        for (int i = 0; i < preArr.length; i++) {
            answer[i] = preArr[i];
        }                     
        for (int i = preArr.length, j = 0; i < num_list.length; i++) {
            answer[i] = num_list[j++];
        }
        return answer;
    }
}

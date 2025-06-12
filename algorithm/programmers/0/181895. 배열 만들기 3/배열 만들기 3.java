import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        /** 📌 배열 구간 병합 문제 풀이 요약
         *
         * ✅ 핵심 로직
         * - `intervals` 배열을 순회하며 각 구간(start ~ end)을 기준으로
         *   `arr`에서 해당 구간의 값을 추출해 `ArrayList`에 누적.
         * - 마지막에 `ArrayList`를 `int[]`로 변환하여 반환함.
         *
         * ✅ 성능 및 구조
         * - 시간복잡도: O(n), intervals의 길이와 각 구간의 범위에 따라 전체 순회량 결정
         * - 공간복잡도: O(k), k는 선택된 구간의 전체 길이
         * - `ArrayList`를 통해 동적 배열 생성 → 추출 후 고정 배열로 변환
         *
         * ✅ 실무 활용도
         * - 실무에서 대규모 배열의 부분 추출 및 병합 처리 시 적합
         * - 다만 `ArrayList → 배열` 전환이 빈번하면 메모리 및 성능 측면에서 비효율 가능
         *
         * ✅ 보완 포인트
         * - 구간 추출 과정에서 직접 index 계산으로 `System.arraycopy()` 또는 `Stream.concat()` 사용하면 성능 더 향상 가능
         * - `intervals`의 범위 유효성 체크 필요 (예외 케이스 대비)
         *
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1] + 1;
            for (int j = start; j < end; j++) {
                list.add(arr[j]);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

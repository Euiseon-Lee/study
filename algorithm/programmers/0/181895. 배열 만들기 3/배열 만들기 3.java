import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        /**
         * 📌 배열 구간 병합 문제 풀이 요약 (기존 코드 + 개선 버전 통합 설명)
         *
         * ✅ 초기 코드 로직
         * - `intervals` 배열의 각 구간 [start, end]를 순회하며 `arr[start ~ end]` 값을 `ArrayList`에 누적
         * - 마지막에 ArrayList → int[]로 변환 후 반환
         *
         * ✅ 성능 및 구조 분석
         * - 시간복잡도: O(n), intervals 길이와 각 구간 길이 합에 비례
         * - 공간복잡도: O(k), 구간 내 선택된 원소의 총합만큼 메모리 사용
         * - ArrayList의 add 및 get 반복, toArray 등에서 성능 손실 발생 가능
         *
         * ✅ 실무 활용도
         * - 대규모 배열의 부분 병합, 로그/데이터 스트림 필터링에 활용 가능
         * - 단, ArrayList 기반 방식은 큰 데이터셋에서 GC 유발 가능성 존재
         *
         * ✅ 개선 아이디어 및 구현
         * - 결과 배열의 총 길이를 먼저 계산 → int[] answer 배열을 미리 할당
         * - ArrayList 없이 직접 index로 copy → 성능/메모리 효율 향상
         *
         * 🧠 개선 코드 (정적 배열 기반 처리, O(n))
         * int[] solution(int[] arr, int[][] intervals) {
         *     int totalLength = 0;
         *     for (int[] interval : intervals) {
         *         totalLength += interval[1] - interval[0] + 1;
         *     }
         *     int[] answer = new int[totalLength];
         *     int idx = 0;
         *     for (int[] interval : intervals) {
         *         for (int i = interval[0]; i <= interval[1]; i++) {
         *             answer[idx++] = arr[i];
         *         }
         *     }
         *     return answer;
         * }
         *
         * 🔍 개선 포인트 정리
         * - ArrayList 제거 → GC 부담 최소화
         * - 배열 크기 예측 가능 → 힙 파편화 최소화
         * - 한 번의 for 루프로 정적 배열에 직접 write → 빠른 처리
         * - 1-based 인덱스가 아니므로 별도 보정 불필요
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

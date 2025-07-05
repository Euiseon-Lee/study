import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        /** 🧠 구간별 값 증가 처리 – 누적합(Difference Array) 알고리즘 적용
         *
         * ✅ 문제 요약
         * - 정수 배열 arr에 대해 여러 쿼리 [start, end]가 주어짐
         * - 각 쿼리는 arr[start]부터 arr[end]까지 모든 값을 1씩 증가시킴
         * - 최종적으로 변화된 arr 배열을 반환
         *
         * 🚫 기존 브루트포스 방식 (의선이 작성)
         * - 각 query마다 arr[start] ~ arr[end]를 직접 순회하며 1씩 누적
         * - 시간복잡도: O(q * k) (q = 쿼리 수, k = 평균 구간 길이)
         * - 구간 수가 많을 경우 시간 소모 큼 → 성능 병목 발생
         *
         * ✅ 개선 전략: 누적합(Difference Array)
         * - 핵심 아이디어: 실제 값을 바로 수정하지 않고, "변화량만 기록"함
         *   → 시작점에 +1, 종료+1 지점에 -1 기록 (이후 누적합으로 반영)
         * 
         * ✨ 작동 방식
         * - diff[start] += 1           // 이 지점부터 값 증가 시작
         * - diff[end + 1] -= 1         // 이 지점 이후부터 증가 종료
         * - 마지막에 누적합(diff[i] += diff[i - 1])을 통해 변화량을 전체 배열에 전파
         * - 결과적으로 각 index별 누적된 변화량을 원본 배열에 더함
         *
         * ⏱ 시간복잡도
         * - 쿼리 반영: O(q)
         * - 누적합 계산: O(n)
         * - 최종 결과 생성: O(n)
         * → 전체 O(n + q)로, 브루트포스보다 월등히 빠름
         *
         * 🎯 실무 적용 팁
         * - 대량 구간 수정이 필요한 경우: 통계, 시간대 로그 처리, 일자별 증감량 등
         * - "배열에 직접 적용하지 말고 → 변화량을 기록한 뒤 → 한 번에 반영"하는 방식으로 일반화 가능
         * - 누적합은 배열 뿐 아니라 그래프/로그/이벤트 시퀀스 등 다양한 도메인에 활용 가능
         *
         * ✅ 개선 코드 예시
         * class Solution {
         *     public int[] solution(int[] arr, int[][] queries) {
         *         int[] diff = new int[arr.length + 1]; // 변화량 기록용
         *         
         *         for (int[] query : queries) {
         *             int start = query[0];
         *             int end = query[1];
         *             diff[start] += 1;
         *             if (end + 1 < diff.length) diff[end + 1] -= 1;
         *         }
         *         
         *         for (int i = 1; i < diff.length; i++) {
         *             diff[i] += diff[i - 1];
         *         }
         *         
         *         int[] answer = new int[arr.length];
         *         for (int i = 0; i < arr.length; i++) {
         *             answer[i] = arr[i] + diff[i];
         *         }
         *         
         *         return answer;
         *     }
         * }
         *
         * ✅ 실전 성능 비교
         * - 브루트포스 방식: 최대 2.66ms
         * - 누적합 방식: 평균 0.06ms → 약 40~50배 성능 개선
         * - 쿼리 수가 많거나 범위가 클수록 차이가 극적으로 커짐
         */
        int[] answer = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            for (int j = start; j <= end; j++) {
                answer[j]++;
            }
        }
        return answer;
    }
}

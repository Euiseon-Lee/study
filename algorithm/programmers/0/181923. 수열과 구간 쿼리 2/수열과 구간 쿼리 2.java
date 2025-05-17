class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        /*
         * ✅ 조건 기반 구간 최소값 탐색 문제
         *
         * - queries 배열은 [s, e, k] 형식이며
         *   arr[s]부터 arr[e]까지의 구간에서 k보다 큰 수 중 가장 작은 값을 찾아야 함
         *
         * 🔍 핵심 로직
         *   - 각 쿼리마다 해당 구간을 순회하며
         *     1) target > standard 조건 만족 여부 체크
         *     2) 만족하는 값들 중 가장 작은 값(Math.min 누적)
         *   - 조건 만족 값이 없으면 -1을 반환
         *
         * 🧠 변수 분리
         *   - queries[i][0~2]를 각각 min, max, standard로 분리하여
         *     코드 가독성과 의미 명확성 향상
         *
         * 🔄 시간 복잡도
         *   - 전체 시간 복잡도: O(q * n) (q: queries 길이, n: 최대 구간 크기)
         *   - 현재는 테스트 수준에서 충분히 효율적
         *
         * 📌 개선 여지 (대규모 입력 기준)
         *   - 구간 내 조건 기반 쿼리가 반복되는 경우 → segment tree / prefix structure 고려 가능
         *
         *
         * ✅ 세그먼트 트리(Segment Tree)란?
         *
         * - 배열을 구간 단위로 나누어 트리 형태로 저장하고,
         *   각 노드에 구간의 최소값, 최대값, 합계 등을 미리 기록해두는 구조
         *
         * - 특정 구간의 정보를 빠르게 조회하거나,
         *   특정 인덱스의 값을 변경한 후 전체 구간 정보에 반영할 수 있음
         *
         * 예시:
         *   arr = [5, 3, 8, 6]
         *
         *             [0~3] → min=3
         *            /      \
         *        [0~1]      [2~3]
         *        /   \      /   \
         *      [0]  [1]   [2]  [3]
         *       5    3     8    6
         *
         * - 예: [2~3] 구간 최소값을 알고 싶다면 → 오른쪽 트리만 탐색
         *
         * ⏱ 시간 복잡도
         *   - 초기화: O(n)
         *   - 구간 질의: O(log n)
         *   - 단일 값 갱신: O(log n)
         *
         * - 조건이 포함된 구간 질의(예: k보다 큰 값 중 최소 등)는
         *   세그먼트 트리의 응용이 필요 (트리 내부에 조건 필터링 로직 포함)
         *
         *
         * ✅ 프리픽스(Prefix) 구조란?
         *
         * - 누적합, 누적최소값, 누적최대값 등을 미리 계산하여
         *   특정 구간에 대한 값을 빠르게 조회하는 선형 구조
         *
         * - 예: prefixSum[i] = arr[0] + arr[1] + ... + arr[i]
         *   → 구간 [l~r] 합 = prefixSum[r] - prefixSum[l-1]
         *
         * - 조건 없이 단순히 합/최소/최대만 구하는 문제엔 매우 효과적
         * - 단점: 조건이 복잡한 경우(k 이상인 값 중 최솟값 등)에는 사용하기 어렵거나 구조를 추가해야 함
         *
         *
         * 💡 정리: 언제 구조를 쓰는가?
         *   - 조건 없이 구간 합/최솟값만 반복해서 구하면 → prefix 구조
         *   - 조건이 포함된 구간 질의 + 빠른 갱신이 필요하면 → segment tree
         *   - 현재 문제는 단순 반복으로도 충분히 풀 수 있지만,
         *     입력 크기가 커지면 성능 최적화를 위한 구조적 전환이 필요할 수 있음
         */
        int l = queries.length;
        int[] returnArr = new int[l];
        for (int i = 0; i < l; i++) {
            int min = queries[i][0];
            int max = queries[i][1];
            int standard = queries[i][2];
            int val = Integer.MAX_VALUE;
            for (int j = min; j <= max; j++) {
                int target = arr[j];
                if (target > standard) {
                    val = Math.min(val, target);
                }
            }
            returnArr[i] = val == Integer.MAX_VALUE ? -1 : val;
        }
        return returnArr;
    }
}

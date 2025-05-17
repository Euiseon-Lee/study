class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        /*
         * ✅ 인덱스 기반 조건 갱신 문제
         *
         * - 각 쿼리는 [start, end, k] 형태이며
         *   arr[start~end] 구간 중, 인덱스가 k의 배수인 위치에 대해 +1 갱신 수행
         *
         * 🔍 로직 설명
         *   - 인덱스 기준 조건 (i % k == 0)이므로 값을 기준으로 필터링하는 구조(Segment Tree)는 맞지 않음
         *   - 반복문을 통한 직접 순회가 가장 효율적이며, in-place 수정도 안전함
         *
         * ⏱ 성능
         *   - 시간 복잡도: O(q * (e - s + 1)) (단, 조건이 있는 부분 필터링으로 최적화)
         *   - 테스트 기준: 모든 쿼리 수행 시 2ms 이하로 빠르게 처리됨
         *
         * 📌 구조 선택에 대한 정리
         *   - 세그먼트 트리는 주로 "배열에 저장된 값 자체"에 대해 빠르게 질의하는 경우에 적합
         *     예: 특정 구간의 합, 최솟값, 최댓값 등
         *   - 반면, 이 문제처럼 "배열의 값이 아니라 인덱스 조건(i % k == 0)에 따라 배열을 수정"해야 할 경우에는
         *     세그먼트 트리보다 단순 반복문이 더 직관적이고 적절한 방식이다
         */
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int standard = queries[i][2];
            for (int j = start; j <= end; j++) {
                if (j % standard == 0) {
                    arr[j] += 1;
                }
            }
        }
        return arr;
    }
}

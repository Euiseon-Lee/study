class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        /*
         * ✅ 배열 인덱스 swap 처리 문제
         *
         * - 주어진 정수 배열 arr의 값들을, queries의 쌍 [i, j]에 따라 순차적으로 swap함
         * - 각 쿼리는 arr[i]와 arr[j]의 위치를 바꾸는 명령
         *
         * - 시간 복잡도: O(q) (q = queries.length)
         * - 공간 복잡도: O(1) (in-place 배열 처리)
         *
         * 🔍 코드 스타일 측면에서의 팁
         *   - queries[i][0], queries[i][1]을 반복해서 직접 쓰는 대신
         *     a, b 등으로 분리해 의미 명확하게 표현하면 유지보수성과 가독성 향상
         *   - 단순한 문제지만, swap 패턴은 자주 사용되므로 익숙해져야 함
         */
        for (int i = 0; i < queries.length; i++) {
            int tmp = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = tmp;
        }
        return arr;
    }
}

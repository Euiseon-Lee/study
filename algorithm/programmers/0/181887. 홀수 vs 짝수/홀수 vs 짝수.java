class Solution {
    public int solution(int[] num_list) {
        /**
         * 🎯 홀수 번째 vs 짝수 번째 인덱스 값의 합 비교
         *
         * 🔍 인덱스 기준:
         *  - 짝수 인덱스(i % 2 == 0) → odds 누적
         *  - 홀수 인덱스(i % 2 == 1) → evens 누적
         *
         * 🧮 최종 반환:
         *  - odds, evens 중 더 큰 값을 반환 (Math.max)
         *
         * 🚀 성능:
         *  - 시간복잡도: O(n), 배열 1회 순회
         *  - 공간복잡도: O(1), 변수 2개 사용
         *
         * 💡 활용 예시:
         *  - 위치 기반 패턴 분석, 인덱스 위치별 집계 비교
         */
        int odds = 0;
        int evens = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                odds += num_list[i];
            } else {
                evens += num_list[i];   
            }
        }
        return Math.max(odds, evens);
    }
}

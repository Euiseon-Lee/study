import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        /** 🎯 query 기반 부분 배열 추출 – 포인터 슬라이싱 최적화 및 기존 방식의 성능 비교
         *
         * ✅ 문제 요약
         * - 정수 배열 arr와 query 배열이 주어짐
         * - query[i]가 짝수일 경우: 오른쪽 자름 (query[i]까지 포함)
         * - query[i]가 홀수일 경우: 왼쪽 자름 (query[i]부터 유지)
         * - 위 과정을 순차적으로 반복하여 최종 배열을 추출함
         *
         * ✅ 너의 원래 풀이 방식 (성공적이나 성능 비효율 존재)
         * - 매 쿼리마다 ArrayList를 subList → new ArrayList로 재생성
         * - 가변 배열에 매번 복사를 반복함으로써 메모리 낭비 및 GC 부담이 큼
         * - 시간복잡도: O(N * Q) 수준 (N은 배열 길이, Q는 query 길이)
         *
         * ✅ 개선 아이디어 – 인덱스 포인터 기반 슬라이싱
         * - 배열을 복사하지 않고, 시작/끝 인덱스(left/right)만 추적
         * - 연산이 끝난 후 마지막 구간만 copyOfRange로 한 번 복사
         * - 시간복잡도: O(Q) + O(k) (k는 최종 배열 길이)
         * - 메모리 효율성과 성능 모두 향상됨
         *
         * ✅ 개선 코드
         * int left = 0;
         * int right = arr.length;
         * for (int i = 0; i < query.length; i++) {
         *     if (i % 2 == 0) {
         *         right = left + query[i] + 1;
         *     } else {
         *         left = left + query[i];
         *     }
         * }
         * return Arrays.copyOfRange(arr, left, right);
         *
         * ✅ 장점 요약
         * - ArrayList 불필요, 원본 배열만 활용해 최소한의 연산
         * - 실무에서 반복적인 리스트 슬라이싱 문제에 응용 가능
         * - 공간복잡도 O(1) 수준으로 최적화
         *
         * ⚠️ 주의점
         * - query[i]는 "현재 배열 기준"이 아닌, 항상 원본 arr 기준의 절대 인덱스가 아님
         *   → 슬라이싱을 진행할수록 배열이 줄어들므로, **실제로는 relative offset으로 해석되어야 함**
         *   → 따라서 배열 자체를 잘라서 해석하면 잘못된 인덱스 접근으로 오류 또는 성능 저하 발생
         */
        int start = 0;
        int end = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int n : arr) {
            temp.add(n);
        }
        for (int i = 0; i < query.length; i++) {
            start = (i % 2 == 0) ? 0 : query[i];
            end = (i % 2 == 0) ? query[i] : temp.size() - 1;
            temp = new ArrayList<>(temp.subList(start, end + 1));
        }
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}

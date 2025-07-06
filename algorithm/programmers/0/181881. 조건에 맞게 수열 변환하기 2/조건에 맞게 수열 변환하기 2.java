import java.util.*;
class Solution {
    public int solution(int[] arr) {
        /** 🔁 배열 안정화 반복 문제 – 조건 기반 반복 변환 후 수렴 횟수 계산
         *
         * ✅ 핵심 로직
         * - 주어진 정수 배열 `arr`에 대해 조건에 따라 요소를 변경하고, 변경 결과가 이전 배열과 같아질 때까지 반복
         *   * 조건1: 50보다 큰 짝수 → 2로 나누기
         *   * 조건2: 50보다 작은 홀수 → 2를 곱하고 1 더하기
         *   * 조건3: 나머지는 유지
         * - `Arrays.equals()`를 통해 매 루프마다 이전 상태와 현재 상태 비교
         * - 배열이 더 이상 변하지 않으면 반복 중단, 그때까지 반복한 횟수를 `answer`로 반환
         *
         * ✅ 성능 분석
         * - 시간복잡도: O(n * k), n = 배열 길이, k = 수렴까지 반복 횟수
         * - 공간복잡도: O(n), 비교용 배열 `standard`를 유지함
         * - 일부 케이스에서 60ms 이상 소요됨 → `Arrays.copyOf`, `Arrays.equals` 반복 사용 때문
         *
         * ✅ 실무 활용도
         * - 수렴 조건 기반 시뮬레이션 또는 조건 반복 처리 로직에 적용 가능
         *   * 예: 이미지 노이즈 제거 반복, 상태 변화 모니터링, 정제 반복 처리 등
         *
         * ✅ 보완 포인트
         * - `continue` 문은 불필요하므로 제거 가능
         * - `Arrays.equals()` 대신 flag 비교를 통한 변경 감지 방식으로 변경 시 성능 향상 가능
         * - Java 9 이상: `Arrays.mismatch()` 사용하여 빠르게 변화 탐지 가능
         * - 메모리 절약: 두 배열을 번갈아 사용하는 구조나 덮어쓰기 방식으로 개선 가능
         *
         */
        int[] standard = new int[arr.length];
        int answer = -1;
        while (!Arrays.equals(arr, standard)) {
            standard = Arrays.copyOf(arr, arr.length);
            answer++;
            for (int i = 0 ; i < arr.length; i++) {
                int num = arr[i];
                if (num > 50 && num % 2 == 0) {
                    arr[i] /= 2;
                } else if (num <= 50 && num % 2 == 1) {
                    arr[i] = (num * 2) + 1;
                } else {
                    continue;
                }
            }
        }
        return answer;
    }
}

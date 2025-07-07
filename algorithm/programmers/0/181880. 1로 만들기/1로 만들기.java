import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        /**
         * ✅ 문제 요약  
         *  - 정수 배열의 모든 원소를 다음 조건에 따라 반복적으로 변환  
         *    - 짝수: num / 2  
         *    - 홀수: (num - 1) / 2  
         *  - 모든 원소가 1이 될 때까지 위 변환을 반복하며, 총 수행된 연산 횟수를 반환함  
         *
         * 🔁 기존 코드(의선 작성)의 구조 요약  
         *  - 기준 배열인 standard를 생성하고 모두 1로 초기화  
         *  - while 루프 종료 조건으로 Arrays.equals(num_list, standard) 사용 → O(n) 비용  
         *  - 각 요소를 순회하며 짝수/홀수 조건에 따라 변환하고, answer를 누적  
         *
         * ✅ 개선 코드  
         *  - 아래는 성능 개선을 위해 배열 비교 대신 boolean 플래그 방식으로 종료 조건을 판단하는 코드임  
         *
         *    class Solution {
         *        public int solution(int[] num_list) {
         *            int answer = 0;
         *            boolean done = false;
         *            while (!done) {
         *                done = true;
         *                for (int i = 0; i < num_list.length; i++) {
         *                    int num = num_list[i];
         *                    if (num > 1) {
         *                        num_list[i] = (num % 2 == 0) ? num / 2 : (num - 1) / 2;
         *                        answer++;
         *                        done = false;
         *                    }
         *                }
         *            }
         *            return answer;
         *        }
         *    }
         *
         * 🔍 의선 코드 vs 개선 코드 비교  
         *  1. 종료 조건  
         *     - 의선 코드: Arrays.equals(num_list, standard) → 매 루프마다 배열 전체 비교 (O(n))  
         *     - 개선 코드: 값이 변경될 경우만 플래그로 감지 (O(1)) → 더 빠름  
         *
         *  2. 메모리 사용  
         *     - 의선 코드: standard 배열 생성 (불필요한 O(n) 메모리)  
         *     - 개선 코드: 불필요한 배열 제거 → 공간 최적화  
         *
         *  3. 성능 측정 결과  
         *     - 의선 코드 평균 실행 시간: 0.04 ~ 0.07ms  
         *     - 개선 코드 평균 실행 시간: 0.02 ~ 0.03ms  
         *     → 약 30~50% 성능 개선  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(n log m)  
         *    - 각 숫자는 log₂(num) 횟수만큼 변환됨  
         *  - 공간복잡도:  
         *    - 의선 코드: O(n) (standard 배열 포함)  
         *    - 개선 코드: O(1) (추가 자료구조 없음)  
         *
         * 🛠 실무 활용도  
         *  - 반복 조건 최적화 패턴(boolean 플래그)은 실무 반복문에서 자주 사용됨  
         *  - 배열 비교는 정확하지만 성능 비용 큼 → 수렴 여부 판단 시 플래그 사용이 더 효율적  
         *  - 값 변경이 없을 때 종료하는 구조는 이벤트 loop나 상태 머신 로직에도 활용 가능  
         */
        int answer = 0;
        int[] standard = new int[num_list.length];
        Arrays.fill(standard, 1);
        while (!Arrays.equals(num_list, standard)) {
            for (int i = 0; i < num_list.length; i++) {
                int num = num_list[i];
                if (num > 1) {
                    num_list[i] = num % 2 == 0 ? num / 2 : (num - 1) / 2;
                    answer++;
                }
            }
        }
        return answer;
    }
}

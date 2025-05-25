class Solution {
    public String solution(String my_string, int[][] queries) {
        /**
         * 🔄 문자열 구간 뒤집기 문제
         *
         * 현재 코드는 문자열을 split("")으로 String[] 배열로 변환한 뒤,
         * 각 쿼리 [s, e] 범위의 값을 직접 swap하여 처리함.
         * 모든 쿼리 수행 후, StringBuilder를 사용해 배열을 순차적으로 합쳐 최종 문자열을 반환함.
         *
         * ✅ 장점
         * - 로직이 직관적이며, 조건 분기 없이 index 기반으로 처리 가능함
         * - 전체 쿼리 흐름이 명확하여 가독성과 유지보수 측면에서 안정적임
         * - 모든 테스트를 정확하게 통과함
         *
         * ⚠️ 단점
         * - split("")으로 생성된 String[]은 참조형 객체 배열이므로
         *   swap 및 append 연산마다 불필요한 참조 이동과 문자열 복사 비용이 발생함
         * - 특히 쿼리 수가 많고 범위가 넓을 경우, 성능 저하가 발생할 수 있음
         * - 실제 테스트 25번에서 최대 8.53ms까지 소요됨
         *
         * 💡 개선 제안 (제안자: ChatGPT)
         * 문자열을 char[] 배열로 변환하고, 쿼리 범위를 직접 값 교환(swap)한 뒤,
         * 최종적으로 new String(char[])을 사용해 문자열을 생성하는 방식
         * 참조가 아닌 값 기반으로 처리되므로 성능이 향상됨
         *
         * 🔧 개선 코드 예시 (char[] 기반)
         *
         *     char[] arr = my_string.toCharArray();
         *
         *     for (int[] query : queries) {
         *         int s = query[0];
         *         int e = query[1];
         *         while (s < e) {
         *             char tmp = arr[s];
         *             arr[s] = arr[e];
         *             arr[e] = tmp;
         *             s++;
         *             e--;
         *         }
         *     }
         *
         *     return new String(arr);
         *
         * 🚀 성능 비교
         * - 기존 방식: 테스트 24~25에서 5.62ms, 8.53ms
         * - 개선 방식: 동일 케이스에서 0.89ms, 2.52ms로 단축
         * - 평균적으로 3~8배 이상 성능 개선 효과
         *
         * 🧠 정리
         * - 문자열을 반복적으로 수정하거나 swap할 필요가 있는 문제에서는
         *   String[]보다 char[] 기반 방식이 성능적으로 유리함
         * - 실시간 처리, 반복 호출, 긴 문자열의 부분 조작이 필요한 상황에 적합함
         * - 현재 구현은 가독성과 논리 흐름 면에서 우수하고,
         *   제안된 개선안은 성능 중심의 최적화 참고 코드로 활용 가능함
         */        
        String[] arr = my_string.split("");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            for (int j = 0; j < (e - s) / 2 + 1; j++) {
                String tmp = arr[s + j];
                arr[s + j] = arr[e - j];
                arr[e - j] = tmp;
            }
        }
        for (String s : arr) {
            answer.append(s);
        }
        return answer.toString();
    }
}

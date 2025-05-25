class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        /**
         * ✂️ 문자열 부분 추출 및 연결 문제
         *
         * 문자열 배열 my_strings와, 각 문자열에서 추출할 범위를 담은 parts 이차원 배열이 주어짐
         * 각 i번째 문자열에서 parts[i][0] ~ parts[i][1]까지의 부분 문자열을 추출하여
         * 순서대로 이어 붙인 문자열을 반환함
         *
         * ✅ 현재 구현 방식
         * - for문으로 my_strings 전체를 순회하며
         *   각 i번째 문자열에서 substring(s, e + 1)로 부분 문자열을 추출함
         * - 추출한 부분 문자열은 StringBuilder를 통해 연결하여 최종 문자열 생성
         *
         * ✅ 장점
         * - substring 추출은 index 기반으로 명확하고 효율적임
         * - StringBuilder를 사용하여 문자열 연결 비용 최소화
         * - 다차원 배열과 일대일 매핑 구조를 깔끔하게 구현함
         *
         * ⏱ 성능
         * - 문자열 추출 O(1) (부분 길이만큼)
         * - 전체 반복 O(n), n은 my_strings.length
         * - StringBuilder로 연결 → O(1) 수준의 append 처리
         * - 총 시간복잡도: O(k), k는 추출한 문자 총합
         *
         * 🧠 정리
         * - 각 인덱스를 정확히 매핑하는 배열 조작 문제에서
         *   substring + StringBuilder 조합은 가장 효율적이고 안전한 방법임
         * - 배열 index 오류 없이 정확하게 매핑되었고,
         *   코드 길이도 간결하여 유지보수성 높음
         */
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < my_strings.length; i++) {
            int s = parts[i][0];
            int e = parts[i][1];
            answer.append(my_strings[i].substring(s, e + 1));  
        }
        return answer.toString();
    }
}

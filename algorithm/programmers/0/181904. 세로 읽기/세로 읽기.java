class Solution {
    public String solution(String my_string, int m, int c) {
        /**
         * 🔍 문제 해결 로직 요약
         * - my_string을 m개 단위로 나누어 행처럼 보고, 각 행의 c번째 열 문자를 이어붙여 새로운 문자열을 생성
         * - substring(start, start + m)으로 행 단위로 잘라낸 뒤, charAt(c - 1)로 열 접근
         *
         * ✅ 성능
         * - O(n): 전체 문자열을 한 번 순회하며 c열 문자만 추출
         * - StringBuilder 사용으로 문자열 누적 시 성능 최적화
         * - 테스트 결과 평균 0.03~0.06ms, 최악 0.25ms로 안정적
         *
         * 🎯 실무 팁
         * - 문자열을 행렬처럼 분리할 때, 실제로 2차원 배열을 만들 필요 없이 인덱스 계산으로 처리하면 효율적
         * - 외부 입력을 다루는 경우 c-1 인덱스에 대한 유효성 검사 필요 (IndexOutOfBoundsException 방지)
         * - start 변수 없이 더 간결한 구조도 가능
         *
         * 🧩 더 간결한 대체 코드 예시
         * - 행 단위 처리를 하지 않고도, 각 행의 시작 인덱스에 c열 오프셋만 더해주는 방식
         * - 논리적으로 2차원이지만 구현은 1차원 인덱스로 충분한 상황에서 매우 유용함
         *   public String solution(String my_string, int m, int c) {
         *       StringBuilder sb = new StringBuilder();
         *       for (int i = 0; i < my_string.length(); i += m) {
         *           sb.append(my_string.charAt(i + c - 1));
         *       }
         *       return sb.toString();
         *   }
         *
         * 🧠 구조적 사고 평가
         * - 문제는 2차원 배열을 유도하지만, 실제 구현은 1차원 순회로 해결 가능
         * - 의도적으로 “문자열을 잘라서 인덱스 추출”하는 방식으로 문제 본질을 정확히 꿰뚫음
         * - 실무에서도 대량의 문자열 파싱이나 텍스트 파일 처리 시 유사한 구조 자주 활용됨
         */
        StringBuilder answer = new StringBuilder();
        for (int i = 0, start = 0; i < my_string.length() / m; i++) {
            String temp = my_string.substring(start, start + m);
            answer.append(temp.charAt(c - 1));
            start += m;
        }
        return answer.toString();
    }
}

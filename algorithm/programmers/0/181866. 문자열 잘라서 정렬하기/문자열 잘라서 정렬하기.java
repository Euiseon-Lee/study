import java.util.*;
class Solution {
    public String[] solution(String myString) {
        /**
         * 📌 'x' 문자를 기준으로 문자열을 나눈 후 정렬하여 반환
         *
         * ✅ 핵심 로직
         * - 입력 문자열에서 'x'를 기준으로 연속된 구간(split("x+"))으로 나눈 후
         *   빈 문자열을 제거하고 오름차순 정렬하여 배열로 반환
         *
         * ✅ 개선 코드 (기존 정규식 기반 전처리 대비 효율적)
         *   return Arrays.stream(myString.split("x+"))
         *                .filter(s -> !s.isEmpty())
         *                .sorted()
         *                .toArray(String[]::new);
         *
         * ✅ 기존 코드의 성능 이슈
         * - replaceAll("^[x]|[x]$", "") → 문자열 양끝 조건 복잡 처리
         * - replaceAll("x+", "x") → 불필요한 정규식 치환 비용
         * - split("x") 후 빈 문자열 존재 가능 → 후처리 필요
         * - 불필요한 trim() 호출 포함 → 불변 문자열 연산 증가
         *
         * ✅ 개선 코드의 장점
         * - split("x+") 한 번으로 모든 분할 처리 가능
         * - filter로 빈 문자열 제거 명시 → 의도 명확
         * - Stream 기반 파이프라인 → 메모리 할당 최소화 및 가독성 향상
         *
         * ✅ 성능 차이가 유의미한 상황
         * - myString이 매우 긴 경우 (예: 수천~수만 자)
         * - 'x'가 다량 반복될 때 → 정규식 기반 replaceAll 연쇄 호출 시 성능 저하
         * - 실시간 처리나 대량 텍스트 전처리에서 split + stream 방식이 더 빠름
         *
         * ✅ 실무 활용 팁
         * - 다수의 구분자를 정규식으로 처리하는 경우 split("패턴") → filter → 처리 로직 순서로 구성
         * - 정규식 치환보다 분할 후 절차적 필터링이 가독성과 성능 면에서 우수한 경우가 많음
         */
        String[] answer = myString.replaceAll("^[x]|[x]$", "").replaceAll("x+", "x").trim().split("x");
        Arrays.sort(answer);
        return answer;
    }
}

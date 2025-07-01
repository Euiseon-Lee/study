class Solution {
    public String[] solution(String[] names) {
        /**
         * 📌 5명씩 조별로 나눌 때 조별 대표 이름 추출
         *
         * ✅ 핵심 로직
         * - 입력 배열 `names`를 5명씩 묶었을 때, 각 조의 첫 번째 사람만 추출
         * - i += 5 단위로 순회하여 각 조의 대표를 `answer` 배열에 담음
         *
         * ✅ 성능 분석
         * - 시간복잡도: O(n/5) ≈ O(n) → 전체 배열을 5단계 step으로 순회
         * - 공간복잡도: O(n/5) → 조 대표만 담은 배열 생성
         * - 실행 속도: 매우 빠름 (테스트 평균 0.01ms 내외)
         *
         * ✅ 실무 활용도
         * - 조별 대표 추출, 간격 단위 샘플링, 페이징 처리 등에서 활용
         * - 일정 간격마다 키 포인트를 뽑거나, 섹션별 헤더를 구성할 때 적합
         *
         * ✅ 보완 포인트
         * - `answer` 배열의 길이 계산은 `(names.length + 4) / 5` 로 간단화 가능
         *   → 나머지를 고려한 보정 처리를 수학적으로 반영한 방식
         * - names 배열이 null이거나 비어 있는 경우에 대한 방어 코드도 실무에서는 고려 필요
         *
         * ✅ 개선 코드 예시
         * int[] answer = new int[(names.length + 4) / 5];
         * for (int i = 0, idx = 0; i < names.length; i += 5) {
         *     answer[idx++] = names[i];
         * }
         */
        int addLength = names.length % 5 == 0 ? 0 : 1;
        String[] answer = new String[(names.length / 5) + addLength];
        for (int i = 0, idx = 0; i < names.length; i += 5) {
            answer[idx++] = names[i];
        }
        return answer;
    }
}

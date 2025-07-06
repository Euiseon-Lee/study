class Solution {
    public int solution(String myString, String pat) {
        /**
         * 🔁 A/B 대칭 치환 후 부분 문자열 검사 – XOR 최적화 적용
         *
         * ✅ 문제 요약
         * * myString의 A를 B로, B를 A로 바꾼 문자열을 만들고,
         *   해당 문자열 내에 pat이 포함되는지 여부를 검사
         *
         * ✅ 너의 원래 풀이 요약
         * * 조건문 기반 치환:
         *   - myString을 순회하며 A → B, B → A 조건문 처리
         *   - StringBuilder로 구성 후 contains(pat) 수행
         *   - 명확하고 직관적이지만 매 문자마다 분기 발생 → 루프 성능 저하 가능성
         *
         * ✅ 개선 포인트 – XOR 치환
         * * 'A'(65)와 'B'(66)는 비트 단위 XOR 연산으로 서로 변환 가능
         *   - 'A' ^ 3 = 'B', 'B' ^ 3 = 'A' (3 = 65 ^ 66)
         *   - 분기문 없이 `(char)(c ^ 3)` 형태로 즉시 대칭 문자로 치환 가능
         *
         * ✅ 성능 이점
         * * 조건문 없이 연산만 수행 → CPU 분기 예측 실패 감소
         * * 짧은 루프에선 미미할 수 있지만, 다량 처리나 반복 루프에선 성능 차이 발생
         * * JIT 컴파일러 최적화에도 유리 (branchless 연산은 컴파일러가 잘 최적화함)
         *
         * ✅ 실무 활용도
         * * A/B, ON/OFF, 0/1 등 고정 대칭 상태를 번갈아 처리할 때 유용
         * * 제어 플래그 전환, 토글, 이진 상태 스위칭 등에서 XOR은 간결하고 빠름
         *
         * ✅ 개선 코드
         * sb.append((char)(c ^ 3));   // 'A' ↔ 'B' 전환: 65 ^ 3 = 66, 66 ^ 3 = 65
         */
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : myString.toCharArray()) {
            sb.append(c == 'A' ? 'B' : 'A');
        }
        return sb.toString().contains(pat) ? 1 : 0;
    }
}

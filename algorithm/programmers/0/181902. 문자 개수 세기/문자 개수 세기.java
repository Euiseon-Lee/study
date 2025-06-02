class Solution {
    public int[] solution(String my_string) {
        /**
         * 🧮 알파벳 빈도 카운팅 - 대문자와 소문자를 구분하여 인덱싱
         *
         * ✅ 동작 방식
         * - A~Z는 배열 인덱스 0~25에 대응
         * - a~z는 배열 인덱스 26~51에 대응
         * - 아스키 코드 활용: 'A' = 65, 'a' = 97 → 소문자는 (char - 'a' + 26)으로 조정
         *
         * ✅ 성능적 이점
         * - List나 Map을 사용하지 않고 고정 배열(int[])을 사용하여 메모리 및 속도 효율 확보
         * - 박싱/언박싱 없이 원시 타입으로 처리하여 GC 부담도 없음
         *
         * ✅ 보완할 점
         * - 매직 넘버 65, 71 대신 'A', 'a' 등의 문자 리터럴 사용이 가독성 측면에서 좋음
         * - 입력이 반드시 영문자라는 전제 하에 안전하지만, 실무에서는 문자 범위 체크를 추가하는 것이 좋음
         *
         * ✅ 예시 인덱싱
         * - 'A' → 0  ⇒ 'A' - 'A'
         * - 'Z' → 25 ⇒ 'Z' - 'A'
         * - 'a' → 26 ⇒ 'a' - 'a' + 26
         * - 'z' → 51 ⇒ 'z' - 'a' + 26
         *
         * ✅ 결론
         * - 기능적 완성도, 효율성, 안정성을 모두 충족하는 코드
         * - 특히 불필요한 박싱/언박싱이 없고, `char` → `int[]` 매핑이 직관적이며 깔끔함
         */
        int[] answer = new int[52];
        int offset = 'Z' - 'A' + 1;         // 대문자 개수 = 26
        for(int i = 0; i < my_string.length(); i++) {
            char temp = my_string.charAt(i);
            if (Character.isUpperCase(temp)) {
                //answer[temp - 65]++;
                answer[temp - 'A']++;
            } else {
                //answer[temp - 71]++;
                answer[temp - 'a' + offset]++;
            }
        }
        return answer;
    }
}

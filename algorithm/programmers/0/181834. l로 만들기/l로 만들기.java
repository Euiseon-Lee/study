class Solution {
    public String solution(String myString) {
        /**
         * ✅ 문제 요약  
         *  - 주어진 문자열에서 알파벳 'l'(ASCII 108)보다 작은 문자는 모두 'l'로 치환하여 새로운 문자열을 생성  
         *  - 예: "abc" → "lll", "love" → "llove"  
         *
         * 🔁 기존 코드 로직 요약  
         *  - StringBuilder를 사용하여 새로운 문자열을 누적 생성  
         *  - 각 문자에 대해 ASCII 값이 108보다 작으면 'l'로, 아니면 그대로 append  
         *
         * ✅ 개선 코드  
         *  - 기존 코드가 깔끔하고 성능적으로도 안정적이므로 구조 자체는 유지  
         *  - 다만 매직 넘버 108을 문자 리터럴 'l'로 변경하면 가독성이 향상됨  
         *
         *    class Solution {
         *        public String solution(String myString) {
         *            StringBuilder answer = new StringBuilder();
         *            for (int i = 0; i < myString.length(); i++) {
         *                char c = myString.charAt(i);
         *                answer.append(c < 'l' ? 'l' : c);
         *            }
         *            return answer.toString();
         *        }
         *    }
         *
         * 🔍 기존 코드 vs 개선 코드 차이점  
         *  1. 가독성  
         *     - 기존 코드: ASCII 코드 108 사용 → 의도가 명확히 드러나지 않음  
         *     - 개선 코드: 'l' 문자 리터럴 사용 → 코드의 의미가 바로 읽힘  
         *
         *  2. 성능  
         *     - 동일한 시간복잡도 O(n)  
         *     - 테스트 결과 평균 1~8ms로 안정적 → 개선 코드도 동일 수준 유지  
         *
         *  3. 실무 적용성  
         *     - ASCII 코드 직접 비교는 유지보수에 불리함  
         *     - 명시적 문자 리터럴 사용이 바람직함 (e.g., 'l' 대신 108은 하드코딩으로 인식됨)  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(n), 문자열 길이만큼 한 번 순회  
         *  - 공간복잡도: O(n), StringBuilder에 결과를 담아 반환  
         *  - 테스트 수행 시간: 평균 1ms~8ms로 우수  
         *
         * 🛠 실무 활용도  
         *  - 입력 문자 조건 필터링 및 치환 로직의 기초 구조로 활용 가능  
         *  - 대소문자 비교 시에도 같은 방식으로 활용 가능 (e.g., c < 'A' 등)  
         *  - StringBuilder 사용은 문자열 연결에 있어 실무에서도 가장 권장되는 방식  
         */
        StringBuilder answer = new StringBuilder();
        for (char c : myString.toCharArray()) {
            answer.append(c < 108 ? 108 : c);
        }
        return answer.toString();
    }
}

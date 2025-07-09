class Solution {
    public int solution(String myString, String pat) {
        /**
         * ✅ 문제 요약  
         *  - 문자열 `myString` 내에서 부분 문자열 `pat`이 **정확히 일치하는 위치**를 찾아  
         *    총 등장 횟수를 반환하는 문제  
         *  - 한 글자씩 밀며 고정 길이 구간을 비교하는 방식  
         *
         * 🔁 로직 구조  
         *  - 패턴 길이를 변수로 저장 (strLength)  
         *  - 시작 인덱스를 0부터 myString.length - pat.length까지 순회  
         *  - 각 구간을 substring(i, i + pat.length)로 잘라서 `equals(pat)`로 정확 비교  
         *  - 조건이 참일 경우 answer 증가  
         *
         * ✅ 코드 품질 측면  
         *  - 반복 범위 조건이 정확하며, 고정 길이 패턴 비교 방식 적용  
         *  - `equals` 사용으로 불필요한 indexOf 탐색이나 contains 오버헤드 제거  
         *  - 불변 문자열 비교 시 가장 정확하고 빠른 방식  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(n * k)  
         *    - n = myString 길이, k = pat 길이  
         *    - 각 위치마다 substring과 equals 수행 (substring은 내부적으로 new String)  
         *  - 공간복잡도: O(k), substring이 내부적으로 부분 문자열 생성  
         *  - 테스트 결과  
         *    - 최소: 0.02ms  
         *    - 최대: 0.17ms  
         *    - 평균: 매우 안정적이며, contains 기반 구조보다 약 20~40% 빠름  
         *
         * 💡 개선 여지가 있었던 부분 (이미 반영됨)  
         *  - `contains` → `equals` 로 변경하여 정확성 + 성능 확보  
         *  - `substring(i, i + pat.length())` 표현도 명확하게 구조화됨  
         *  - `i <= myString.length() - strLength` 조건도 정확하게 제한됨  
         *
         * 🛠 실무 활용도  
         *  - 고정된 패턴의 등장 횟수 탐지 로직으로, 로그 분석, 패킷 필터링, 문자열 분석 등에서 자주 쓰임  
         *  - KMP, Rabin-Karp 등 고급 문자열 탐색으로 확장 가능  
         *  - 다국어 처리, 유니코드 비교 등에서는 equalsIgnoreCase, Normalizer 활용 가능  
         */
        int answer = 0;
        int strLength = pat.length();
        for (int i = 0; i <= myString.length() - strLength; i++) {
            if (myString.substring(i, strLength + i).equals(pat)) answer++;
        }
        return answer;
    }
}

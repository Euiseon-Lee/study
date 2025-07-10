class Solution {
    public int solution(String binomial) {
        /**
         * ✅ 문제 요약  
         *  - 문자열 수식 `"a op b"` 형태의 문자열을 파싱하여 연산 결과를 반환  
         *    - 예: "3 + 4" → 7  
         *
         * 🔁 로직 구조  
         *  - 공백 기준 split → ["a", "op", "b"]  
         *  - 각 피연산자 문자열을 정수로 변환  
         *  - switch 문으로 연산자에 따라 결과 바로 반환  
         *
         * ✅ 코드 품질  
         *  - `int answer` 변수 제거 → 코드 간결화  
         *  - 각 case에서 바로 return → 불필요한 흐름 분기 최소화  
         *  - 유효하지 않은 연산자(default)는 0을 반환 (입력 보장 시 생략도 가능)  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(1) (항상 동일한 구조의 3요소 입력)  
         *  - 공간복잡도: O(1) (소규모 배열, 정수 2개)  
         *  - 실행 시간: 평균 0.06ms~0.11ms → 매우 안정적  
         *
         * 🛠 실무 활용도  
         *  - 수식 파싱의 기초 단계로, 계산기, DSL 파서, 문자열 수식 처리 등에 활용 가능  
         *  - 수식 확장 시 `case "/"`, `"%"`, `"^"` 등 추가 가능  
         *  - 잘못된 연산자 처리 시 예외 던지기나 로깅 구조로 변경 가능  
         */
        String[] arr = binomial.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String op = arr[1];
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: return 0;
        }
    }
}

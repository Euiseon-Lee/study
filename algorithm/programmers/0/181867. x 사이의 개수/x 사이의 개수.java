class Solution {
    public int[] solution(String myString) {
        /**
         * ✅ 문제 요약  
         *  - 주어진 문자열 `myString`을 문자 `'x'`를 기준으로 분할  
         *  - 분할된 각 문자열 조각의 **길이**를 정수 배열로 반환  
         *  - 모든 `'x'` 구간 사이의 문자열 길이를 보존해야 하며, **마지막이 'x'로 끝나는 경우 빈 문자열도 포함되어야 함**  
         *
         * 🔁 로직 구조  
         *  - `split("x", -1)`을 사용하여 `'x'`를 기준으로 문자열을 자르되, **빈 문자열도 포함**  
         *  - 분할된 배열의 각 요소에 대해 `length()`를 적용하여 정수 배열로 변환  
         *
         * ✅ 코드 품질  
         *  - `split(String regex, int limit)`의 limit을 `-1`로 설정하여 **모든 토큰 포함**한 점이 핵심  
         *  - 반복문을 통해 문자열 배열 → 정수 배열로 매핑하는 구조가 명확하고 효율적  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(n), n은 문자열 길이  
         *    - split: 문자열 전체 1회 순회  
         *    - 길이 측정 루프: 각 조각에 대해 O(1)  
         *  - 공간복잡도: O(k), k는 조각 수  
         *  - 테스트 결과  
         *    - 평균 실행 시간: 0.06ms ~ 4.66ms  
         *    - 문자열이 길어질수록 split 처리 비용이 올라감 (문자 수 + 조각 수 비례)  
         *
         * 🛠 실무 활용도  
         *  - delimiter 기반 분리 후 길이 측정 구조는 **CSV 파싱, 텍스트 분석, 필드 길이 검증 등**에서 매우 유용  
         *  - `split(..., -1)` 패턴은 실무에서도 **"빈 필드 유지"** 가 필요한 경우 반드시 사용해야 함  
         *    - 예: `"a,x,b,x,x"` → `["a", "", "b", "", ""]`  
         *  - stream + mapToInt + lambda 구조로도 변환 가능하지만 현재 구조가 성능상 더 효율적  
         */
        String[] arr = myString.split("x", -1);
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].length();
        }
        return answer;
    }
}

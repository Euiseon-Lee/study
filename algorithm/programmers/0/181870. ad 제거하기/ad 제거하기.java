import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        /**
         * ✅ 문제 요약  
         *  - 문자열 배열 `strArr`에서 "ad"라는 부분 문자열이 포함되지 않은 문자열만 걸러 새로운 배열로 반환  
         *
         * 🔁 기존 코드 로직 요약 (의선 작성)  
         *  - "ad"를 포함하지 않는 문자열의 **인덱스**를 ArrayList<Integer>로 수집  
         *  - 해당 인덱스를 기반으로 원래 배열에서 문자열을 다시 꺼내 `answer` 배열에 담음  
         *  - 구조상 배열에 두 번 접근하며, 추가적인 인덱스 리스트도 생성됨  
         *
         * ✅ 개선 코드  
         *  - 인덱스를 따로 추적하지 않고, 조건에 맞는 문자열을 직접 List<String>에 저장  
         *  - 마지막에 List를 배열로 변환하여 반환  
         *  - 가독성, 성능, 실무 사용성 모두 향상됨  
         *
         *    class Solution {
         *        public String[] solution(String[] strArr) {
         *            List<String> list = new ArrayList<>();
         *            for (String s : strArr) {
         *                if (!s.contains("ad")) {
         *                    list.add(s);
         *                }
         *            }
         *            return list.toArray(new String[0]);
         *        }
         *    }
         *
         * 🔍 기존 코드 vs 개선 코드 비교  
         *  1. 반복 구조  
         *     - 기존: 2번 루프 (조건 필터 + 인덱스 접근)  
         *     - 개선: 1번 루프 (문자열 직접 수집)  
         *
         *  2. 자료구조  
         *     - 기존: ArrayList<Integer> + String[]  
         *     - 개선: List<String> → String[]  
         *
         *  3. 성능 측정 결과  
         *     - 기존 코드 평균 실행 시간: 약 0.03ms ~ 1.69ms  
         *     - 개선 코드 평균 실행 시간: 약 0.03ms ~ 0.82ms  
         *     → **최댓값 기준 약 50% 이상 성능 향상** (특히 입력 크기가 클수록 효과 큼)  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(n)  
         *    - 각 문자열에 대해 contains() 1회, 조건 통과 시 리스트 추가  
         *  - 공간복잡도: O(n), 조건을 통과한 문자열 수만큼 리스트 할당  
         *
         * 🛠 실무 활용도  
         *  - 문자열 필터링 문제의 일반적인 구조이며, stream보다 명시적 루프가 유지보수 측면에서 안전함  
         *  - toArray(new String[0])은 실무에서도 안전하고 타입 안정성이 높아 선호되는 변환 방식  
         *  - stream 사용보다 성능이 더 나은 경우가 많고, 디버깅 시도 쉽기 때문에 실전에서 더 많이 쓰임  
         */
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                arr.add(i);
            }
        }
        String[] answer = new String[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = strArr[arr.get(i)];
        }
        return answer;
    }
}

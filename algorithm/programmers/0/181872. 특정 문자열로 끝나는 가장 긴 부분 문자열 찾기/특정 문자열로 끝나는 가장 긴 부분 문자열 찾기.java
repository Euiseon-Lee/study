class Solution {
    public String solution(String myString, String pat) {
        /**
         * ✅ 문제 요약  
         *  - 문자열 `myString`에서 `pat`이 마지막으로 등장하는 위치까지의 부분 문자열을 잘라서 반환  
         *  - 즉, `pat`이 끝나는 지점까지의 서브스트링을 추출  
         *
         * 🔁 기존 코드 로직 요약  
         *  - `lastIndexOf(pat)`를 통해 pat의 마지막 등장 위치를 찾음  
         *  - `substring(0, index + pat.length())`로 해당 위치까지 자름  
         *  - 단 한 줄로 명확하게 구현되어 있음  
         *
         * ✅ 개선 코드  
         *  - 현재 코드가 최적 구조로 더 이상 개선할 부분 없음  
         *  - 예외 처리를 추가한다면 `lastIndexOf(pat)`가 -1일 때 빈 문자열을 반환하도록 보완 가능  
         *
         *    class Solution {
         *        public String solution(String myString, String pat) {
         *            int idx = myString.lastIndexOf(pat);
         *            return idx == -1 ? "" : myString.substring(0, idx + pat.length());
         *        }
         *    }
         *
         * 🔍 기존 코드 vs 개선 코드 차이점  
         *  - 기존: `lastIndexOf(pat)` 결과가 -1일 경우 예외가 발생할 수 있음  
         *  - 개선: 해당 경우 빈 문자열을 반환하여 안정성 확보  
         *  - 실무에서는 입력 유효성을 항상 고려해야 하므로 방어적 코딩이 권장됨  
         *
         * ⚙️ 성능 분석  
         *  - 시간복잡도: O(n), `lastIndexOf`는 문자열 전체를 한 번 순회함  
         *  - 공간복잡도: O(k), 추출된 부분 문자열의 길이 k  
         *  - 테스트 결과: 0.01ms ~ 0.07ms로 **모든 테스트에서 안정적으로 통과**  
         *
         * 🛠 실무 활용도  
         *  - 특정 패턴까지 문자열을 잘라내는 처리 구조는 **로그 파싱, 파일 이름 추출, 경로 자르기 등**에서 매우 자주 등장  
         *  - 예외 케이스 대응 (`lastIndexOf == -1`)은 실무에서 필수  
         *  - 한 줄로 처리할 수 있는 간결한 표현이지만, 가독성과 안전성을 고려해 최소한의 방어 로직을 추가하는 것이 좋음  
         */        
        return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }
}

import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        /**
         * 🔍 코드 평가 및 개선 관점 정리
         *
         * ✅ 문제 조건 반영
         * - survey의 양방향 성격 유형 점수 구조를 정확히 해석하고 구현함
         * - choice 값에 따라 점수 차등 적용, 중립 처리(4점) 생략 등 조건을 모두 반영함
         * - 점수가 같을 경우 사전순 우선 선택 로직도 완벽히 구현되어 있음
         *
         * ✅ 코드 효율성
         * - 점수 누적에 Map<Character, Integer> 사용 → O(1) 접근으로 효율적
         * - 반복문 내 조건 분기 최소화 (score < 4, > 4만 사용) → 성능적으로 매우 안정적
         * - 결과 조합은 StringBuilder 사용으로 문자열 결합 비용 최소화
         *
         * ✅ 가독성 및 유지보수
         * - 변수명 명확함 (cons, pros, score 등 → 직관적이고 역할 분명)
         * - 성격 유형 비교 루프도 간결하고 반복 구조를 잘 활용함
         * - 전반적으로 코드 길이에 비해 로직이 명확하게 드러나 유지보수에 강함
         *
         * ✅ 실무 적합성
         * - Map을 통한 점수 누적은 실무에서도 유저 행동 분석, 태그 스코어링 등에 자주 쓰이는 구조임
         * - 고정된 성격 유형 지표 배열로 기준 순서를 정해두는 방식도 실무 보고서 생성 시 자주 활용됨
         * - 선택지 점수 변환 구조는 설문 데이터 정제에도 유사하게 사용됨
         *
         * ✅ 보완 및 확장 가능성
         * - choice → 점수 매핑을 if 없이 배열 또는 Map으로 추상화할 수 있음
         *     예: int[] scoreMap = {0, 3, 2, 1, 0, 1, 2, 3}; 사용 가능
         * - 지표별 점수를 Map이 아닌 char[] 배열로 구조화하면 메모리 절감 가능
         * - 단위 테스트 함수 작성 시 지표별 점수 비교 기능을 분리해 테스트하기 용이함
         *
         * 🧠 공부할 개념 추천
         * - Java 8 이후 Optional 활용 시 null 방어적 점수 계산 구조
         * - LinkedHashMap으로 지표 순서 고정하면서 누적하는 방식 (정렬 유지 필요 시)
         * - 사용자 응답 데이터를 통계적으로 다루는 패턴 → 점수 매핑 외에도 추천 시스템 기초
         */
        StringBuilder answer = new StringBuilder();
        String[] types = {"RT", "CF", "JM", "AN"};
        Map <Character, Integer> map = new HashMap<>();
        for (int i = 0; i < choices.length; i++) {
            char cons = survey[i].charAt(0);
            char pros = survey[i].charAt(1);
            int score = choices[i];
            if (score < 4) {
                map.put(cons, map.getOrDefault(cons, 0) + 4 - score);
            } else if (score > 4) {
                map.put(pros, map.getOrDefault(pros, 0) + score - 4);
            }
            
        }
        
        for (String type : types) {
            char first = type.charAt(0);
            char second = type.charAt(1);
            
            answer.append(map.getOrDefault(first, 0) >= map.getOrDefault(second, 0) ? first : second);
        }
        
        return answer.toString();
    }
}

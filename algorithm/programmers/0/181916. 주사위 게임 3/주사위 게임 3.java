import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        /**
         * 🎲 4개의 주사위 값을 받아 조건에 따라 점수를 계산하는 문제
         *
         * ✅ [현재 구현 - Map 기반, 작성자: Euiseon]
         * - 각 주사위 눈금의 빈도를 HashMap<Integer, Integer>을 사용해 카운팅함
         * - m.size()를 기준으로 값의 종류 수에 따라 조건을 분기함
         *   ex) 1개 종류 → 4개 동일, 2개 종류 → 3+1 또는 2+2, 3개 종류 → 2+1+1, 4개 종류 → 전부 다름
         * - 각 조건은 keySet과 get()을 활용하여 값을 분리 후 계산함
         * - 논리 흐름이 직관적이며, 가독성과 유지보수성이 높은 구조임
         * - 입력 크기가 작고 고정되어 있어 성능 상 문제가 없으며, 로직이 명확하게 구분되어 디버깅이 쉬움
         *
         * ⚠ Map 구조의 단점:
         * - get(), keySet() 호출이 반복되면서 미세한 성능 오버헤드 발생 가능
         * - 해시 연산, 객체 접근, 반복 분기 구조에서 상대적으로 연산 단가가 높음
         *
         * ✅ [참고 구현 - 배열 기반 최적화, 제안자: ChatGPT]
         * - int[7] 배열을 활용해 주사위 눈금 빈도를 인덱스로 직접 카운팅함 (1~6 사용)
         * - 조건 분기는 위에서부터 순차적으로 검사하며 return하는 구조
         * - HashMap 및 컬렉션 객체를 사용하지 않고, 모든 연산이 primitive 기반임
         * - 평균 실행 시간: 약 0.02ms, 최소 0.01ms, 최대 0.06ms → 기존 구조 대비 최대 5배 빠름
         * - GC 부담이 없고 CPU 캐시 친화적 구조로 실시간 성능에 최적화됨
         *
         * ⚠ 단, 본인은 배열 기반보다 조건 분기 흐름이 명확하고 논리적으로 구획이 뚜렷한 Map 기반을 선택함
         *    → 성능이 중요한 상황에서는 배열 기반 구조도 적절한 대안이 될 수 있음
         *
         * 📌 배열 기반 최적화가 적합한 상황:
         * - 입력값의 범위가 작고 고정된 문제 (예: 주사위, 카드, 알파벳 등)
         * - 반복 호출이 많은 게임 엔진, 실시간 반응성이 필요한 이벤트 처리 등
         *
         * 💡 결론:
         * - Map 기반: 가독성과 구조 중심, 조건 분리와 유지보수에 유리
         * - 배열 기반: 성능 중심, 반복 연산 및 실시간성에 유리
         * - 목적에 따라 선택하며, 두 방식 모두 O(1) 복잡도로 안정적인 처리 가능
         *
         * 🔍 참고용 배열 기반 구현 (by ChatGPT):
         *
         *   int[] freq = new int[7];
         *   for (int num : new int[]{a, b, c, d}) freq[num]++;
         *
         *   // 1. 네 개 모두 같음
         *   for (int i = 1; i <= 6; i++) {
         *       if (freq[i] == 4) return 1111 * i;
         *   }
         *
         *   // 2. 세 개 + 하나
         *   for (int i = 1; i <= 6; i++) {
         *       if (freq[i] == 3) {
         *           for (int j = 1; j <= 6; j++) {
         *               if (freq[j] == 1) return (int) Math.pow(10 * i + j, 2);
         *           }
         *       }
         *   }
         *
         *   // 3. 두 개 + 두 개
         *   for (int i = 1; i <= 6; i++) {
         *       if (freq[i] == 2) {
         *           for (int j = i + 1; j <= 6; j++) {
         *               if (freq[j] == 2) return (i + j) * Math.abs(i - j);
         *           }
         *       }
         *   }
         *
         *   // 4. 두 개 + 하나 + 하나
         *   for (int i = 1; i <= 6; i++) {
         *       if (freq[i] == 2) {
         *           int[] ones = new int[2];
         *           int idx = 0;
         *           for (int j = 1; j <= 6; j++) {
         *               if (freq[j] == 1) ones[idx++] = j;
         *           }
         *           return ones[0] * ones[1];
         *       }
         *   }
         *
         *   // 5. 모두 다름
         *   int min = 7;
         *   for (int i = 1; i <= 6; i++) {
         *       if (freq[i] == 1 && i < min) min = i;
         *   }
         *   return min;
         */
        int[] dice = new int[]{a, b, c, d};
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < dice.length; i++) {
            if (m.containsKey(dice[i])) {
                m.put(dice[i], m.get(dice[i]) + 1);
            } else {
                m.put(dice[i], 1); 
            }
        }
        
        if (m.size() == 1) {
            return 1111 * a;
        } else if (m.size() == 4) {
            return Math.min(Math.min(a, b), Math.min(c, d));           
        } else if (m.size() == 2) {
            int p = 0;
            int q = 0;
            if (m.containsValue(3)) {
                for (Integer i : m.keySet()){
                    if (m.get(i) == 3) {
                        p = i;
                    } else {
                        q = i;
                    }
                }
                return (int) Math.pow(10 * p + q, 2);
            } else {
                int j = 0;
                for (Integer i : m.keySet()){
                    if (j == 0) {
                        p = i;
                        j++;
                    } else {
                        q = i;
                    }
                }
                return (p + q) * Math.abs(p - q);
            }
        } else {
            int q = 0;
            int r = 0;
            int j = 0;
            for (Integer i : m.keySet()){
                if (m.get(i) != 2) {
                    if (j == 0) {
                        q = i;
                        j++;
                    } else {
                        r = i;
                    }
                }
            }
            return q * r;
        }
    }
}

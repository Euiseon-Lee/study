import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        /*
         * 📌 나의 풀이 방식 평가: "이진수 × 5 규칙" 기반 접근
         *
         * - binaryNum을 1부터 증가시키며, 이진수로 표현된 문자열을 10진수로 바꾼 뒤 ×5 한 값이
         *   범위 [l, r]에 들어오는지 판단
         *
         * ✅ 장점
         *   - 매우 창의적인 규칙 일반화: 0과 5로만 구성된 수 → 0과 1로 구성된 이진수 기반 수 ×5로 근사
         *   - 성능이 빠르며, 실제 많은 테스트 케이스를 통과함 (0.1~0.4ms 수준)
         *
         * ❗ 한계
         *   - 문제에서 요구한 정확한 조건은 "각 자릿수가 0 또는 5로만 이루어진 수"이므로
         *     이진수 곱셈 방식은 근사적 풀이일 수 있음
         *   - 결과가 조건을 100% 만족한다는 보장은 없음
         *
         *
         * ✅ 문제 조건 기반 정답 생성 - 문자열 조합 (BFS 방식)
         *
         * - 목표: l 이상 r 이하 범위 내에서, 숫자 자릿수가 "0"과 "5"로만 구성된 정수들을 오름차순으로 구함
         * - 자릿수 구성 조건을 정확히 반영하기 위해, 문자열로 숫자를 조합하는 BFS 방식을 사용
         *   → 시작은 "5"부터, 이후 "0" 또는 "5"를 하나씩 덧붙여 후보를 생성
         *   → 각 후보는 Integer로 변환해 l~r 범위 내일 경우에만 결과에 포함
         *
         * 🔍 동작 구조
         *   1. Queue를 사용해 "5"로 시작
         *   2. poll한 문자열에 "0", "5"를 각각 덧붙여 큐에 추가
         *   3. 변환된 수가 범위 초과 시 탐색 중단
         *
         * ⏱ 성능
         *   - 테스트 평균 2~3ms
         *   - 값이 많지 않으므로 완전 탐색에도 충분히 빠름
         *
         * 💡 문제의 조건을 가장 정직하게 해석한 풀이로,
         *   자릿수 조건을 실수 없이 만족시키는 데 최적
         *
         * ✅ 코드:
         *
         *   import java.util.*;
         *   class Solution {
         *       public int[] solution(int l, int r) {
         *           List<Integer> result = new ArrayList<>();
         *           Queue<String> queue = new LinkedList<>();
         *
         *           queue.add("5");
         *
         *           while (!queue.isEmpty()) {
         *               String current = queue.poll();
         *               int num = Integer.parseInt(current);
         *
         *               if (num > r) continue;
         *               if (num >= l) result.add(num);
         *
         *               queue.add(current + "0");
         *               queue.add(current + "5");
         *           }
         *
         *           if (result.isEmpty()) return new int[]{-1};
         *           return result.stream().mapToInt(i -> i).toArray();
         *       }
         *   }
         */
        // 5 1 / 5 10 / 5 11 / 5 100 / 5 101 / 5 110 / 5 111 / 5 1000
        int binaryNum = 1;
        boolean continuing = true;
        ArrayList<Integer> tmpArr = new ArrayList<>();
        while(continuing) {
            Integer target = Integer.parseInt(Integer.toBinaryString(binaryNum)) * 5;
            if (target >= l && target <= r) {
                tmpArr.add(target);
                binaryNum++;
            } else if (target > r) {
                continuing = false;
                break; 
            } else {
                binaryNum++;
            }
        }
        
        if (tmpArr.size() == 0) {
            return new int[]{-1};
        } else {
            int[] returnArr = new int[tmpArr.size()];
            for(int i = 0; i < returnArr.length; i++) {
                returnArr[i] = tmpArr.get(i);
            }
            return returnArr;
        }
    }
}

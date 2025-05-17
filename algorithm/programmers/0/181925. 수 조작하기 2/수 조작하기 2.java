class Solution {
    public String solution(int[] numLog) {
        /*
         * ✅ 시도한 방식 3가지 비교 및 성능 분석
         * 
         * 1️⃣ 현재 코드: switch-case 방식
         * 
         * - 조건이 정수형이고 고정되어 있어 switch-case가 가장 빠름
         * - JVM이 tableswitch 또는 lookupswitch로 최적화
         * - 연산만으로 처리하며 불필요한 객체 생성 없음
         * - 조건이 바뀔 경우 유지보수에는 다소 불편할 수 있음
         * 
         * 실행 성능:
         *   - 평균 실행 시간: 1~7ms
         *   - 메모리 사용량: 70~95MB
         * 
         * 
         * 2️⃣ HashMap 방식 (조건 확장 및 유지보수 목적 실험)
         * 
         *   Map<Integer, String> map = new HashMap<>();
         *   map.put(1, "w");
         *   map.put(-1, "s");
         *   map.put(10, "d");
         *   map.put(-10, "a");
         * 
         *   for (int i = 0; i < numLog.length - 1; i++) {
         *       int key = numLog[i + 1] - numLog[i];
         *       sb.append(map.get(key));
         *   }
         * 
         * - 조건이 많아질 경우 수정이 간편함
         * - 코드 가독성도 높지만, 루프 내에서 map.get() 반복 호출로 성능 저하 발생
         * - Integer 오토박싱 + 참조 탐색 비용이 누적됨
         * 
         * 실행 성능:
         *   - 평균 실행 시간: 5~11ms
         *   - 메모리 사용량: 80~95MB
         * 
         * 
         * 3️⃣ Map.of() 방식 (불변 Map 구조 실험)
         * 
         *   Map<Integer, Character> map = Map.of(
         *       1, 'w',
         *       -1, 's',
         *       10, 'd',
         *       -10, 'a'
         *   );
         * 
         *   for (int i = 0; i < numLog.length - 1; i++) {
         *       sb.append(map.get(numLog[i + 1] - numLog[i]));
         *   }
         * 
         * - 선언은 간결하고 안전하지만, 내부적으로는 MapN 구조로 탐색 성능이 좋지 않음
         * - 반복 루프에서의 get 호출로 인해 가장 느린 결과가 나왔음
         * - 또한 오토박싱 + 참조 탐색 비용이 동일하게 존재함
         * 
         * 실행 성능:
         *   - 평균 실행 시간: 13~26ms
         *   - 메모리 사용량: 80~106MB
         * 
         * 
         * ✅ 결론
         * - 이 문제는 조건이 작고 고정되어 있기 때문에 switch-case 방식이 가장 적합하다.
         * - HashMap과 Map.of()는 조건이 많아질 경우 고려할 수 있지만, 루프 내 반복 성능은 떨어진다.
         */
        StringBuilder sb = new StringBuilder();        
        for (int i = 0; i < numLog.length - 1; i++) {
            switch (numLog[i+1] - numLog[i]) {
                case 1: sb.append("w");
                    break;
                case -1: sb.append("s");
                    break;
                case 10: sb.append("d");
                    break;
                case -10: sb.append("a");
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }
}

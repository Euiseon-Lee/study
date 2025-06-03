class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        /** ✂️ 슬라이싱 조건 통합 처리 – 명시적 분기와 공통 흐름의 균형 잡힌 설계
        
         * ✅ 너의 기존 코드 평가 (switch-case 방식)
         * - 장점: n에 따라 각 동작을 명확하게 구분함. 직관적이고 디버깅이 쉬움
         * - 구조: case 1~4로 분기하여 각기 다른 범위에 대해 배열을 잘라냄
         * - 성능: 테스트 결과 모두 0.01~0.03ms로 매우 우수
         * - 단점:
         *   1. 각 case에서 배열 생성과 루프가 반복되어 중복 발생
         *   2. case 4의 range 계산 방식이 실제 슬라이스 개수와 다를 수 있음
         *   3. 유지보수 시 케이스가 늘어나면 코드량과 수정 포인트가 급증
        
         * 🔁 개선 방향: 처리 흐름은 같고 값만 다르므로 공통화 구조가 더 적절
        
         * 🧩 개선된 하이브리드 코드 (공통 루프 기반)
         *   int start = (n == 1) ? 0 : slicer[0];
         *   int end = (n == 2) ? num_list.length - 1 : slicer[1];
         *   int step = (n == 4) ? slicer[2] : 1;
         *   int size = ((end - start) / step) + 1;
        
         *   int[] result = new int[size];
         *   for (int i = start, idx = 0; i <= end; i += step) {
         *       result[idx++] = num_list[i];
         *   }
         *   return result;
        
         * 🧠 구조적 시사점
         * - 처리 대상이 되는 인덱스 범위(start, end, step)만 분기 처리
         * - 배열 생성과 루프는 단일 흐름으로 통합하여 중복 제거
         * - 슬라이싱이라는 공통 행위를 중심에 두고 설계를 재구성한 사례
        
         * 🚀 성능 및 확장성 이점
         * - 하나의 루프로 처리되므로 CPU 분기 예측 효율적
         * - O(k) 시간 복잡도로 빠르게 동작하며 메모리도 효율적으로 사용
         * - n의 조건이 확장되더라도 값 설정만 추가하면 되므로 유지보수 용이
        
         * 📌 실전 설계 전략
         * 1. 로직이 같은데 입력값만 다르다면, 분기된 값만 설정하고 공통 처리로 묶을 수 있는지 판단
         * 2. switch-case는 디버깅과 로그 삽입에 유리하나, 구조적 반복이 생기면 리팩토링 대상
         * 3. 슬라이싱, 정렬, 필터링처럼 데이터 흐름이 동일한 작업에서는 하이브리드 구조가 우선 고려 대상
         * 4. 수학적으로 결과 개수를 예측할 수 있는 경우 배열 크기를 정확히 계산하는 습관을 들일 것
        
         * 🎯 학습 포인트 (Level 3 → Level 4 전환 핵심)
         * - 설계를 단순히 나눈다는 개념을 넘어, 구조를 추상화하고 공통 흐름을 식별할 수 있는 능력이 중요
         * - 이 문제는 "입력 분기 vs 처리 분리"라는 판단 기준을 실습할 수 있는 좋은 트리거가 됨
         * - 앞으로도 중복되는 처리 흐름이 있다면 반드시 공통화 가능성을 먼저 탐색할 것
         */
        int[] answer = {};
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int range = n == 1 ? b + 1 : n == 2 ? num_list.length - a : b - a + 1; 
        switch (n) {
            case 1: answer = new int[range];
                for (int i = 0; i < range; i++) {
                    answer[i] = num_list[i];
                }
                break;
            case 2: answer = new int[range];
                for (int i = a, idx = 0; i < num_list.length; i++) {
                    answer[idx++] = num_list[i];
                }
                break;
            case 3: answer = new int[range];
                for (int i = a, idx = 0; i < b + 1; i++) {
                    answer[idx++] = num_list[i];
                }
                break;
            //case 4: answer = new int[range - (range / c)];        // 테스트는 통과했지만 부정확한 범위
            case 4: answer = new int[(b - a) / c) + 1];
                for (int i = a, idx = 0; i < b + 1; i += c) {
                    answer[idx++] = num_list[i];
                }
                break;
        }        
        return answer;
    }
}

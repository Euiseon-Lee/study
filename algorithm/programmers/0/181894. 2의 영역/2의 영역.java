import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        /** 🔍 배열 내 특정 값의 최소 포함 범위 추출 – 최소/최대 인덱스 추적 방식
         *
         * ✅ 문제 요약
         * - 정수 배열 arr에서 숫자 2가 포함된 최소 연속 부분 배열을 추출
         * - 단, 2가 하나도 없다면 [-1] 반환
         *
         * ✅ 핵심 로직
         * - 배열을 한 번 순회하면서:
         *   - 2를 처음 발견한 인덱스를 minIdx에 저장
         *   - 2를 마지막으로 발견한 인덱스를 maxIdx에 저장
         * - 2가 없으면 maxIdx는 그대로 -1이므로 [-1] 반환
         * - 2가 있으면 Arrays.copyOfRange(arr, minIdx, maxIdx + 1)로 슬라이싱 반환
         *
         * 🚀 성능
         * - 시간복잡도: O(n), 공간복잡도: O(k) (k는 minIdx ~ maxIdx 길이)
         * - 테스트 케이스 모두 통과 (최대 4.81ms) → 매우 안정적인 성능
         *
         * 📌 실무 설계 팁
         * 1. 범위 추적 문제에서는 min/max index를 동시에 갱신하면 한 번의 루프로 끝낼 수 있음
         * 2. Arrays.copyOfRange()는 [from, to) 범위이므로 종료값은 maxIdx + 1로 지정해야 함
         * 3. 초기값을 minIdx=100001, maxIdx=-1처럼 경계값 바깥으로 설정하면 조건 처리에 유리
         *
         * 🎯 학습 포인트
         * - 연속된 값의 첫/마지막 위치를 추적하는 패턴은 문자열, 배열, 로그 분석 등에서 자주 활용됨
         * - 조건 분기 처리를 인덱스 값으로 판별하면 코드가 깔끔하고 명시적
         * - Java의 배열 복사 함수 활용법 (copyOfRange)는 반복 루프 없이 서브배열 추출할 수 있는 유용한 방법
         */
        int minIdx = 100001;
        int maxIdx = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 2){
                minIdx = Math.min(minIdx, i);
                maxIdx = Math.max(maxIdx, i);
            }
        }
        return maxIdx == -1 ? new int[] {-1} : Arrays.copyOfRange(arr, minIdx, maxIdx + 1);
    }
}

/**
 * ✅ 문제 조건
 * - arr의 길이가 홀수: 짝수 인덱스(0, 2, 4, ...)에 n을 더함
 * - arr의 길이가 짝수: 홀수 인덱스(1, 3, 5, ...)에 n을 더함
 *
 * 🔁 구현 방식
 * - 홀/짝 조건 분기로 start 인덱스 결정 (0 또는 1)
 * - 이후 i += 2로 step 증가하여 조건 인덱스만 순회
 *
 * 💡 개선 포인트
 * - start = (arr.length % 2 == 0 ? 1 : 0) 으로 조건식 최소화
 * - 원본 배열을 그대로 수정하고 반환 → 메모리 효율적
 *
 * ⚙️ 성능
 * - 시간복잡도: O(n/2) = O(n)
 * - 공간복잡도: O(1) (in-place 연산)
 * - 평균 실행 시간: 0.01ms ~ 0.04ms → 매우 빠름
 *
 * 🛠 실무 활용성
 * - 인덱스 제어가 필요한 로직에서 for 문 step을 통해 조건 분기를 피하는 방식은 유지보수 측면에서 유리
 * - 다만, 명확성을 위해 `if-else` 구조로 분리하는 것도 실무에서는 고려됨
 */
class Solution {
    public int[] solution(int[] arr, int n) {
        int start = arr.length % 2 == 0 ? 1 : 0; 
        for (int i = start; i < arr.length; i += 2) {
            arr[i] += n;
        }
        return arr;
    }
}

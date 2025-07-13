import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        /**
         * ✅ 배열 길이를 2의 거듭제곱 크기로 보정하는 함수
         *
         * 📌 문제 조건
         *  - 주어진 배열이 2의 거듭제곱 길이인지 확인
         *  - 아니라면, 그보다 큰 최소의 2의 거듭제곱 길이로 배열을 확장하여 반환
         *
         * 🧠 기존 방식 (String 기반):
         *  - Integer.toBinaryString()으로 이진 문자열 구함
         *  - 문자열 내 '1'의 개수를 직접 세지 않고 isComplete 플래그로 확인
         *  - Math.pow()로 최종 배열 길이 계산 후 Arrays.copyOf로 확장
         *  → 직관적이지만 문자열 연산 및 반복문 사용 → 성능적으로는 아쉬움
         *
         * 🎯 개선 아이디어: bitCount() 사용
         *  - Integer.bitCount(n) == 1이면 n은 2의 거듭제곱임 (이진수에서 1비트만 켜져 있음)
         *  - 문자열 반복 없이 O(1) 시간에 판단 가능
         *
         * 🚀 실무 최적화 버전 (비트 연산 기반):
         *  int len = arr.length;
         *  int nextPow2 = Integer.highestOneBit(len);
         *  if (nextPow2 != len) nextPow2 <<= 1;
         *  return Arrays.copyOf(arr, nextPow2);
         *
         * 🔍 이게 무슨 뜻이냐면...
         *  - Integer.highestOneBit(n): n보다 작거나 같은 가장 큰 2의 거듭제곱을 구함
         *    예: 6 → 4, 10 → 8, 16 → 16
         *  - <<= 1 은 *2와 동일한 비트 연산
         *    예: 4 <<= 1 → 8, 즉 다음 2의 거듭제곱을 구할 수 있음
         *  - 따라서 nextPow2 != len이면 현재 길이는 2의 거듭제곱이 아니므로, 다음 2^k로 확장
         *
         * 💡 실무 활용도:
         *  - 버퍼, 캐시, 세그먼트 트리, 메모리 최적화를 다룰 때 매우 자주 사용됨
         *  - 특히 "2의 배수로 맞춰야 하는" 요구사항에서 중요한 트릭
         */
        String binary = Integer.toBinaryString(arr.length);
        int count = Integer.bitCount(arr.length) == 1 ? 1 : 0; 
        int length = (int) Math.pow(2, binary.length() - count);
        return Arrays.copyOf(arr, length);
    }
}

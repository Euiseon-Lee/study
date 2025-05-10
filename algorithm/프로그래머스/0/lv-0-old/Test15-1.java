import java.util.Arrays;
class Solution {
    /*
      문제 설명
        정수 배열 array와 정수 n이 매개변수로 주어질 때, 
        array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

      제한사항
        1 ≤ array의 길이 ≤ 100
        1 ≤ array의 원소 ≤ 100
        1 ≤ n ≤ 100
        가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
    */
    public int solution(int[] array, int n) {
      // 처리 속도 0.32 ~ 0.53ms
      Arrays.sort(array);
      int index = 0;

      for (int i=0; i<array.length-1; i++) {
          if(Math.abs(n-array[index]) > Math.abs(n-array[i+1])) {
              index = i+1;
          } else{
              continue;
          }
      }
      return array[index];
    }
}

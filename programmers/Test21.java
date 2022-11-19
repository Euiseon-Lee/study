class Solution {
    /*
      문제 설명
        선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
          가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
          삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
          
        나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.

      제한사항
        sides의 원소는 자연수입니다.
        sides의 길이는 2입니다.
        1 ≤ sides의 원소 ≤ 1,000
    */
    public int solution(int[] sides) {
      //처리 속도 0.02 ~ 0.05ms
      int cnt = 0;
      int max = Math.max(sides[0], sides[1]);
          int total = sides[0] + sides[1];

      //max가 3 미만인 경우 가장 긴 변은 나머지 한 변이다.
      if(max>3) {
        for(int i=max+1; i<total; i++) {
          cnt++;
        }

      } else {
        ;
      }

      //가장 긴 변이 max인 경우 나머지 한 변과 sides[i]의 합보다 max가 작아야 한다.
      for(int i=max; i<total; i++) {
        cnt++;
      }
        return cnt;
    }
}

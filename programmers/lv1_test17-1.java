import java.util.Set;
import java.util.TreeSet;

class Solution {
    public Set<Integer> solution(int[] arr, int divisor) {
      /*
        문제 설명
          array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
          divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

         제한사항
          arr은 자연수를 담은 배열입니다.
          정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
          divisor는 자연수입니다.
          array는 길이 1 이상인 배열입니다.
      */
      
      Set<Integer> answer = new TreeSet<Integer>();
      Integer[] finalAnswer = {};

      for(int i = 0; i < arr.length; i++){
          if(arr[i] % divisor == 0){
            answer.add(arr[i]);
          }
      }

      //Set 객체의 toArray() 메소드 == Set 객체를 배열로 변환
      //이 때 배열의 길이를 0으로 잡으면 자동으로 크기가 정해짐
      if(answer.size()==0) {
        answer.add(-1);
        finalAnswer = answer.toArray(new Integer[0]);
      } else {
        finalAnswer = answer.toArray(new Integer[0]);
      }


      return finalAnswer;

    }
}

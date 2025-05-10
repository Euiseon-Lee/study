import java.util.Arrays;
class Solution {
    /*
    문제 설명
      최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 
      정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 
      최빈값이 여러 개면 -1을 return 합니다.

    제한사항
      0 < array의 길이 < 100
      0 ≤ array의 원소 < 1000
    */
  
    public int solution(int[] array) {
        
      //속도 개선이 필요하다
      //처리 속도 0.35 ~ 0.61ms

      //배열값이 1개인 경우는 바로 return
      if (array.length == 1) {
        return array[0];
      }
        
      //배열 내 가장 큰 값이 마지막 index 숫자!
		  Arrays.sort(array);
        
      //0도 새로운 배열에 넣으려면 길이에 1 더하기
		  int length = array[array.length-1] + 1;

      //새로운 배열 생성
		  int[] index = new int[length];
        
      //array[i] 값이 index의 인덱스 값이 됨
      //중복이 있는 경우 index[array[i]]의 값에 1을 더해서 최빈값 구하기
      for (int i=0; i<array.length; i++) {
        index[array[i]] += 1;
      }
        
      //mode == 최빈값
      //modeVal == 최빈값의 횟수
      int mode = 0;
      int modeVal = 0;

      for(int i=0; i<index.length; i++) {
        if(modeVal < index[i]) {
          mode = i;
          modeVal = index[i];
        }
      }

      //cnt == 중복값(modeVal) 검사
      int cnt = 0;
      for(int i=0; i<index.length; i++) {
        if(modeVal == index[i]) {
          cnt++;
        }
      }
      
      //중복값이 있다면 -1 return
      if(cnt>1) {
        return -1;
      } else {
        return mode;
      }
    }
}

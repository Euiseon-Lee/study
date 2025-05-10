import java.util.Arrays;
class Solution {
     /*
      문제 설명
        문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

      제한 사항
        str은 길이 1 이상인 문자열입니다.
     */
    
    public String solution(String s) {
      
      //처리속도 0.41ms ~ 0.70ms
      char[] trans = s.toCharArray();

      //Array.sort(); == A->Z->a->z 순으로 정렬
      Arrays.sort(trans);

      //역순 정렬방법 -> char[]에는 적합하지 않다고 나옴
      //Arrays.sort(trans, Collections.reverseOrder());

      StringBuffer str = new StringBuffer(String.valueOf(trans));
      String reverse = str.reverse().toString();

      return reverse;        
    }
}

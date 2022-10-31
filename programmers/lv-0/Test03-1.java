class Solution {
  /*
    문제 설명
      문자열 my_string이 매개변수로 주어집니다. 
      my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.

    제한사항
      1 ≤ my_string의 길이 ≤ 1,000
  */
    public String solution(String my_string) {
      
        // 비효율적인 코드 -> String에 배열 요소를 추가했기 때문
        // 처리속도 10.96 ~ 12.11ms
        char[] str = my_string.toCharArray();
        //StringBuffer sb = new StringBuffer();
        String sb ="";

        for (int i = str.length-1; i>=0; i--) {
            sb += str[i];
        }
        return sb;
    }
}

class Solution {
    /*
      문제 설명
        문자열 my_string과 정수 n이 매개변수로 주어질 때, 
        my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.

      제한사항
        2 ≤ my_string 길이 ≤ 5
        2 ≤ n ≤ 10
        "my_string"은 영어 대소문자로 이루어져 있습니다.
    */
    public String solution(String my_string, int n) {
      StringBuffer answer = new StringBuffer();

      for(int i=1; i<=my_string.length(); i++) {
        String part = my_string.substring(i-1, i);
        
        //Java11에 추가된 기능 -> String의 메소드
        answer.append(part.repeat(n));
      }
        return answer.toString();
    }
}

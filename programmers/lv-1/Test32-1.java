class Solution {
    /*
      문제
        자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 
        이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
      제한 사항
        n은 1 이상 100,000,000 이하인 자연수입니다.
    */
    public int solution(int num) {
      //처리 속도 0.16 ~ 0.26ms
      int answer = 0;
      String ternary = Integer.toString(num, 3);
      String[] parts = ternary.split("");
      for(int i=0; i<parts.length; i++) {
        int tmp = Integer.parseInt(parts[i]);
        answer += tmp*(Math.pow(3,i));
      }
        return answer;
    }
}

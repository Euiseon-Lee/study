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
      
        //처리속도 1.95ms ~ 3.83ms
        StringBuffer answer = new StringBuffer();
        char[] standard = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p',
            'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a',
            'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K',
            'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        int[] index = new int[s.length()];
        int k = 0;


        for(int i=0; i<s.length(); i++) {
          char compare = s.charAt(i);

          for(int j=0; j<standard.length; j++) {
            if (compare == standard[j]) {
              index[k] = j;
    //					System.out.println("index["+k+"] = "+index[k]);
              k++;
              break;
            }
          }
        }

        Arrays.parallelSort(index);

        for (int i = 0; i < s.length(); i++) {
          int num = index[i];
          answer.append(String.valueOf(standard[num]));
        }

            String finalS = answer.toString();
            return finalS;    
    }
}

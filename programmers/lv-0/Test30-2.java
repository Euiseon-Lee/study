class Solution {
    /*
      문제
        머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 
        조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다. 
        문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.

      제한 사항
        1 ≤ babbling의 길이 ≤ 100
        1 ≤ babbling[i]의 길이 ≤ 15
        babbling의 원소에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
        문자열은 알파벳 소문자로만 이루어져 있습니다.
    */
    public int solution(String[] babbling) {
        //처리 속도 0.11 ~ 0.75ms
        int answer = 0;

        for(int i =0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            if(babbling[i].trim().isEmpty()) {
                answer++;
            }
        }        
        return answer;
    }
}

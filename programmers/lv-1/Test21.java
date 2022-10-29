class Solution {
  /*
    문제 설명
      단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

    제한사항
      s는 길이가 1 이상, 100이하인 스트링입니다.
  */
    public String solution(String s) {
		int standard = s.length() / 2;
		//System.out.println(standard);


		if(s.length() % 2 == 1) {
			//return String.valueOf(s.charAt(standard));
            return (String) s.substring(standard, standard+1);
		} else {
            //String.subSequence(int beginIndex, int endIndex) -> endIndex는 미포함
            //String.substring(int beginIndex, int endIndex) -> endIndex는 미포함  
			//return (String) s.subSequence(standard-1, standard+1);
            return (String) s.substring(standard-1, standard+1);
		}
    }
}

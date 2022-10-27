class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
      /*
        문제 설명
          첫 번째 분수의 분자와 분모를 뜻하는 denum1, num1, 두 번째 분수의 분자와 분모를 뜻하는 denum2, num2가 매개변수로 주어집니다. 
          두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

        제한사항
          0 <denum1, num1, denum2, num2 < 1,000
      */
      
      int[] answer = new int[2];

      //분수1을 기약분수로 만들기
      int gcd1 = gcd (denum1, num1);
      denum1 = denum1/gcd1;
      num1 = num1/gcd1;

      //분수2를 기약분수로 만들기
      int gcd2 = gcd (denum2, num2);
      denum2 = denum2/gcd2;
      num2 = num2/gcd2;

      //분모의 최소공배수 구하기 -> 공통분모로 사용
      int lcm = lcm (num1, num2);

      //두 분수의 덧셈
      answer[1] = lcm;
      answer[0] = (denum1 * (lcm/num1)) + (denum2 * (lcm/num2));

      //분수가 기약분수인지를 확인하기 위한 절차
      int gcd = gcd (answer[0], answer[1]);

      //최소공배수가 있다면 == 기약분수가 아님
      if(gcd != 1) {
        answer[1] = answer[1]/gcd;
        answer[0] = answer[0]/gcd;
      } else {
        return answer;
      }

      return answer;



	}

	//유클리드 호제법 -> 최대공약수 추출
	//= 각 분수의 분자와 분모를 최대공약수로 나누어 기약분수로 만든다
	public static int gcd(int num1, int num2) {

		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		int tmp = a;
		int c = 0;

		while (b!=0) {
			c = a%b;
			a = b;
			b = c;
		}

		return a;

	}


	//최소공배수
	//= 분모들의 최소공배수를 구하는데 이용
	public static int lcm (int num1, int num2) {

		int lcm = num1 * num2 / gcd(num1, num2);

		return lcm;

	}

}

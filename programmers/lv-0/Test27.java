import java.util.ArrayList;
import java.util.List;
class Solution {
    /*
      문제 설명
        소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다. 
        분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다. 
        유한소수가 되기 위한 분수의 조건은 다음과 같습니다.

        기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
        두 정수 a와 b가 매개변수로 주어질 때, 
        a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.

      제한사항
        a, b는 정수
        0 < a ≤ 1,000
        0 < b ≤ 1,000
    */
    public int solution(int a, int b) {
        int common = gcd(a, b);
        b = b/common;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=b; i++) {
            if(b%i==0) {
            	arr.add(Integer.valueOf(i));
            }
        }
        
        ArrayList<Integer> check = new ArrayList<>();
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i)==1 || arr.get(i)%2==0 || arr.get(i)%5==0) {
                continue;
            } else {
                check.add(i);
            }
        }         
        
        if(check.isEmpty()) {
        	return 1;
        } else {
        	return 2;
        }
       
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
    
}

package zSelfstudy;

import java.lang.*;

public class Mogakko08 {
	public static void main (String[] args) {
		int a = 5;
		int b = 7;
		int c = 10;
		
		// 비교 연산자
		System.out.printf("%d > %d는 %b\n", a, b, a>b);
		System.out.printf("%d >= %d는 %b\n", a, b, a>=b);
		System.out.printf("%d < %d는 %b\n", a, b, a<b);
		System.out.printf("%d <= %d는 %b\n", a, b, a<=b);
		System.out.printf("%d == %d는 %b\n", a, b, a==b);
		System.out.printf("%d != %d는 %b\n", a, b, a!=b);
		
		// 논리 연산자
		System.out.printf("%d>%d && %d<%d는 %b\n", a,b,b,c, a>b && b<c);
		System.out.printf("%d>%d || %d<%d는 %b\n", a,b,b,c, a>b||b<c);
		System.out.printf("!(%d==%d)는 %b\n", a,b, !(a==b));
		System.out.printf("!(%d!=%d)는 %b\n", a,b, !(a!=b));		
		
		// 삼항 연산자
		int d = 10;
		int e = 30;
		
		System.out.println(d>e?"참입니다.":"거짓입니다.");
		System.out.println(d<e?"참입니다.":"거짓입니다.");
		
		
	}

}

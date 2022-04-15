package zSelfstudy;

import java.util.Scanner;

public class Mogakko07 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력하세요: ");
		int a = sc.nextInt();
		
		System.out.print("두 번째 숫자를 입력하세요: ");
		int b = sc.nextInt();
		
		System.out.println(" ");
		System.out.println("====사칙연산 출력하기====");
		
		System.out.printf("%d+%d=%d\n", a, b, a+b);
		System.out.printf("%d-%d=%d\n", a, b, a-b);
		System.out.printf("%d*%d=%d\n", a, b, a*b);
		System.out.printf("%d/%d=%d\n", a, b, a/b);
		System.out.printf("%d%%%d=%d\n", a, b, a%b);
	}

}

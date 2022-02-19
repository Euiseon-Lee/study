package java_selfstudy;

import java.util.Scanner;

public class Mogakko08_2 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//난이도 상
		// 숫자 2개를 띄어쓰기로 구분하여 입력
		// 두 숫자 중에 큰 숫자를 출력
		// 두 숫자가 같을 경우 숫자 대신 같음이라는 문장 출력
		
		
		System.out.print("숫자 2개를 입력하세요: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.print("둘 중에 큰 수는: ");
		System.out.println(a>b ? a : (a==b ? "같음" : b));
		
		sc.close();
		
	}

}

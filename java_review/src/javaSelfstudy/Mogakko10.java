package javaSelfstudy;

import java.util.Scanner;

public class Mogakko10 {
	public static void main (String[] args) {

		System.out.print("숫자를 입력하세요: ");
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		sc.close();
	
		int count = 0;
		
		for (int i = 0; i <= n; i += 1) {
			
			count += i;
		
		}
		
		System.out.println("1부터 "+n+"까지 합은 "+count+"입니다.");

	}
}

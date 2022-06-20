package zSelfstudy;

import java.util.Scanner;

public class Mogakko10_1 {
	public static void main (String[] args) {
		
		System.out.print("숫자를 입력하세요: ");
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		sc.close();
	
		int count = 0;
		int i = 0;
		
		while (i < n) {
			i++;
			count += i;
			
		}
		
		
		System.out.println("1부터 "+n+"까지 합은 "+count+"입니다.");

		}
		
	}


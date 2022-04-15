package roop;

import java.util.Scanner;

public class ReviewTest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//반복문 과제 Test10 소수 찾기 프로그램

		//소수는 나누어 떨어지지 않는 숫자를 말합니다.
		//사용자가 입력한 숫자가 소수인지 아닌지 판정해서 출력

		//ex : 5는 소수입니다
		//5 % 1 => 0
		//5 % 2 => 1
		//5 % 3 => 2
		//5 % 4 => 1
		//5 % 5 => 0
		
		//ex : 6은 소수가 아닙니다
		//6 % 1 => 0
		//6 % 2 => 0
		//6 % 3 => 0
		//6 % 4 => 2
		//6 % 5 => 1
		//6 % 6 => 0
		
		
		Scanner sc = new Scanner (System.in);
		System.out.print("판단할 숫자를 입력해주세요: ");

		int judge = sc.nextInt();
		sc.close();
		
		
		int count = 0;
		
		for (int i=judge; i>=1; i--) {

			if (judge % i == 0) {
				count ++;
			}
		}
		
		if (count == 2) {
			System.out.println(judge+"는 소수입니다.");
		}
		else {
			System.out.println(judge+"는 소수가 아닙니다.");

		}

		
	}

}

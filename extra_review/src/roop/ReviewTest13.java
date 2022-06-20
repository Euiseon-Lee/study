package roop;

import java.util.Scanner;

public class ReviewTest13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//반복문 과제 Test13
		//사용자에게 숫자를 10개 입력받아 입력받은 모든 숫자의 합계를 구하여 출력
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		for (int i=0; i<10; i++) {

			System.out.print("숫자 입력 :");
			int number = sc.nextInt();
			count += number;
		}
		

		System.out.print("총합은 "+count);
	}
	

}

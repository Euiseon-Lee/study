package roop;

import java.util.Scanner;

public class ReviewTest11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//반복문 과제 Test11
		//사용자가 입력한 숫자에 들어있는 7의 개수를 세어서 출력하는 프로그램을 구현

		//ex : 12347754 입력하면 2가 출력되어야 합니다
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요: ");
		int num = sc.nextInt();
		sc.close();
		int count = 0;
		
		for (int i=num; i>0; i /= 10)	{
			if(i%10 == 7) {
				count++;
			}
		}
		
		System.out.println("7의 개수는 "+count+"개 입니다.");
	}

}

package feb18;

import java.util.Random;
import java.util.Scanner;

public class Review_random03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//랜덤 과제 Test03
		//랜덤으로 구구단 중 하나를 사용자에게 문제로 출제하고 
		//정답을 입력받아 맞았는지 틀렸는지 판정하여 출력
		
		
		Random r = new Random();
		int a = r.nextInt(9)+2;
		int b = r.nextInt(9)+1;
				
		System.out.println(a+"X"+b+"= ??");
		System.out.println(" ");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정답을 입력하세요: ");
		int user = sc.nextInt();
		sc.close();
		
		boolean isCorrect = a*b == user;
		
		if (isCorrect) {
			System.out.println("정답!");		
		}
		else {
			System.out.println("땡!");
		}
	}

}

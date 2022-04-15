package roop;

import java.util.Random;

public class Review_random02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//랜덤 과제 Test02
		//주사위 두 개를 던져서 나온 값을 각각 화면에 출력하고 
		//만약에 주사위 두개가 같은 값이라면 "한번 더 던지세요" 출력

		Random r =new Random();
		int num1 = r.nextInt(6) + 1;
		int num2 = r.nextInt(6) + 1;
		
		if (num1 != num2) {
			System.out.println("첫번째 숫자는 "+num1+"이고 두번째 숫자는 "+num2+"입니다.");		
		}
		else {
			System.out.println("한번 더 던지세요");
		}

	}

}

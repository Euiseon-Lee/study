package roop;

import java.util.Random;

public class Review_random04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//랜덤 과제 Test04
		//주사위를 10번 던졌을 때 홀수와 짝수가 나온 횟수를 각각 카운트하여 출력
		
		int count1 = 0;
		int count2 = 0;
		
		Random r = new Random();
		
		for(int i=1; i<=10; i++) {
			int a = r.nextInt(6)+1;
			System.out.println("주사위: "+a);
			
			
			if (a%2==0) {
				count1++;
			}
			else {
				count2++;
		}	


		
		}
		System.out.println("홀수가 나온 횟수는 "+count1+"번이고");
		System.out.println("짝수가 나온 횟수는 "+count2+"번이다.");
		
	}

}

package feb18;

import java.util.Random;
import java.util.Scanner;

public class Review_random05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//랜덤 과제 Test05
		//구구단을 무작위로 사용자에게 10문제 출제하여 정답과 오답 개수를 카운트하여 출력

		//(추가) 맞춘 개수에 따라 다음과 같이 점수를 부여

		//1문제 맞추면 10점씩 획득
		//연속으로 맞추면 추가 점수 획득
		//정답 → 오답 → 정답 → 정답 → 정답 → 오답 → 정답 → 정답 → 오답 → 오답 인 경우
		//10점 → 0점 → 10점 → 20점 → 30점 → 0점 → 10점 → 20점 → 0점 → 0점
		//예시의 경우 총 점수는 100점입니다.
		
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int count = 0;

		
		for(int i=0; i<10; i++) {
			int a = r.nextInt(8)+2;
			int b = r.nextInt(9)+1;
			System.out.print(a+" X "+b+" = ");	
			
			int user = sc.nextInt();
			
			if(a*b == user) {
				count++;
			}
			

		}
		
		int score = count * 10;

		System.out.print("총 점수는 "+score+"입니다.");
	

		sc.close();
	}

}

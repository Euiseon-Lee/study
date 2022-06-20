package roop;

import java.util.Random;

public class Review_while03_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		
		int count = 0;

		while(true) {//무한반복
			int dice = r.nextInt(6) + 1;
			System.out.println("dice = " + dice);
			
			count++;

			if(dice == 5) {//5가 나왔으면
				break;//나가라! (if, try문을 제외한 가장 가까운 구문 탈출)
			}
		}

		System.out.println("count = " + count);

	}
}
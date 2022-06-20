package roop;

import java.util.Random;

public class Review_while03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while 반복 Test03
		//게임을 하다가 무인도에 갇혔습니다. 
		//탈출하려면 주사위 두 개를 던져서 5-5 또는 6-6이 나와야 합니다.

		//주사위를 몇 번 던져서 탈출할 수 있는지 시뮬레이션 후 출력하세요

		//추가문제
		//구구단을 랜덤으로 출제하여 푸는 문제를 구현하시고 
		//목숨을 3개만 부여해서 모두 사용하면 게임오버가 되도록 처리
		
		Random r = new Random();
		
		int count = 0;
		
		while (true) {
			int dice1 = r.nextInt(6)+1;
			int dice2 = r.nextInt(6)+1;
			
			count++;
			
			System.out.println("1번 주사위: "+dice1);
			System.out.println("2번 주사위: "+dice2);
			
			if((dice1 == 5 && dice2 == 5) || (dice1 == 6) && (dice2 == 6)) {
				break;
			}
		}

		
		System.out.println("총 횟수 = "+count+"번");

		
		
	}

}

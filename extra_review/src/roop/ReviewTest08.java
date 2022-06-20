package roop;

import java.util.Scanner;

public class ReviewTest08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//반복문 과제 Test08 타이머 만들기

		//사용자에게 분과 초를 입력받습니다. 
		//해당하는 시간만큼의 타이머 메시지를 출력하도록 구현

		//분 입력 : 3
		//초 입력 : 20

		//3분 20초 후 알람이 울립니다.
		//3분 19초 후 알람이 울립니다.
		//3분 18초 후 알람이 울립니다.
		//..
		//0분 2초 후 알람이 울립니다.
		//0분 1초 후 알람이 울립니다.
		//0분 0초 후 알람이 울립니다.
		//따르르르릉~
		
		Scanner sc = new Scanner (System.in);
		System.out.print("분을 입력하세요: ");
		int min = sc.nextInt();
		System.out.print("초를 입력하세요: ");
		int sec = sc.nextInt();
		sc.close();
		
		int changeSec = (min * 60) + sec;

		
		for (int i=changeSec; i>=0; i--) {
			if (i>0) {
				System.out.println(i/60+"분 "+i%60+"초 후 알람이 울립니다." );				
			}
			else if (i==0) {
				System.out.println("따르르르릉~~");
			}

		}
		
		
		
		
	}

}

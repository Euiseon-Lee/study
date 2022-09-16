package review;

import java.util.Scanner;

public class Practice03 {

	public static void main(String[] args) {

		/*
		어떤 날짜가 숫자 형태로 주어질 때, 이 숫자에서 연도를 추출해서 "윤년"인지 판정하여 출력

		예를 들면 다음과 같이 날짜가 주어집니다(연도4자리, 월2자리, 일2자리 합쳐서 8자리 숫자)
		int date = 20220214;

		윤년은 달력상의 1년과 실제 1년 사이의 차이를 메꾸기 위해 존재하는 해입니다. (달력상의 1년이 365이고, 실제 1년은 365.24...일입니다)

		윤년의 판정 기준은 다음과 같습니다.

		4의 배수인 경우 윤년입니다
		100의 배수면 윤년이 아닙니다
		400의 배수면 윤년입니다
		1번, 2번, 3번이 공통적으로 해당될 경우 높은 숫자의 조건이 우선입니다.
		 */

		System.out.println("------ 윤년 판정기 ------");

		Scanner sc = new Scanner(System.in);
		System.out.print("날짜를 8자리로 입력해주세요: ");
		int date = sc.nextInt();
		sc.close();

		int year = date / 10000;

		int standard1 = 4;
		int standard2 = 100;
		int standard3 = 400;

		boolean con1 = year % standard1 == 0;
		boolean con2 = year % standard2 != 0;
		boolean con3 = year % standard3 == 0;

		System.out.println("");
		System.out.println("----- 윤년 판정 결과 -----");

		if (con3 || (con2&&con1)) {
			System.out.println(year+"년은 윤년입니다");
		}
		else {
			System.out.println(year+"년은 윤년이 아닙니다");
		}

	}

}

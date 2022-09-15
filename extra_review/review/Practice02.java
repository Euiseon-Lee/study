package review;

import java.time.LocalTime;
import java.util.Scanner;

public class Practice02 {

	public static void main (String[] args) {

		int entryHour, entryMin, countTime, limitTime;
		int currentHour, currentMin, standardTime;
		int overTime;

		limitTime = 5 * 60;

		LocalTime now = LocalTime.now();
		currentHour = now.getHour();
		currentMin = now.getMinute();

		Scanner sc = new Scanner(System.in);
		System.out.print("최초 입실시간을 입력해주세요: ");
		String entry = sc.next();

		entryHour = Integer.parseInt(entry.substring(0,2));
		entryMin = Integer.parseInt(entry.substring(2,4));

		countTime = (entryHour * 60) + entryMin;
		standardTime = (currentHour * 60) + currentMin;


		System.out.println("최초 입실시간: "+entryHour+"시 "+entryMin+"분");
		System.out.println("현재 시간: "+currentHour+"시 "+currentMin+"분");


		if (standardTime - (countTime+limitTime) > 0) {

			overTime = standardTime - (countTime+limitTime);

			System.out.println("초과 이용시간: "+overTime+"분");
			System.out.println("이용시간이 5시간을 초과하여 추가요금이 부과됩니다.");
		}

		else {
			System.out.println("이용시간이 5시간을 초과하지 않아 추가요금이 없습니다.");
		}

	}

}

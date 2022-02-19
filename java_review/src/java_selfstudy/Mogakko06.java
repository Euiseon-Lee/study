package java_selfstudy;

import java.util.Scanner;

public class Mogakko06 {
	public static void main (String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("======자기소개 입력하기======");
		
		System.out.print("이름을 입력하세요: ");
		String name = sc.next();
		
		System.out.print("나이를 입력하세요: ");
		int age = sc.nextInt();
		
		System.out.print("키를 입력하세요: ");
		float height = sc.nextFloat();
		
		System.out.print("몸무게를 입력하세요: ");
		float weight = sc.nextFloat();
		
		System.out.print("혈액형을 입력하세요: ");
		String blood_type = sc.next();
		
		System.out.print("MBTI를 입력하세요: ");
		String mbti = sc.next();
		
		System.out.print("좌우명을 입력하세요: ");
		sc.nextLine();
		String sentence1 = sc.nextLine();
		
		
		
		System.out.println("======자기소개 입력하기======");
		System.out.println(" ");
		sc.nextLine();
		
		System.out.printf("제 이름은 %s입니다. 나이는 %d살이에요.\n"
				+ "키는 %fcm이구요. 몸무게는 %fkg입니다.\n"
				+ "혈액형은 %s형이구요. MBTI는 %s입니다.\n"
				+ "★★★ %s!!!! ★★★", name, age, height, weight, blood_type, mbti, sentence1);
		sc.close();
		
	}
}

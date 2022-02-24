package javaSelfstudy;

import java.util.Scanner;

public class Mogakko11 {
	public static void main (String[] args) {
		
		int[] num = new int[5];
		Scanner sc = new Scanner (System.in);
		System.out.print("숫자 5개를 띄어쓰기로 구분하여 입력하세요: ");
		for (int i = 0; i<5; i++) {
			num[i] = sc.nextInt();		
		}
		for (int g=4; g>-1; g--) {
			System.out.print(num[g]+" ");
		}
		sc.close();
		
	}

}

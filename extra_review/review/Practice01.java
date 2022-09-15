package review;

import java.util.Scanner;

public class Practice01 {
	public static void main (String[] args) {
		int oil = 1700;
		float discountCard = 0.85f;
		int price;

		Scanner sc = new Scanner(System.in);
		System.out.print("주입하실 휘발유 총량(l)을 입력하세요: ");
		int amount = sc.nextInt();

		if(amount > 50) {
			price = (int) ((oil * amount) * discountCard);
			System.out.println("휘발유 총량이 50l 초과이므로 할인이 적용됩니다.");
		} else {
			price = oil * amount;
		}

		System.out.println();
		System.out.println("휘발유 1리터당 가격은 "+oil+"원입니다.");
		System.out.println("주입한 휘발유 총량은 "+amount+"l입니다.");
		System.out.println("총 결제금액은 "+price+"원입니다.");



	}

}

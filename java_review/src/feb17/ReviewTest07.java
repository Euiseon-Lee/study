package feb17;

public class ReviewTest07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//반복문 과제 Test07 369 게임
		//369 게임은 3, 6, 9가 들어있는 숫자에 박수를 치는 게임입니다.
		//1부터 100까지 369게임을 하면 예상되는 결과를 화면에 출력하세요
		//= 1, 2, 짝, 4, 5, 짝, 7, 8, 짝, 10, 11, 12, 짝, ..., 27, 28, 짝, 짝, 짝, 짝, 짝짝, 짝, 짝, 짝짝, ...

		for(int i=1; i<=100; i++) {
			if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9 || i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
					System.out.print ("짝");
				}
				if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
					System.out.print ("짝");
				}
				System.out.println (" ");
			}
				else {
					System.out.println (i);
				}
				
			}
		}
	
	
	


}

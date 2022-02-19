package feb17;

public class ReviewTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//반복문 과제 Test06
		//화면에 1부터 100 사이의 5가 포함된 숫자를 출력 
		//= 5, 15, 25, 35, 45, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 65, 75, 85, 95
		
		for(int i=1; i<=100; i++) {
			if (i % 10 == 5 || i / 10 == 5) {
			System.out.println(i);
			}
		}
		
		
	}

}

package array;

public class Test07 {
	public static void main(String[] args) {
	
		//데이터 준비
		int[] score = new int[]{75, 92, 86, 65, 79, 95, 88, 86, 72, 77};
		
		
		//1. 전체 점수 출력
		System.out.print("전체 학생의 점수 출력: ");
		for(int i = 0; i<score.length; i++) {
			System.out.print(+score[i]+"점 ");
		}
		
		
		System.out.println("");
		System.out.println("");
		
		
		//2. 성적 우수자 인원수 출력 (90점 이상)
		int count = 0;
		for(int i = 0; i<score.length; i++) {
			
			if(score[i]>=90) {
				count++;
			}
		}
		System.out.println("성적 우수자는 총 "+count+"명 입니다");
		
		
		System.out.println("");
		
		
		//3.
		double total = 0;
		for(int i =0; i<score.length; i++) {
			total += (double)score[i];
		}
		double avg = total / score.length;
		System.out.println("전체 점수는 "+total+"점");
		System.out.println("전체 평균은 "+avg+"점");
		
		System.out.println("");
		
		

		//4. 85점인 학생이 추가될 경우 예상 순위
		int count1 = 0;
		for(int i =0; i<score.length; i++) {
			if(score[i]>85)	count1++;
		}
		int rank = 1 + count;
		System.out.println("85점인 학생이 추가될 경우 예상순위는 "+rank+"등 입니다");
				
	}
}

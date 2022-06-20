package oop;

public class Exam_oop2 {
//	우리반 학생 성적 정보
//	이름			과목		서술형점수	평가자체크리스트점수
//	피카츄	응용SW기초기술활용		50			60
//	라이츄	응용SW기초기술활용		40			80
//	파이리	프로그래밍언어활용		60			65
	
//	요구사항
//	시험점수는 0 이상 100 이하의 정수로만 설정이 가능하도록 구현
//	결과 출력 시 총점과 평균, 통과 여부를 확인할 수 있어야 함
//	과목별 40점 이상이고 평균 60점 이상이면 통과, 아니면 재평가
	
	String name, subj;
	int essayScore, checklistScore;
	
	void setName(String name) {
		this.name=name;
	}
	
	void setSubj(String subj) {
		this.subj=subj;
	}
	
	void setEssayScore(int essayScore) {
		if(essayScore>=0||essayScore<=100) return;
		this.essayScore=essayScore;
	}
	
	void setChecklistScore(int checklistScore) {
		if(checklistScore>=0||checklistScore<=100) return;
		this.checklistScore=checklistScore;
	}
	
	String getName() {
		return this.name;
	}
	
	String getSubj() {
		return this.subj;
	}
	
	int getEssayScore() {
		return this.essayScore;
	}
	
	int getChecklistScore()	{
		return this.checklistScore;
	}
	
	
	int getTotal() {
		return this.essayScore+this.checklistScore;
	}
	
	float getAverage() {
		return this.getTotal() / 2f;
	}
	
	boolean isPass() {
		if(this.essayScore>=40&&this.checklistScore>=40&&this.getTotal()>=60) {
			return true;
		}
		return false;
	}
	
	String getResult() {
		if(this.isPass()) return "통과";
		else return "재시험";
	}
	
	void setting(String name, String subj, int essayScore, int checklistScore) {
		this.setName(name);
		this.setSubj(subj);
		this.setEssayScore(essayScore);
		this.setChecklistScore(checklistScore);
	}

	void print() {
		System.out.println("<학생별 시험 성적>");
		System.out.println("학생 이름: "+getName());
		System.out.println("과목명: "+getSubj());
		System.out.println("서술형 점수: "+getEssayScore());
		System.out.println("평가자 체크리스트 점수: "+getChecklistScore());
		System.out.println("총 점수: "+getTotal());
		System.out.println("평균 점수: "+getAverage());
		System.out.println("평과 결과: "+getResult());
	}
	
}

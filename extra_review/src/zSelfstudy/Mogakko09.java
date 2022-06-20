package zSelfstudy;

import java.util.Scanner;

public class Mogakko09 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== 개발자 MBTI 결과 보기 ====");
		System.out.print("당신의 MBTI를 입력하세요: ");
		String a = sc.nextLine();
		
		if (a.equals ("intp") || a.equals ("INTP")) {
			System.out.println("당신은 백엔드형입니다!");
		} else if(a.equals ("enfj") || a.equals ("ENFJ")) {
			System.out.println("당신은 프론트엔드형입니다!");
		} else if(a.equals ("infj") || a.equals ("INFJ")) {
			System.out.println("당신은 풀스택형입니다!");
		} else if(a.equals ("istj") || a.equals ("ISTJ")) {
			System.out.println("당신은 퍼블리셔형입니다!");
		} else if(a.equals ("entj") || a.equals ("ENTJ")) {
			System.out.println("당신은 아키텍쳐형입니다!");
		} else if(a.equals ("isfj") || a.equals ("ISFJ")) {
			System.out.println("당신은 보안전문가형입니다!");
		} else if(a.equals ("intj") || a.equals ("INTJ")) {
			System.out.println("당신은 데이터분석가형입니다!");
		} else if(a.equals ("enfp") || a.equals ("ENFP")) {
			System.out.println("당신은 AI형입니다!");
		} else if(a.equals ("entp") || a.equals ("ENTP")) {
			System.out.println("당신은 iOS형입니다!");
		} else if(a.equals ("esfj") || a.equals ("ESFJ")) {
			System.out.println("당신은 안드로이드형입니다!");
		} else if(a.equals ("esfp") || a.equals ("ESFP")) {
			System.out.println("당신은 게임개발자형입니다!");
		} else if(a.equals ("estp") || a.equals ("ESTP")) {
			System.out.println("당신은 IoT개발형입니다!");
		} else if(a.equals ("estj") || a.equals ("ESTJ")) {
			System.out.println("당신은 QA형입니다!");
		} else if(a.equals ("infp") || a.equals ("INFP")) {
			System.out.println("당신은 블록체인형입니다!");
		} else if(a.equals ("istp") || a.equals ("ISTP")) {
			System.out.println("당신은 임베디드 개발자형입니다!");
		} else if (a.equals ("isfp") || a.equals ("ISFP")) {
			System.out.println("당신은 네트워크 개발자형입니다!");
		} else {
			System.out.println("정확한 MBTI 유형이 아니네요ㅠㅠ");
		} 
		
		
		
		sc.close();
	}


}

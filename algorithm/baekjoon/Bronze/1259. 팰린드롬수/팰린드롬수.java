import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 🔁 BOJ 1259 - 팰린드롬수
		 *
		 * 📌 문제 규칙
		 * - 입력된 수가 팰린드롬(좌우 대칭)이면 "yes", 아니면 "no"
		 * - 입력 "0"이 오면 종료
		 * - 조건: 두 자릿수 이상의 수는 선행 0이 없음  → 정수 연산으로 처리해도 안전
		 *
		 * 🧭 두 가지 접근 비교
		 * 1) 문자열 접근(String) 〔현재 풀이〕
		 *    - i ↔ len-1-i 문자 비교로 판정
		 *    - 장점: 코드가 가장 단순, 실수 여지 적음, 성능 차이 무시 가능
		 * 2) 정수 접근(int/long)
		 *    - n을 뒤집은 수 rev를 만들어 original == rev 판정
		 *    - 이 문제는 선행 0이 없으므로 정수 변환/비교가 안전
		 *
		 * 🧱 로직(문자열 버전)
		 * - n 읽기 → "0"이면 종료
		 * - 앞/뒤 포인터로 대칭 비교 → yes/no
		 *
		 * 🧮 로직(정수 버전) 의사코드
		 * - while(true):
		 *     read n; if (n == 0) break;
		 *     original = n; rev = 0;
		 *     while (n > 0) { rev = rev*10 + n%10; n/=10; }
		 *     print original == rev ? "yes" : "no"
		 *
		 * ⏱️ 복잡도
		 * - 두 방식 모두 O(L) (L=자릿수, 최대 5)
		 * - 공간 O(1)
		 *
		 * ✅ 결론
		 * - 본 문제에선 두 방식 모두 정답·안전
		 * - 팀/개인 선호에 따라 가독성(문자열) vs 산술 감각(정수) 중 선택
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (!n.equals("0")) {
		    int len = n.length();
            int mid = len % 2 == 0 ? len / 2 : (len / 2) + 1;
            boolean isPalindrome = true;
            for (int i = 0; i < mid; i++) {
                if (n.charAt(i) != n.charAt(len - i - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            sb.append((isPalindrome) ? "yes" : "no").append('\n');
            n = br.readLine();
        }
        System.out.print(sb);
    }

}


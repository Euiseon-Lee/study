import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 🔁 BOJ 1259 - 팰린드롬수
		 *
		 * 📌 문제 요약
		 * - 입력받은 수(문자열 형태)가 좌우 대칭인지 판정
		 * - 입력이 "0"이면 종료
		 *
		 * 🧠 핵심 아이디어
		 * - 숫자이지만 문자열 비교가 더 정확하고 단순
		 * - int/long 변환 시 선행 0 손실, 범위 초과 위험 있음
		 *
		 * 🧱 로직 구조
		 * 1) 입력받은 문자열 n에 대해
		 * 2) 앞뒤 문자 대칭 비교 (i ↔ len-1-i)
		 * 3) 대칭이면 "yes", 아니면 "no"
		 * 4) "0" 입력 시 종료
		 *
		 * ⏱️ 복잡도
		 * - 시간: O(L) (L = 자릿수, 최대 5)
		 * - 공간: O(1)
		 *
		 * ✅ 장점
		 * - 문자열 비교로 단순하고 안전
		 * - 앞자리 0 보존 가능
		 * - BufferedReader + StringBuilder 로 I/O 효율적
		 *
		 * ⚠️ 주의
		 * - int/long 변환 시 0 손실 및 범위 초과 가능 → 문자열 유지가 정답
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

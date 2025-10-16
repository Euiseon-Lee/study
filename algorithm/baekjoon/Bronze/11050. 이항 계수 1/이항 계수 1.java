import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 🧮 BOJ 11050 - 이항 계수 1
		 *
		 * 📌 문제 요약
		 * - 주어진 n, k에 대해 조합 nCk = n! / (k!(n-k)!) 계산
		 * - 입력 범위: 1 ≤ n ≤ 10 → int로 충분
		 *
		 * 🧱 로직 구조
		 * 1) makeFactorial() 재귀 호출로 n!, k!, (n-k)! 계산
		 * 2) 결과를 수식 n! / (k! * (n-k)!)로 출력
		 *
		 * ⏱️ 복잡도
		 * - 시간: O(n) (팩토리얼 계산)
		 * - 공간: O(n) (재귀 스택)
		 *
		 * ✅ 장점
		 * - 수학적 직관과 동일한 형태로 구현
		 * - n ≤ 10이므로 overflow 위험 없음
		 *
		 * ⚠️ 보완 포인트
		 * - n이 커질 경우 int overflow 발생 → long/BigInteger 사용 필요
		 * - 반복문으로 변경 시 스택 사용량 감소 및 성능 개선
		 * - factorial(n) 중복 호출 제거로 연산량 3배 축소 가능
		 *
		 * 💡 개선 예시
		 *  long factorial(int n) {
		 *      long result = 1;
		 *      for (int i = 2; i <= n; i++) result *= i;
		 *      return result;
		 *  }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(makeFactorial(n) / (makeFactorial(k) * makeFactorial(n - k)));
    }
    public static int makeFactorial(int n){
        if (n == 0 || n == 1) return 1;
        return n * makeFactorial(n - 1);
    }

}

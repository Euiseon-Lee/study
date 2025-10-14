import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 🔍 BOJ 1920 - 수 찾기
		 *
		 * 📌 문제 요약
		 * - 집합 A의 원소 N개, 탐색할 원소 M개가 주어짐.
		 * - 각 탐색 대상이 A에 존재하면 1, 아니면 0 출력.
		 *
		 * 🧱 로직 구조
		 * 1) N개의 정수를 HashSet에 저장 (중복 제거 자동)
		 * 2) M개의 정수를 순회하며 set.contains()로 존재 여부 검사
		 * 3) 결과를 StringBuilder에 누적 후 출력
		 *
		 * ⏱️ 복잡도
		 * - 시간: O(N + M) (HashSet 삽입 + 탐색 평균 O(1))
		 * - 공간: O(N)
		 *
		 * ✅ 장점
		 * - HashSet 사용으로 빠른 탐색
		 * - BufferedReader + StringBuilder로 I/O 효율 높음
		 * - Long 사용으로 오버플로우 방지
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<Long> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
		    set.add(Long.parseLong(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
            sb.append(set.contains(Long.parseLong(st.nextToken())) ? 1 : 0).append('\n');
		}
		System.out.print(sb);
	}

}

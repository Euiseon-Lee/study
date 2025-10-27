import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		/**
		 * 🧮 BOJ 11723 집합 – HashSet 기반 집합 연산 시뮬레이션
		 *
		 * 🧩 문제 개요
		 * - 정수 1~20으로 구성된 집합 S에 대해 6가지 연산을 처리:
		 *   1️⃣ add x     → x를 S에 추가
		 *   2️⃣ remove x  → x를 S에서 제거
		 *   3️⃣ check x   → x가 S에 있으면 1, 없으면 0 출력
		 *   4️⃣ toggle x  → 있으면 제거, 없으면 추가
		 *   5️⃣ all       → 1~20까지 모두 추가
		 *   6️⃣ empty     → 집합 비우기
		 *
		 * ⚙️ 알고리즘 구조
		 * - HashSet<Integer>를 생성하여 각 연산을 처리
		 * - 'check' 결과는 StringBuilder에 누적 후 최종 일괄 출력
		 * - 'all' 명령은 1~20 반복 삽입, 'empty'는 clear()
		 *
		 * ⏱️ 복잡도
		 * - 평균: O(N)
		 *   • HashSet: add/remove/check/toggle → O(1) 평균
		 *   • all: O(20) = 상수
		 * - 공간: O(20) = 상수 수준
		 *
		 * 💡 핵심 아이디어
		 * - 1~20의 유한 범위이므로 동적 자료구조(HashSet)로도 충분히 가능하지만,
		 *   더 빠르게 하려면 20비트 정수(비트마스크)로 상태를 표현할 수 있다.
		 *   예: 
		 *     add x    → bit |= (1 << x)
		 *     remove x → bit &= ~(1 << x)
		 *     toggle x → bit ^= (1 << x)
		 *     check x  → (bit & (1 << x)) != 0
		 *     all      → bit = (1 << 21) - 2
		 *     empty    → bit = 0
		 *
		 * 🧠 실무적 의미
		 * - 유한한 정수 범위에서의 집합 연산은 비트마스크가 HashSet보다 훨씬 효율적.
		 * - HashSet은 이해/가독성이 높고 범용성 있음 (범위가 클 때 유리).
		 * - 반면, 비트마스크는 상수 범위 최적화에 탁월.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                for (int j = 1; j < 21; j++) {
					set.add(j);
				}
                continue;
            } else if (command.equals("empty")) {
                set.clear();
                continue;
            }
            int target = Integer.parseInt(st.nextToken());
            switch (command) {
                case "add":
                    set.add(target);
                    break;
                case "remove":
                    set.remove(target);
                    break;
                case "check":
                    sb.append(set.contains(target) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    if (set.contains(target)) {
                        set.remove(target);
                    } else {
                        set.add(target);
                    }
                    break;
            }
        }
        System.out.print(sb);
    }

}

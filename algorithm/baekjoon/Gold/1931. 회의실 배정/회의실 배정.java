import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		/**
		 * 📅 BOJ 1931 회의실 배정 – Greedy 정렬 기반 최대 비중첩 구간 선택
		 *
		 * 🧩 문제 개요
		 * - N개의 회의(start, end)가 주어짐.
		 * - 회의가 서로 겹치지 않게 하면서 가장 많은 회의를 배정해야 함.
		 * - 단, 한 회의가 끝나는 시각에 다른 회의가 시작되는 것은 가능.
		 *
		 * 💡 핵심 아이디어: "가장 빨리 끝나는 회의부터 선택"
		 * - 현재 회의가 끝난 이후의 시간 구간이 가장 길게 남도록 선택하면, 이후 회의를 배치할 “여유(자유도)”가 최대화됨.
		 * - 즉, 종료시간이 가장 빠른 회의를 선택하면 남은 일정에서 다른 회의들을 더 많이 넣을 수 있는 가능성이 늘어난다.
		 *
		 * 🧠 왜 ‘끝나는 시간 기준 정렬’이 최적인가?
		 * 1️⃣ 지금 시점에서 가장 빨리 끝나는 회의를 선택한다고 가정.
		 * 2️⃣ 이후 가능한 회의 집합은 “현재 회의가 끝난 이후”로 제한됨.
		 * 3️⃣ 만약 더 늦게 끝나는 회의를 먼저 선택하면, 이후 가능한 회의 수가 줄어들거나 없어짐.
		 * 4️⃣ 따라서, “빨리 끝나는 회의부터 선택하는 전략”이 항상 전체 최적해의 일부가 된다. (그리디 선택 속성 만족)
		 *
		 * ⚠️ 시작 시간 기준 정렬이 실패하는 이유
		 * 예시)
		 * ┌───────────────┬───────────┬───────────┐
		 * │ 회의 번호      │ 시작 ~ 끝 │ 설명       │
		 * ├───────────────┼───────────┼───────────┤
		 * │ A              │ 1 ~ 10    │ 긴 회의     │
		 * │ B              │ 1 ~ 4     │ 짧은 회의   │
		 * │ C              │ 5 ~ 7     │ 짧은 회의   │
		 * └───────────────┴───────────┴───────────┘
		 * 
		 * - 시작 시간 기준 정렬 시: A(1~10) → B(1~4) → C(5~7)
		 * - A를 먼저 선택하면 나머지 회의는 전부 겹쳐서 불가능.
		 * - 하지만 종료 시간 기준으로 정렬하면:
		 *     B(1~4) → C(5~7) 선택 가능 → 총 2개 회의 배정 ✅
		 * → 시작시간 기준은 "처음 일찍 시작하는 회의"를 과하게 선택해 이후 가능성을 닫아버리는 잘못된 전략이 됨.
		 *
		 * ⚙️ 알고리즘 절차
		 * 1️⃣ (start, end) 쌍 입력
		 * 2️⃣ 종료시간 기준 오름차순 정렬 (같으면 시작시간 오름차순)
		 * 3️⃣ 현재 회의의 시작시간이 이전 회의의 종료시간 이상이면 선택
		 * 4️⃣ 선택 시 count++ 및 prev_end 갱신
		 *
		 * ⏱️ 복잡도
		 * - 정렬: O(N log N)
		 * - 선택 루프: O(N)
		 * - 총합: O(N log N)
		 * - 메모리: O(N)
		 *
		 * ✅ 구현 포인트
		 * - Comparator: end → start 순
		 * - endTime 갱신 조건: if (start >= endTime)
		 * - 입력 10만 단위에서도 충분히 빠름
		 *
		 * 🧮 수학적 정당성 (Greedy Choice Property)
		 * - 지금의 최적 선택(가장 빨리 끝나는 회의)이 전체 최적해의 일부가 됨을 귀납적으로 증명 가능.
		 * - 즉, 첫 선택을 더 빨리 끝나는 회의로 바꿔도 전체 해의 크기가 줄어들지 않는다.
		 *
		 * 🛠️ 보완 포인트
		 * 1️⃣ Comparator 람다식으로 단축 가능:
		 *     Arrays.sort(arr, (a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
		 * 2️⃣ 안전한 비교: Integer.compare(a[1], b[1])
		 * 3️⃣ 변수명 개선: prev_end_schedule → endTime
		 *
		 * 🧩 실무적 응용
		 * - 스케줄링, 자원 할당, 예약 시스템, 타임라인 병합 등
		 *   “비중첩 구간 최대 선택” 패턴에 동일하게 적용됨.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // start
            meetings[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        // 종료시간 → 시작시간 순으로 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (endTime <= meetings[i][0]) { // 이전 회의와 겹치지 않으면
                endTime = meetings[i][1];
                count++;
            }
        }
        System.out.print(count);
    }
}

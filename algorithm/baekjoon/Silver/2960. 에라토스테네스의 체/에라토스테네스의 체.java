import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔢 BOJ 2960 — K번째로 지워지는 수 찾기 (에라토스테네스 변형)
         *
         * 🧩 문제 요약
         * - 2..N 범위에서 에라토스테네스 체를 진행하며, 어떤 수 j가 "처음으로 지워질 때"마다 k를 1 감소시킨다.
         * - k가 0이 되는 순간의 j가 정답이며, 즉시 출력하고 프로그램을 종료한다.
         *
         * 🧱 로직/자료구조
         * - boolean[] removed: 인덱스 = 수 자체. removed[j]가 true면 이미 제거됨.
         * - 바깥 루프 i = 2..N:
         *   • i가 이미 제거되었다면 continue (합성수의 배수 순회 방지)
         *   • 안쪽 루프 j = i; j <= N; j += i:
         *     - 아직 제거되지 않은 j만 제거(removed[j] = true)하고 if (--k == 0) 즉시 출력·종료
         *
         * ⏱ 성능
         * - 시간: O(N log log N) 수준(체의 일반적 복잡도) + K 도달 시 조기 종료로 실측 시간 단축
         * - 공간: O(N) (boolean 배열)
         *
         * 🛡️ 주의/함정
         * - 반드시 "처음 제거되는 시점"에만 카운트해야 하므로 removed[j] 체크가 필수
         * - K번째 달성 시 내부 루프만 break하면 바깥 루프가 계속 돈다 → return으로 즉시 종료
         * - i*i부터 시작하는 최적화는 "제거 순서"를 바꾸므로 이 문제에서는 사용 금지
         *
         * 🏭 실무 시사점
         * - 상태 플래그로 "한 번만 처리"를 보장(idempotent)하고, 조건 달성 시 조기 종료(Early Return)하는 패턴은
         *   대규모 스캔/배치/검사 로직에서 성능·안정성을 동시에 확보하는 기본기다.
         * - 외부/내부 루프의 탈출 조건을 한 곳에 밀착시키면 버그(중복 처리, 과도 반복)를 크게 줄일 수 있다.
         *
         * 🧪 테스트 가이드
         * - N=10, K=1 → 2
         * - N=10, K=3 → 6  (제거 순서: 2,4,6,…)
         * - N=15, K=7 → 14 (2,4,6,8,10,12,14)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isRemoved = new boolean[n + 1];
        isRemoved[0] = true;
        isRemoved[1] = true;

        for (int i = 2; i <= n; i++) {
            if (isRemoved[i]) continue;

            for (int j = i; j <= n; j += i) {
                if (!isRemoved[j]) {
                    isRemoved[j] = true;       // 처음 제거 시점
                    if (--k == 0) {          // K번째 제거
                        System.out.println(j);
                        return;              // 즉시 종료(이중 루프 탈출)
                    }
                }
            }
        }
    }
}

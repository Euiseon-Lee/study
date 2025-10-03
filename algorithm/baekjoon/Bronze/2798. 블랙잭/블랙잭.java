import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * ♠️ BOJ 2798 - 블랙잭 (정렬 + 투 포인터로 O(N^2))
         *
         * 📌 핵심 아이디어
         * - 카드 배열을 오름차순 정렬
         * - i를 하나 고정한 뒤, 남은 구간 [i+1..n-1]에서 두 포인터 j,k로
         *   cards[i] + cards[j] + cards[k] <= M 인 최대 합을 탐색
         *
         * 🧱 로직 흐름
         * 1) 정렬
         * 2) for i=0..n-3:
         *    - j=i+1, k=n-1
         *    - while (j < k):
         *        sum = a[i]+a[j]+a[k]
         *        - sum > M  → k--  (합을 줄여야 함)
         *        - sum <= M → answer = max(answer, sum); j++  (합을 키워서 M에 더 근접 시도)
         *        - answer == M이면 최적값이므로 전체 조기 종료 가능
         *
         * ⏱️ 복잡도
         * - 정렬 O(N log N) + 바깥 i 루프 N × 안쪽 투포인터 O(N) = 총 O(N^2)
         * - 기존 3중 루프 O(N^3) 대비 명확한 개선
         *
         * ✅ 장점
         * - 상수항도 작고 구현 간결, 조기 종료 가능 (answer == M)
         * - 불필요한 모든 3조합 탐색을 피하고 "정렬된 구조"를 이용해 탐색 공간을 축소
         *
         * ⚠️ 주의
         * - 합이 int 범위를 넘지 않지만(문제 조건상 M ≤ 300,000), 관성적으로 long을 쓰는 경우 형 일치에 주의
         * - 정렬 이후 인덱스 관계(i < j < k) 유지 필수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int answer = 0;
        outer:
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum > m) {
                    k--;               // 합이 크다 → 큰 쪽을 줄임
                } else {
                    if (sum > answer) answer = sum; // 유효합 갱신
                    if (answer == m) break outer;   // 최적값 → 조기 종료
                    j++;               // 합이 작다 → 작은 쪽을 키움
                }
            }
        }
        System.out.println(answer);
    }
}

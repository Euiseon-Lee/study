import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 10811 – 바구니 뒤집기 (Two Pointers 버전)
         *
         * 🧠 아이디어
         * - [start, end] 구간을 "양끝에서 안으로" 좁혀오며 쌍으로 swap → 제자리 뒤집기(in-place reverse)
         * - Two Pointers:
         *   L = start, R = end
         *   while (L < R) { swap(baskets[L], baskets[R]); L++; R--; }
         *
         * ✅ 왜 Two Pointers인가?
         * - "구간 뒤집기"의 본질을 가장 직관적으로 표현: 양끝을 맞바꾸며 중앙으로 수렴
         * - 불필요한 산술(반복마다 (end-start)/2 계산 등) 없이 비교·증감만 수행 → 명확하고 안전
         *
         * 🔍 정확성(불변식)
         * - 루프 시작 시점마다 [start, L-1]과 [R+1, end]는 이미 서로 뒤집힌 상태로 맞교환 완료
         * - L과 R이 교차하면([L >= R]) 구간 전체가 역순이 됨 → 종료
         *
         * 🚀 복잡도
         * - 연산 1회당 O(len) (len = end-start+1), 전체 O(Σ len)  (문제 제한에서 충분)
         * - 메모리 O(1) (제자리 스왑)
         *
         * 🆚 기존 for-분할 방식과의 차이(성능·가독성)
         * - 기존: for (j=0; j <= (end-start)/2; j++) { swap(start+j, end-j); }
         *   * 시간 복잡도는 **동일**(O(len)) — 둘 다 스왑 횟수는 ⌊len/2⌋번
         *   * 차이점은 **상수 항**:
         *     - for조건에 (end-start)/2 연산이 반복 평가될 수 있음(JIT가 최적화하는 경우도 있지만 코드 레벨로는 비용 요소)
         *     - Two Pointers는 단순 비교(L<R) + 증감 → 분기·산술이 최소화
         * - 가독성:
         *   * Two Pointers는 "양끝을 좁혀오는" 문제의 의도를 직접 드러내어 유지보수/확장(예: 조건 추가)에 유리
         *
         * 🧪 예시 (start=2, end=5, [1 2 3 4 5])
         * - L=2,R=5 → swap(2,5): [1 5 3 4 2]
         * - L=3,R=4 → swap(3,4): [1 5 4 3 2]
         * - L=4,R=3 종료 → [2..5] 구간 역순 완료
         */
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] baskets = new int[n + 1];
        for (int i = 1; i <= n; i++) baskets[i] = i;

        for (int op = 0; op < m; op++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            reverseRange(baskets, start, end);  // ← Two Pointers로 뒤집기
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(baskets[i]);
            if (i < n) sb.append(' ');
        }
        System.out.print(sb);
    }

    /** Two Pointers로 [l, r] 구간을 제자리 뒤집기 */
    private static void reverseRange(int[] a, int l, int r) {
        while (l < r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++; r--;
        }
    }

        /* 기존 for-분할 방식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] baskets = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            baskets[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= (end - start) / 2; j++) {
                int temp = baskets[start + j];
                baskets[start + j] = baskets[end - j];
                baskets[end - j] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(baskets[i] + " ");
        }
        System.out.println(sb);
    }
        */
}

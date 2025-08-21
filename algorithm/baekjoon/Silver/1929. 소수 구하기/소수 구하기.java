import java.io.*;
import java.util.*;

public class Main {
        /**
         * 🔢 BOJ 1929 - 소수 구하기 (에라토스테네스의 체, Sieve of Eratosthenes)
         *
         * ✅ 알고리즘 개요
         * - 1..N 범위를 boolean 테이블로 유지하고, 소수 p의 배수를 한 번에 제거하여 합성수를 걸러낸다.
         * - 전처리: 2..⌊√N⌋ 구간에서 isPrime[p]==true인 p를 만나면, j=p*p, p*p+p, ... ≤ N을 false로 마킹.
         * - 출력: [M..N] 범위에서 isPrime[i]==true인 i만 출력.
         *
         * 🧠 왜 효율적인가? (O(N log log N))
         * - 배수 제거 총비용은 대략 N/2 + N/3 + N/5 + ... (소수에 대한 조화급수)로 수렴하며, 이는 Θ(N log log N).
         * - 각 합성수는 자신의 최소 소수 약수(minimum prime divisor)에 의해 최초로 제거되므로, 불필요한 중복 연산이 거의 없다.
         * - 배수 마킹을 j=p*p부터 시작하면, p*(p-1), p*(p-2) 등은 더 작은 소수에서 이미 제거되어 “중복 제거”를 근본적으로 차단한다.
         * - 루프 상한을 i*i ≤ N으로 두면 매 반복마다 sqrt 재계산을 피하고(상수항↓), 분기 예측도 유리하다.
         *
         * 📈 복잡도
         * - 시간: O(N log log N) 전처리 + O(N-M+1) 출력
         * - 공간: O(N)  // boolean[n+1]
         *
         * ⚙️ 구현 포인트
         * - isPrime[0]=isPrime[1]=false로 초기화 (정의상 소수 아님)
         * - i*i부터 배수 제거 (이전 소수에서 이미 제거된 구간은 건너뜀)
         * - 출력은 StringBuilder로 모아서 한 번에 flush (I/O 병목 완화)
         *
         * 🧩 실무 적용
         * - “범위 내 모든 소수” 또는 “다중 질의”에 최적. 전처리 테이블을 재사용하면 질의 응답은 O(1).
         * - 범위가 매우 크고 메모리가 아쉬우면 세그먼티드 체(Segmented Sieve)로 확장.
         */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isPrime = sieve(n);                         // 1..n 소수 여부 전처리

        StringBuilder out = new StringBuilder();
        for (int i = Math.max(m, 2); i <= n; i++) {           // 1은 소수가 아니므로 2부터
            if (isPrime[i]) out.append(i).append('\n');
        }
        System.out.print(out.toString());
    }

    // 에라토스테네스의 체: [0..n] 구간의 소수 여부를 마킹
    private static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        // i*i <= n: sqrt 재계산 방지 + 상수항 절감
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) continue;                     // 이미 합성수면 skip
            // 배수 제거는 i*i부터 시작 (i보다 작은 배수들은 더 작은 소수에서 이미 제거됨)
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}

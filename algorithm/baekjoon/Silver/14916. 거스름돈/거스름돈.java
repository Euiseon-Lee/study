import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 14916 – 거스름돈 (동전: 2, 5) 최소 개수
         *
         * 🧠 아이디어
         * - 5원을 최대한 사용하면서 남은 금액이 2로 나누어떨어지는 지점을 찾으면 그게 최소 동전 수.
         *   이유: 5원이 2원보다 가치가 크므로(5>2), 동전 개수(=a+b)를 최소화하려면 가능한 한 큰 단위(5원)를 우선 사용.
         *   단, 남은 금액의 '짝수성'이 맞아야 하므로 5원 개수를 하나씩 줄여가며 검사.
         *
         * ⚠️ 주의
         * - 1, 3원처럼 만들 수 없는 금액은 -1을 출력해야 함.
         * - 따라서 해를 못 찾았을 때를 구분하기 위해 초기값을 -1로 두는 것이 안전.
         *
         * 🚀 복잡도
         * - O(n/5) ≈ O(n), n ≤ 100000 같은 범위에서도 충분.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int coin = -1;
        for (int i = n / 5; i >= 0; i--) {
            if ((n - (5 * i)) % 2 == 0) {
               coin = i + ((n - (5 * i)) / 2);
               break;
            }
        }
        System.out.println(coin);
    }

}

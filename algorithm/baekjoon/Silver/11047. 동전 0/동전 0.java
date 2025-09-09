import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 11047 - 동전 0
         *
         * 🧠 사용한 알고리즘: Greedy (탐욕법)
         * - 조건: 동전 단위가 배수 관계 → 큰 단위부터 최대한 사용하면 항상 최적해
         *
         * 🔁 로직
         * 1) N, K 입력 (동전 종류 수, 목표 금액)
         * 2) 동전 단위 배열을 입력받음 (작은 단위 → 큰 단위 순)
         * 3) 큰 동전부터 순회하며:
         *    - 목표 금액 >= 동전 → (목표 금액 / 동전) 만큼 사용
         *    - 목표 금액 %= 동전
         * 4) 사용한 동전 개수 합 출력
         *
         * ⏱️ 성능
         * - 시간: O(N)
         * - 공간: O(N)
         *
         * ✅ 평가
         * - 국소적으로 최선(큰 단위 최대 사용)을 선택 → 전체 최적해 보장
         * - 전형적인 Greedy 패턴 (Level 3)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int targetPrice = Integer.parseInt(st.nextToken());
        int[] coins = new int[coinCount];
        for (int i = coinCount - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int neededCoinCount = 0;
        for (int i = 0; i < coinCount; i++) {
            if (coins[i] <= targetPrice) {
                neededCoinCount += (targetPrice / coins[i]);
                targetPrice %= coins[i];
            }
        }
        System.out.println(neededCoinCount);
    }
}


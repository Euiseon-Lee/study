import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔢 BOJ 2501 - 약수 구하기
         *
         * 📌 문제 요약
         * - N의 약수를 오름차순으로 나열했을 때,
         *   K번째 약수를 출력 (없으면 0)
         *
         * 🧱 로직 구조
         * 1) 1부터 N까지 순회하며 약수(i)인지 검사 (N % i == 0)
         * 2) 약수를 발견할 때마다 order(K) 감소
         * 3) order == 0 이 되는 순간의 i가 K번째 약수
         * 4) 루프 종료 후 answer 출력 (없으면 0)
         *
         * ⏱️ 복잡도
         * - 시간: O(N)
         * - 공간: O(1)
         *
         * ✅ 장점
         * - 로직이 문제 설명과 1:1 매칭되어 직관적
         * - 조기 종료로 불필요한 반복 없음
         * - K번째 약수가 존재하지 않을 경우도 안전하게 0 출력
         *
         * ⚙️ 예시
         *  입력: 6 3 → 출력: 3
         *  입력: 6 5 → 출력: 0
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 1; i <= target; i++) {
            if (target % i == 0) order--;
            if (order == 0) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 2839 설탕 배달 – 5kg/3kg 최소 봉지 개수 계산 (O(1) 수학적 규칙)
         *
         * 💡 핵심 로직
         * - 5로 최대한 나누고, 남은 무게(n % 5)에 따라 3kg 봉지 추가
         * - 규칙:
         *   • n == 4 or 7 → 조합 불가 → -1
         *   • n % 5 == 0 → n/5
         *   • n % 5 == 1 or 3 → n/5 + 1
         *   • n % 5 == 2 or 4 → n/5 + 2
         *
         * ⏱️ 복잡도
         * - 시간: O(1)
         * - 공간: O(1)
         *
         * ✅ 구현 평가
         * - 하드코딩처럼 보이지만 완전한 규칙화 기반 → 최적 해
         * - DP나 완전탐색보다 단순하고 빠름
         *
         * 🛠️ 보완 포인트
         * 1) switch문으로 구조화 → 가독성 향상
         * 2) 변수명 answer → bags 등 의미 있는 명칭
         * 3) 불가능 케이스(4,7)는 조기 리턴으로 조건 단순화 가능
         *
         * 🧩 실무 응용
         * - 단위 조합(화폐, 자재, 리소스) 최적 분배 문제의 기본 패턴
         * - 그리디로 성립하는지 여부를 수학적으로 먼저 확인하는 습관 중요
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 4 || n == 7) {
            System.out.println(-1);
            return;
        }
        int bags;
        switch (n % 5) {
            case 0: bags = n / 5; break;
            case 1:
            case 3: bags = (n / 5) + 1; break;
            case 2:
            case 4: bags = (n / 5) + 2; break;
            default: bags = -1; break; // 이론상 도달 불가
        }
        System.out.println(bags);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📐 BOJ 2903 - 중앙 이동 알고리즘
         *
         * 📌 문제 요약
         * - 정사각형의 한 변을 계속 중앙을 기준으로 분할할 때,
         *   점의 개수는 n단계 후 (2^n + 1)^2 이 된다.
         *
         * 🧱 로직
         * - 각 단계마다 한 변의 점 개수가 두 배로 늘고, 모서리에 +1 점 추가
         *   side = 2^n + 1
         *   result = side^2
         *
         * ⏱️ 복잡도
         * - 시간: O(1)
         * - 공간: O(1)
         *
         * ✅ 구현 포인트
         * - Math.pow(double) 대신 비트 시프트 (1 << n) 사용 → 오차 없는 정수 연산
         * - (1 << n)는 2^n을 빠르고 정확하게 계산
         * - side * side 로 직접 제곱 (int 한도 내에서 안정)
         *
         * ⚠️ 주의
         * - double 연산은 n이 커질 때 정밀도 오차 가능
         * - int 범위: n ≤ 15까지 안전 (문제 조건상 충분)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int side = (1 << n) + 1;   // 2^n + 1 을 비트 연산으로 계산
        System.out.println(side * side);
    }
}


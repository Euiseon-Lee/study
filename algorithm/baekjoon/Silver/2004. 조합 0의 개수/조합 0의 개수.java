import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    /**
     * 🎯 문제: 백준 2004 - 조합 0의 개수
     *
     * 🧩 왜 '0의 개수'인가?
     * - 어떤 수의 끝자리에 '0'이 붙으려면 10이 곱해져야 함
     * - 10 = 2 × 5 → 결국 2와 5의 쌍이 몇 개 있는지가 중요
     *
     * 📐 조합 정의
     * - nCm = n! / (m! * (n-m)!)
     *   (예: 5C2 = 5! / (2! * 3!))
     *
     * 📐 팩토리얼 속 소인수 개수 세기
     * - x! = 1 × 2 × 3 × ... × x
     * - 이 안에 특정 소수 p(예: 2, 5)가 몇 번 곱해졌는지 구하려면?
     *   v_p(x!) = ⌊x/p⌋ + ⌊x/p²⌋ + ⌊x/p³⌋ + ...
     *   → p의 배수 개수 + p²의 배수 개수 + ...
     *   → 예: 10!에서 2의 개수:
     *         10/2=5(짝수 개수) + 10/4=2(4의 배수에서 추가로 2 한 번 더) + 10/8=1(8의 배수에서 또 2 추가)
     *         총 8개
     *
     * 📐 조합에서의 2와 5 개수
     * - nCm = n! / (m! * (n-m)!)
     * - 따라서,
     *   v_p(nCm) = v_p(n!) - v_p(m!) - v_p((n-m)!)
     *   (분모에 있는 p의 개수를 분자에서 빼주는 것)
     *
     * 📐 최종 답
     * - 끝 0의 개수 = min(v_2(nCm), v_5(nCm))
     * - 이유: 2는 항상 5보다 많으므로 5가 '병목'이 됨
     *   하지만 혹시 모를 케이스 대비 두 개 중 작은 값을 택함
     *
     * ⚙️ 로직 요약
     * 1) v2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n-m, 2)
     * 2) v5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n-m, 5)
     * 3) 정답 = Math.min(v2, v5)
     *
     * 🚀 성능
     * - 시간복잡도: O(log n) (2와 5에 대해 나눗셈 반복)
     * - 메모리: O(1)
     * - 팩토리얼 계산 자체가 없어 큰 수(n~20억)도 안전
     *
     * 🧪 예시 검증
     * - 5C2 = 10 → 끝에 0 하나
     *   v2(5!)=3, v2(2!)=1, v2(3!)=1 → 3-1-1=1
     *   v5(5!)=1, v5(2!)=0, v5(3!)=0 → 1-0-0=1
     *   → min(1,1)=1 ✅
     *
     * 🔒 보완 포인트
     * - long 타입 사용 (n 최대 2e9)
     * - m=0 또는 m=n일 때 결과 1이므로 끝 0은 없음
     */
    private static long countFactor(long x, int p) {
        long cnt = 0;
        while (x > 0) {
            x /= p;
            cnt += x;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long v2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
        long v5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);

        long answer = Math.min(v2, v5);
        System.out.println(answer);
    }

}

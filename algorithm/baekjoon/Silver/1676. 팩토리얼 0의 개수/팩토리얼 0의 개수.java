import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 1676 팩토리얼 0의 개수 – 5의 배수 개수 세기
         *
         * 💡 핵심 아이디어
         * - n!의 끝 0 개수 = 10의 인수 개수 = (2×5) 쌍의 개수
         * - 2는 항상 충분하므로 5의 개수만 세면 된다.
         * - 5, 25(=5²), 125(=5³) ... 마다 5가 누적되므로
         *   count = n/5 + n/25 + n/125 + ... 로 계산
         *
         * ⚙️ 알고리즘
         * while (n >= 5) {
         *   count += n / 5;
         *   n /= 5;
         * }
         *
         * ⏱️ 복잡도
         * - 시간: O(log₅N)
         * - 공간: O(1)
         *
         * ⚠️ 실수 포인트
         * - n! 직접 계산하면 오버플로 발생 (long도 불가능)
         * - 문자열 뒤집기 루프 조건 i < 0 → i >= 0 으로 수정 필요
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        System.out.print(count);
    }
}

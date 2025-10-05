import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🐌 BOJ 2869 - 달팽이는 올라가고 싶다
         *
         * 📌 문제 요약
         * - 낮에는 A미터 올라가고 밤에는 B미터 미끄러지는 달팽이가
         *   높이 V에 도달하는 데 걸리는 일수 계산.
         * - 단, 마지막 날에는 미끄러지지 않음.
         *
         * 🧮 수식 유도
         *  - 하루 순증가량: (A - B)
         *  - 마지막 날은 밤에 미끄러지지 않으므로 목표 높이를 (V - B)로 조정
         *  - 필요한 날 수 = ⌈(V - B) / (A - B)⌉
         *  - 정수 연산으로 올림 구현: (x + d - 1) / d
         *
         * ⏱️ 복잡도
         * - 시간: O(1)
         * - 공간: O(1)
         *
         * ✅ 구현 포인트
         * - long 타입 사용: 오버플로우 방지 (V ≤ 1e9)
         * - Math.ceil 대신 정수식 (need + daily - 1) / daily 사용 → 빠르고 정확
         * - 직관적 변수명(daily, need, days)으로 가독성 향상
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long v = Long.parseLong(st.nextToken());
        long daily = a - b;
        long need  = v - b;            // 마지막 날 밤은 미끄러지지 않으므로 빼기
        long days  = (need + daily - 1) / daily;         // 올림 처리
        System.out.println(days);
    }

}

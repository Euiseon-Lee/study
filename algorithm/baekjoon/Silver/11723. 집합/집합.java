import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 11723 집합 – 비트마스크 기반 최적화 구현
         *
         * 🧩 문제 개요
         * - 정수 1~20으로 구성된 집합 S를 관리하는 6가지 명령 수행:
         *   add x, remove x, check x, toggle x, all, empty
         * - check 명령의 결과(1/0)를 출력
         *
         * 💡 핵심 아이디어: 비트마스크 (Bitmask)
         * - int형 정수(32bit) 하나로 1~20의 포함 여부를 표현
         *   각 비트는 “원소 존재 여부(1/0)”를 나타냄.
         *   예) bit = 0b000...01000 → 원소 3 포함
         *
         * ⚙️ 연산별 동작 원리
         * 1️⃣ add x    → bit |= (1 << x)
         *     • x번째 비트를 1로 설정 (추가)
         *
         * 2️⃣ remove x → bit &= ~(1 << x)
         *     • x번째 비트를 0으로 초기화 (제거)
         *
         * 3️⃣ check x  → (bit & (1 << x)) != 0
         *     • x번째 비트가 1인지 확인 (1: 존재, 0: 없음)
         *
         * 4️⃣ toggle x → bit ^= (1 << x)
         *     • x번째 비트를 반전 (있으면 제거, 없으면 추가)
         *
         * 5️⃣ all      → bit = (1 << 21) - 2
         *     • 1~20번째 비트를 모두 1로 설정 (0번째 비트 제외)
         *
         * 6️⃣ empty    → bit = 0
         *     • 모든 비트를 0으로 초기화 (집합 비우기)
         *
         * 🧠 비트 연산자 요약
         * - | (OR) : 특정 비트를 1로 만든다.
         * - & (AND): 특정 비트를 0으로 만든다. (~mask 이용)
         * - ^ (XOR): 특정 비트를 반전시킨다.
         * - << n   : 1을 왼쪽으로 n칸 이동 (n번째 비트 선택)
         * - ~mask  : 비트를 반전시켜 특정 자리만 0으로 만든다.
         *
         * ⏱️ 복잡도
         * - 모든 연산: O(1)
         * - 공간: O(1)
         *
         * 🧩 예시 흐름
         *   add 3   → bit = 0b000000000000000001000
         *   add 5   → bit = 0b000000000000000101000
         *   check 3 → 1 출력
         *   remove 5→ bit = 0b000000000000000001000
         *   toggle 3→ bit = 0b000000000000000000000
         *
         * 🧠 실무적 의의
         * - 비트마스크는 유한 범위의 상태(1~N)를 효율적으로 저장/비교하는 방식.
         * - DFS 방문처리, 부분집합 탐색, 권한 플래그(permissions) 관리 등에서도 동일하게 응용됨.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int bit = 0;

        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final String cmd = st.nextToken();
            int x;

            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    bit |= (1 << x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    bit &= ~(1 << x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((bit & (1 << x)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bit ^= (1 << x);
                    break;
                case "all":
                    bit = (1 << 21) - 2;        // 1~20 bit를 모두 1로
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}


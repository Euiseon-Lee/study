import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📌 스택 수열 (BOJ 1874)
         *
         * 🧠 핵심 아이디어
         * - push는 1부터 오름차순으로만 가능
         * - 목표 값(value)을 만들기 위해:
         *   1) value > start → start+1~value까지 push (+), 이후 pop (-)
         *   2) value == stack.top → pop (-)
         *   3) 그 외 → 불가능 → "NO"
         *
         * ⚙️ 로직 구조
         * - start: 마지막으로 push한 수를 기록
         * - stack: 현재까지 쌓인 숫자
         * - StringBuilder: 연산 기록 저장 후 한 번에 출력
         *
         * 🚀 성능
         * - 시간: O(n) (각 수는 최대 1번 push/pop)
         * - 공간: O(n) (스택 최대 크기 n)
         * - I/O 최적화: BufferedReader + StringBuilder
         *
         * 🔒 보완 포인트
         * - Stack 대신 ArrayDeque 권장 (성능/현대적 스타일)
         * - peek/pop 전 스택 비었는지 체크 → 안정성 확보
         * - 출력은 print(sb)로 처리해 마지막 개행 제어
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (start < value) {
                for (int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                start = value;
            } else if (value == stack.peek()) {
                stack.pop();
                sb.append("-\n");

            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }

}

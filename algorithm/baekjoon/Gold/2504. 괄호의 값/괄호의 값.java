import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 2504 - 괄호의 값 (스택 + 가중치 누적)
         *
         * 📌 규칙
         * - "()" = 2, "[]" = 3
         * - XY  = X + Y  (연결은 합)
         * - (X) = 2 * X
         * - [X] = 3 * X
         *
         * 🧱 로직 구조
         * - 스택에 여는 괄호를 push하고, 중첩 가중치 value를 유지
         *   '(' → value *= 2, '[' → value *= 3
         * - 닫는 괄호에서:
         *   - 스택 최상단과 짝이 아니면 invalid
         *   - 직전 문자가 바로 여는 괄호라면(막 닫힘) result += value
         *   - 스택 pop 후 value 원복: ')' → /= 2, ']' → /= 3
         * - 종료 후 스택이 비어 있지 않으면 invalid
         *
         * ⏱️ 복잡도
         * - 시간: O(n) (각 문자 1회 처리)
         * - 공간: O(n) (스택)
         *
         * ✅ 포인트
         * - value는 진입 시 곱하고, 닫을 때 나눠서 "현재 중첩의 값"을 추적
         * - 막 닫힌 쌍일 때만 result에 더함 (연결은 합 규칙 반영)
         *
         * ⚠️ 주의
         * - 잘못된 상태 발견 시 즉시 invalid 처리
         *
         * 🌟 로직의 장점
         * 1) 한 번의 순회로 중첩 구조 계산 가능 (O(n))
         * 2) 스택 검증과 값 계산을 동시에 처리 → 별도 검증 불필요
         * 3) 부분 구조를 따로 계산하지 않고 value 곱/나누기로 즉시 반영
         * 4) 막 닫힌 괄호에서만 result += value → 합산 타이밍이 단순·명확
         * 5) 괄호 종류가 늘어나도 쉽게 확장 가능 ({}나 <> 추가도 동일 원리)
         * 6) 검증·계산·합산을 통합해 코드가 간결하고 성능도 최적화됨
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        int result = 0;
        int value = 1;
        boolean invalid = false;

        for(int i = 0; i < line.length(); i++) {
            char ch =  line.charAt(i);
            if (ch == '(') {
                deque.push(ch);
                value *= 2;
            } else if (ch == '[') {
                deque.push(ch);
                value *= 3;
            } else if (ch == ')') {
                if (deque.isEmpty() || deque.peek() != '(') {
                    invalid = true;
                    break;
                }
                if (i > 0 && line.charAt(i - 1) == '(') result += value;
                deque.pop();
                value /= 2;
            } else if (ch == ']') {
                if (deque.isEmpty() || deque.peek() != '[') {
                    invalid = true;
                    break;
                }
                if (i > 0 && line.charAt(i - 1) == '[') result += value;
                deque.pop();
                value /= 3;
            } else {
                invalid = true;
                break;
            }
        }
        if (invalid || !deque.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 후위 표기식(RPN) 평가 – 현재 구현 설명 및 주의점
         *
         * [문제 구조]
         * - N(1~26)개의 피연산자 값이 A,B,C,... 순서로 주어짐
         * - expr(후위 표기식)에는 'A'부터 N개만 등장
         * - 결과는 소수점 둘째 자리까지 출력
         *
         * [핵심 로직]
         * - 매핑: 'A'~'Z' → values[ch - 'A'] 로 O(1) 조회
         * - 스택 처리:
         *   • 피연산자(알파벳): 해당 값을 push
         *   • 연산자(+, -, *, /, %): right = pop(), left = pop() → (left op right) 연산 → push
         *   • 최종적으로 스택에 1개만 남아야 함
         *
         * [순서 규칙(매우 중요)]
         * - pop 순서는 항상 right 먼저, 그다음 left
         *   예) '-'는 (left - right), '/'는 (left / right)
         *   순서가 바뀌면 비가환 연산에서 오답 발생
         *
         * [I/O 및 수치형]
         * - values는 double로 보관하고 계산도 double로 수행
         * - 출력은 printf("%.2f")로 고정 소수점 2자리
         * - 입력 값은 자연수이지만, 중간/최종 결과가 실수가 될 수 있으므로 double 유지가 안전
         *
         * [성능/복잡도]
         * - 시간 O(|expr|): 토큰 1회 순회, 스택 연산 O(1)
         * - 공간 O(|expr|): 스택 최대 깊이
         * - ArrayDeque<Double> 사용: 캐시 친화적, null 원소 금지
         *
         * [안전성/주의]
         * - 입력이 유효하다는 전제(온라인 저지). 일반화 시에는 다음 가드 필요:
         *   • 연산 전 stack.size() >= 2 확인 (언더플로 방지)
         *   • 나눗셈에서 right == 0.0 방어
         *   • 허용되지 않은 연산자 입력 시 예외 처리
         * - '%'의 의미: double 나머지 연산. 정수 도메인 한정이 필요하면 사전 캐스팅/검증 필요
         *
         * [확장 아이디어(선택)]
         * - 연산자 추가/우선순위가 필요한 경우: Shunting-yard로 중위→후위 변환 후 동일 스택 평가
         * - 성능 미세화: 오토박싱 제거를 위해 double[] 기반 수동 스택 사용 가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String expr = br.readLine().trim();

        double[] values = new double[26];
        for (int i = 0; i < N; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                stack.push(values[ch - 'A']);
            } else {
                double right = stack.pop();
                double left  = stack.pop();
                double res;

                switch (ch) {
                    case '+': res = left + right; break;
                    case '-': res = left - right; break;
                    case '*': res = left * right; break;
                    case '/': res = left / right; break;
                    case '%': res = left % right; break;
                    default:  throw new IllegalArgumentException("Unknown operator: " + ch);
                }
                stack.push(res);
            }
        }

        double answer = stack.pop();
        System.out.printf("%.2f%n", answer);
    }

}

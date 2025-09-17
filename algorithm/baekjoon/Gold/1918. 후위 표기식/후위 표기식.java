import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 1918 – 중위 → 후위 변환 (Shunting-yard 변형)
         *
         * 🧠 규칙 요약
         * - 피연산자(알파벳): 즉시 출력
         * - 연산자(+,-,*,/): 스택 top이 '('가 아니고, top의 우선순위 >= 현재 우선순위면 pop→출력 후 push
         *   (모든 연산자는 좌결합이므로 '>=') 
         * - '(' : push
         * - ')' : '(' 나올 때까지 pop→출력, '('는 버림
         * - 입력 종료 후 스택의 연산자 모두 pop→출력
         *
         * 🧮 우선순위
         * - '*' '/' : 2  >  '+' '-' : 1  >  기타/괄호 : 0
         *
         * ⚠️ 자주 나는 실수
         * - 동일 우선순위에서 '>'만 사용 → '+', '-'가 스택에 남아 순서 꼬임
         * - 괄호를 우선순위 비교에 포함 → '('가 pop되어 잘못된 출력
         *   → while 조건에 반드시 "stack.peek() != '('" 가드(또는 우선순위 0 + 가드)
         *
         * 🚀 복잡도
         * - 시간: O(n) (한 번 순회, push/pop은 암ortized O(1))
         * - 공간: O(n) (스택)
         *
         * 🔧 리팩토링 아이디어
         * - isOperator(c) 분리해서 연산자만 우선순위 비교 대상으로 처리
         * - checkPriority는 연산자에만 호출(피연산자/괄호는 건너뜀)
         *
         * 🧪 빠른 자체 테스트
         * - A+B*C-D/E      → ABC*+DE/-
         * - (A+B)*C        → AB+C*
         * - A*(B+C*D)-E    → ABCD*+*E-
         * - A/B*C          → AB/C*
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int priority = checkPriority(c);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && checkPriority(stack.peek()) >= priority) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
    private static int checkPriority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else  {
            return 0;
        }
    }

}

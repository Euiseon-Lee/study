import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📌 괄호 판별 – 카운터 방식
         *
         * 🧠 핵심 아이디어
         * - 여는 괄호 '(' → count++
         * - 닫는 괄호 ')' → count--
         * - 진행 중 count < 0 → 잘못된 문자열 (닫는 괄호 과다)
         * - 종료 시 count == 0 → 올바른 VPS, 아니면 여는 괄호가 남은 것
         *
         * ✅ 올바른 VPS 조건
         * 1) 중간 과정에서 ')'가 '('보다 많아지면 ❌ (count < 0)
         * 2) 최종적으로 '('와 ')'의 수가 같아야 함 (count == 0)
         *
         * 🚀 성능 특성
         * - 시간복잡도: O(n) (문자열 길이만큼 한 번 순회)
         * - 공간복잡도: O(1) (정수 변수 하나만 사용)
         * - 스택 대비 메모리 효율이 높음 → 실무 환경에서 선호됨
         *
         * 🛠 실무 활용 관점
         * - "카운터 방식"은 단일 괄호 짝 검증에 가장 간단하고 빠른 방법
         *   예) 문자열 파싱 중 괄호 짝 검증, 수식 유효성 체크, 코드 포맷터 등
         * - 자료구조(Stack)를 쓰지 않아도 되므로
         *   가벼운 런타임 환경이나 대용량 로그 처리에서 유리
         * - 다만 다양한 괄호((), {}, []) 조합을 다루거나
         *   중첩 구조의 실제 내용을 추적해야 할 때는 스택 방식이 필요
         *
         * 🔒 보완 포인트
         * - 문제 조건이 단일 괄호에 한정된 경우에만 적용
         * - 다종 괄호/중첩 구조 → 스택 기반으로 전환 필요
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int count = 0;
            boolean valid = true;

            for (int k = 0; k < s.length(); k++) {
                char c = s.charAt(k);
                if (c == '(') {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        valid = false;
                        break;
                    }
                }
            }
            if (count != 0) valid = false;

            out.append(valid ? "YES" : "NO").append('\n');
        }
        System.out.print(out);
    }
}

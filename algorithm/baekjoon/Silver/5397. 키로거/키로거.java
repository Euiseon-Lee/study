import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * ⌨️ BOJ 5397 - 키로거 (두 덱 기반 커서 편집)
         *
         * 📌 문제 요약
         * - 입력 문자열의 키 입력(문자, '<', '>', '-')를 처리해 최종 비밀번호를 구한다.
         * - 커서 이동/삭제/삽입을 효율적으로 처리해야 한다.
         *
         * 🧱 로직 구조
         * - 커서 왼쪽 문자들: left (끝이 커서 바로 왼쪽)
         * - 커서 오른쪽 문자들: right (끝이 커서 바로 오른쪽)
         * - 명령 처리
         *   < : if (!left.isEmpty())  right.addLast(left.removeLast())
         *   > : if (!right.isEmpty()) left.addLast(right.removeLast())
         *   - : if (!left.isEmpty())  left.removeLast()
         *   그 외(일반 문자): left.addLast(c)
         * - 결과 출력
         *   while (!right.isEmpty()) left.addLast(right.removeLast())  // right를 역순으로 합침
         *   while (!left.isEmpty())  sb.append(left.removeFirst())     // left를 앞에서부터 출력
         *
         * ⏱️ 복잡도
         * - 각 문자 처리 O(1), 총 O(L) (L = 입력 길이 합)
         * - ArrayDeque의 add/removeLast/First는 평균 O(1)
         *
         * ✅ 장점
         * - 덱 2개로 커서 양측을 분리 → 불필요한 이동/재배열 없음
         * - I/O 최소화: StringBuilder/StringBuffer에 케이스별 결과 누적 후 일괄 출력
         *
         * ⚠️ 보완 포인트
         * - 제네릭 명시: Deque<Character> (Raw type 지양)
         * - 멀티스레드 환경이 아니므로 StringBuilder 사용 권장
         * - 테스트 케이스마다 덱을 새로 만들거나 clear로 상태 초기화 명시
         * - 빈 덱에서 remove/poll 금지 → isEmpty()로 가드 (이미 반영됨)
         *
         * 🧪 엣지 케이스
         * - 모든 문자가 삭제되는 경우 (빈 문자열 출력)
         * - 커서 이동만 있는 경우 (<, > 연속)
         * - 긴 입력(1e6 수준)에서 시간/메모리 한도 내 동작 확인
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '<' : if (!left.isEmpty()) right.addLast(left.removeLast()); break;
                    case '>' : if (!right.isEmpty()) left.addLast(right.removeLast()); break;
                    case '-' : if (!left.isEmpty()) left.removeLast(); break;
                    default: left.addLast(c); break;
                }
            }
            while (!right.isEmpty()) left.addLast(right.removeLast());
            while (!left.isEmpty()) sb.append(left.removeFirst());
            sb.append('\n');
        }
        System.out.println(sb);
    }

}

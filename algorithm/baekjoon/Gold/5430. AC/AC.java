import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔁 BOJ 5430 AC – 방향 토글 + 양끝 삭제 기반 Deque 시뮬레이션
         *
         * 🧩 문제 개요
         * - 명령어 시퀀스(문자열)와 정수 배열이 주어짐.
         * - 명령어 종류:
         *   • R: 배열의 순서를 뒤집음 (Reverse)
         *   • D: 배열의 첫 번째 수를 버림 (Delete)
         * - 단, 실제 배열 뒤집기 없이 결과를 출력해야 효율적임.
         * - 빈 배열에서 D가 수행되면 "error" 출력.
         *
         * ⚙️ 핵심 아이디어
         * - Deque(양끝 큐) 사용 → 양쪽 끝에서 O(1)로 삽입/삭제 가능
         * - reverse 플래그 토글 방식
         *   → R 명령 시 실제 뒤집지 않고, 방향 플래그만 반전 (논리적 뒤집기)
         *   → D 명령 시 플래그 상태에 따라 pollFirst() / pollLast() 수행
         * - 최종 출력 시 reverse 상태에 따라 앞/뒤에서 출력
         * - 실제로 배열을 뒤집지 않으므로 O(p + n)으로 동작 (p: 명령 개수, n: 배열 크기)
         *
         * 🧮 동작 예시
         *   예시 입력:
         *   RDD
         *   [1,2,3,4]
         *
         *   1) R → reverse = true
         *   2) D → reverse=true → 뒤에서 pollLast() → [1,2,3]
         *   3) D → reverse=true → 뒤에서 pollLast() → [1,2]
         *   4) 출력: [2,1]
         *
         * ⏱️ 시간·공간 복잡도
         * - 입력 파싱: O(n)
         * - 명령 처리: O(p)
         * - 출력 직렬화: O(남은 원소 수)
         * - 전체: O(p + n)
         * - 공간: O(n)
         *
         * ✅ 구현 포인트
         * 1️⃣ 입력 파싱
         *     - StringTokenizer(line, "[],")으로 숫자만 추출 → 안전하고 간결
         * 2️⃣ 연산 처리
         *     - R → reverse = !reverse
         *     - D → Deque이 비었으면 "error" 출력 후 다음 테스트케이스로 이동
         *     - D 수행 시 reverse 상태에 따라 pollFirst() 또는 pollLast()
         * 3️⃣ 출력 구성
         *     - 남은 원소가 없으면 "[]"
         *     - reverse 상태에 따라 앞/뒤 순회하며 ','로 구분
         *
         * 🛠️ 보완 포인트
         * - 사전 에러 판정(선택): ops 내 D의 개수가 n보다 많으면 즉시 "error"
         * - 출력 중복 최소화: 방향 분기에 따라 공통 루프를 함수화할 수도 있음
         * - char[] 대신 charAt(i) 순회 시 오브젝트 생성 비용 약간 감소
         *
         * 🧠 실무적 의의
         * - 실제 데이터 구조를 뒤집지 않고 논리 상태로만 관리하는 기법은
         *   대용량 데이터 처리(Reverse Query, Pagination 등)에서도 동일하게 적용 가능.
         * - Deque의 양끝 O(1) 연산 패턴은 양방향 탐색, 회전, 슬라이딩 윈도우 문제에서 매우 유용함.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            String opLine = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            int dCount = 0;
            for (int i = 0, len = opLine.length(); i < len; i++) {
                if (opLine.charAt(i) == 'D') dCount++;
            }
            if (dCount > n) {
                sb.append("error").append('\n');
                continue;
            }

            Deque<Integer> dq = new ArrayDeque<>(Math.max(8, n));
            StringTokenizer st = new StringTokenizer(line, "[],");
            for (int i = 0; i < n; i++) dq.addLast(Integer.parseInt(st.nextToken()));

            boolean reverse = false;
            boolean error = false;

            for (int i = 0, len = opLine.length(); i < len; i++) {
                char op = opLine.charAt(i);
                if (op == 'R') {
                    reverse = !reverse;
                } else {
                    if (dq.isEmpty()) {
                        sb.append("error").append('\n');
                        error = true;
                        break;
                    }
                    if (!reverse) dq.pollFirst(); else dq.pollLast();
                }
            }
            if (error) continue;

            sb.append('[');
            if (!dq.isEmpty()) {
                if (!reverse) {
                    sb.append(dq.pollFirst());
                    while (!dq.isEmpty()) sb.append(',').append(dq.pollFirst());
                } else {
                    sb.append(dq.pollLast());
                    while (!dq.isEmpty()) sb.append(',').append(dq.pollLast());
                }
            }
            sb.append(']').append('\n');
        }
        System.out.print(sb);
    }
}

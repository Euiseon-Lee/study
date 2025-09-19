import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 1158 – 요세푸스 문제
         *
         * 🧠 핵심 아이디어
         * - 사람들을 큐(Deque)에 1..n 순서로 넣고,
         *   매 단계마다 (k-1)번 앞에서 뒤로 회전 → 맨 앞을 제거하여 결과에 추가.
         *
         * ⚙️ 현재 구현 평가
         * - 자료구조: ArrayDeque 사용 👍 (연속적인 poll/add O(1))
         * - 회전/제거 로직: for 0..k-2 { pollFirst → addLast } 후 pollFirst로 제거 ✅
         * - 출력 포맷: "<a, b, ...>" 형태로 마지막만 별도 처리 ✅
         *
         * 🔧 보완 포인트
         * - 네이밍: Deque는 FIFO 큐 역할이므로 변수명을 queue가 더 명확.
         * - 초기화: for (i=1..n) queue.addLast(i) 가 직관적(현재는 push를 써서 역순 삽입).
         * - 경계: k==1일 때 회전 루프가 0회라서 바로 제거 → 현재 코드도 정상 동작.
         * - 복잡도: 총 회전 횟수가 O(n*k). (n ≤ 5000이면 Java에서 충분히 통과)
         *   더 줄이려면 인덱스 포인터 + 원형 리스트(또는 Fenwick/SegmentTree)로 O(n log n) 가능하지만 과함.
         *
         * 🧪 간단 셀프테스트
         * - n=7, k=3 → <3, 6, 2, 7, 5, 1, 4>
         * - n=5, k=1 → <1, 2, 3, 4, 5>
         * - n=6, k=6 → <6, 5, 4, 3, 2, 1>
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int removeIndex = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }
        StringBuilder sb = new StringBuilder("<");
        while (queue.size() > 1) {
            for (int i = 0; i < removeIndex - 1; i++) {
                int val = queue.pollFirst();
                queue.addLast(val);
            }
            sb.append(queue.pollFirst()).append(", ");
        }
        sb.append(queue.pollFirst()).append(">");
        System.out.println(sb);
    }

}

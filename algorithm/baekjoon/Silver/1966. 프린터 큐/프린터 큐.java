import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 1966 – 프린터 큐 (클래스 없이 index + 배열 방식)
         *
         * 🧠 문제 아이디어
         * - 문서는 "우선순위"와 "타겟 여부"라는 두 가지 정보가 필요함.
         * - 별도의 Doc 클래스 대신:
         *   1) 우선순위는 배열 priorities[i] 에 저장
         *   2) 큐에는 문서의 index만 저장
         * - 이렇게 하면 큐에서 index를 꺼낼 때 priorities[curIdx] 로 우선순위를 확인 가능.
         * - 타겟 여부는 index == targetIdx 로 판별 가능.
         *
         * ⚙️ 알고리즘 절차
         * 1. 초기화: priorities 배열에 입력 저장, 큐에는 0..n-1 인덱스 순서대로 삽입
         * 2. 루프:
         *    - 큐 맨 앞의 문서(curIdx)를 꺼냄
         *    - 큐 안에 priorities[curIdx]보다 더 높은 우선순위가 있으면 → 뒤로 보냄
         *    - 그렇지 않으면 → "출력":
         *         printed++ 증가
         *         만약 curIdx == targetIdx → 이 시점의 printed 값이 정답
         *
         * 🚀 복잡도
         * - 매 단계마다 큐를 순회해 더 높은 우선순위가 있는지 확인 → O(N^2) 최악
         * - 하지만 N ≤ 100 이므로 충분히 빠름
         *
         * ✅ 장점
         * - priorities 배열 + index 큐로만 처리 → 직관적, 메모리 사용 최소화
         *
         * ⚠️ 단점
         * - 현재 큐 안의 최댓값 확인을 매번 O(N)으로 수행 → 입력이 커지면 비효율적
         * - (대안) 우선순위 빈도 배열 + 전역 max 추적으로 O(N)까지 줄일 수 있음
         */
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb   = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int targetIdx = Integer.parseInt(st.nextToken());

            int[] priorities = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
            }
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) q.addLast(i);

            int printed = 0;
            while (!q.isEmpty()) {
                int curIdx = q.pollFirst();
                boolean hasHigher = false;
                for (int idx : q) {
                    if (priorities[idx] > priorities[curIdx]) {
                        hasHigher = true;
                        break;
                    }
                }
                if (hasHigher) {
                    q.addLast(curIdx);
                } else {
                    printed++;
                    if (curIdx == targetIdx) {
                        sb.append(printed).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }

}

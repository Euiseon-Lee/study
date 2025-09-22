import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
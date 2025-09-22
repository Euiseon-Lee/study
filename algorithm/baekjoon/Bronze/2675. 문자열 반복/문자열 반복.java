import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 2675 – 문자열 반복
         *
         * 🧠 로직
         * - 테스트케이스 수 n 입력
         * - 각 케이스마다 (repeat, str) 입력받음
         * - 문자열의 각 문자에 대해 repeat번 반복 출력
         *
         * ✅ 구현 특징
         * - String.repeat(int) 활용 → 코드 간결
         * - StringBuilder 사용 → 출력 누적 최적화
         *
         * 🔧 개선 아이디어
         * - char → String 변환 대신 char append 반복이 더 직관적이고 성능상 이점 있음
         *   예: for (int k=0; k<repeat; k++) sb.append(c);
         *
         * 🚀 복잡도
         * - O(totalLength * repeat) : 입력 제한 내에서 충분히 빠름
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++) {
                String target = str.charAt(j) + "";
                sb.append(target.repeat(repeat));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


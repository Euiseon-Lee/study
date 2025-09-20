import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 14425 – 문자열 집합
         *
         * 🧠 로직
         * - N개의 문자열을 집합(Set)에 저장
         * - M개의 문자열을 입력받으며 집합에 포함 여부 검사
         *
         * 🚀 성능
         * - HashSet membership 검사 평균 O(1)
         * - 전체 O(N + M)
         *
         * ✅ 보완
         * - value가 불필요하므로 Map 대신 Set 활용
         * - 코드 의도가 더 명확해지고 메모리 약간 절약
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            stringSet.add(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (stringSet.contains(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}

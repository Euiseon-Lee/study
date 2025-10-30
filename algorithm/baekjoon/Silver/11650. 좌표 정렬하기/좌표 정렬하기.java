import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📍 BOJ 11650 좌표 정렬하기 – (x 오름차순 → y 오름차순) 정렬
         *
         * 💡 핵심 아이디어
         * - 2차원 점 (x, y)를 x 기준 오름차순 정렬하고, x가 같으면 y 오름차순으로 정렬.
         * - Comparator로 "주 정렬키(x) → 보조 정렬키(y)"를 명시해 의도를 분명히 한다.
         *
         * ⏱️ 복잡도
         * - 정렬: O(N log N), 출력: O(N)
         * - 메모리: O(N) (입력 점 저장용)
         *
         * 🧩 구현 포인트
         * - 입력: int[][] points = new int[N][2]에 (x, y) 저장
         * - 정렬: Arrays.sort(points, (a, b) -> {
         *     int byX = Integer.compare(a[0], b[0]);
         *     return (byX != 0) ? byX : Integer.compare(a[1], b[1]);
         *   });
         * - 출력: StringBuilder에 누적 (중간 문자열 생성 없이 append 체인)
         *
         * 🛠️ 보완 포인트
         * - 비교 로직에서 뺄셈(e1[0]-e2[0]) 대신 Integer.compare 사용 → 오버플로 습관적 방지
         * - 출력 시 " " + 값 형태의 문자열 합성 지양 → append 체인으로 성능/가독성 개선
         * - 변수명: coordinate → points/coords 등 관례적 명칭 권장
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x
            points[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        Arrays.sort(points, (a, b) -> {
            int byX = Integer.compare(a[0], b[0]);
            return (byX != 0) ? byX : Integer.compare(a[1], b[1]);
        });

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(points[i][0]).append(' ').append(points[i][1]).append('\n');
        }
        System.out.print(sb);
    }
}


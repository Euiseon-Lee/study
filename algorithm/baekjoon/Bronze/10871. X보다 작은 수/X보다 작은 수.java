import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔢 BOJ 10871 – X보다 작은 수 (스트리밍 1패스)
         *
         * ✅ 로직 구조
         *  - N과 임계값 X를 받고, N개의 정수를 입력 스트림에서 즉시 소비하며 X보다 작은 값만 공백 구분으로 출력.
         *
         * ✅ 성능 분석
         *  - 시간 O(N), 공간 O(1) (배열/리스트 미사용).
         *  - 문자열 결합 대신 StringBuilder로 누적, 공백은 조건부로 삽입해 불필요 객체 생성 최소화.
         *
         * 🔧 보완 포인트
         *  1) 입력 견고성: 토큰이 줄바꿈으로 끊길 수 있으므로 hasMoreTokens()==false면 다음 줄을 읽어 재토크나이즈.
         *     ✅ 문제
         *      - if (st.hasMoreTokens()) { ... } 는 현재 라인에 토큰이 없으면 이번 반복을 그냥 지나감.
         *      - N개를 처리해야 하는데 입력 정수가 여러 줄에 걸쳐 있으면 일부를 건너뛰게 되어 N개를 소비하지 못함.
         *     ✅ 해법
         *      - while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
         *        → 토큰이 생길 때까지 다음 줄을 계속 읽어 재토크나이즈.
         *        → 입력이 줄바꿈/빈 줄로 분할되어도 정확히 N개를 처리.
         *  2) 출력 형식: 첫 값 전 공백 미삽입(불필요 트림/삭제 없이 정확한 포맷).
         *  3) 미세 최적화: println(sb.toString()) 대신 println(sb) 사용 가능.
         *
         * 🧪 엣지/검증
         *  - X보다 작은 값이 하나도 없는 경우: 빈 줄 출력(문제 요구에 부합).
         *  - 음수/중복 값 포함 케이스.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < n; i++) {
            // 토큰 고갈 시 다음 줄 읽어 재토크나이즈 (입력 라인 분할 대비)
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());

            if (value < x) {
                if (!first) sb.append(' ');
                sb.append(value);
                first = false;
            }
            /* 기존 코드
            if (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(num < x ? num + " " : "");
            }
            */
        }
        System.out.println(sb.toString());
    }
}


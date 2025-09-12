import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 10818 – 최소, 최대 (스트리밍 1패스)
         *
         * ✅ 로직 구조
         *  - N개 정수를 입력 스트림에서 즉시 소비하며 최소/최대를 갱신한다(배열 미사용).
         *
         * ✅ 성능 분석
         *  - 정렬 대비: O(N log N) → O(N), 추가 메모리 O(1)
         *  - 큰 입력에서 StringTokenizer/입력 문자열이 메모리를 일부 점유하나, 배열 미사용으로 총량 감소
         *
         * 🔧 개선 포인트
         *  1) 초기화 방식: min/max를 첫 값으로 초기화 후 i=1부터 순회(센티넬 값 의존 제거).
         *  2) 입력 견고성: 토큰 고갈 시 다음 줄을 읽어 재토크나이즈(여러 줄 입력 대응).
         *  3) 분기 납작화: Math.min/Math.max보다 단순 비교가 분기 예측에 유리(현재 방식 OK).
         *
         * 🧪 엣지/검증
         *  - N=1, 모두 동일 값, 음수/양수 혼합, 범위 경계값(예: -1_000_000, 1_000_000)
         *
         * 🛠 실무 활용도
         *  - “읽으면서 집계”는 로그/스트림 처리의 기본 패턴. 후속 연산이 없다면 컨테이너 보관은 지양.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 첫 값으로 초기화 (센티넬 의존 제거)
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int min = first, max = first;

        for (int i = 1; i < n; i++) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            if (v < min) min = v;
            if (v > max) max = v;
        }
        /* 기존 코드
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }
        */
        System.out.println(min + " " + max);
    }

}

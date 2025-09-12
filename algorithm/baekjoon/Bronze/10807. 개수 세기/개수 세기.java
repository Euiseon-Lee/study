import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔢 BOJ 10807 – 개수 세기 (스트리밍 1패스)
         *
         * ✅ 로직 구조
         *  - 정수 N, 정수 N개, target을 입력받는다.
         *  - 입력 스트림을 한 번만 순회하며 target과 동일한 개수를 카운트한다.
         *
         * ✅ 성능 분석
         *  - 시간 O(N), 공간 O(1)  (배열 미사용: 입력 즉시 소비)
         *  - 문제 요구가 "단일 target의 빈도"에 한정되므로 스트리밍 방식이 최적
         *
         * ✅ 실무 활용도
         *  - “읽으면서 집계” 패턴은 로그/스트림 처리에서 기본기(메모리 사용량 최소화)
         *  - 추가 질의/후속 연산이 없다면 컨테이너(배열/리스트) 보관은 불필요
         *
         * 🔧 보완 포인트
         *  - 입력이 여러 줄로 흩어질 수 있는 환경 대비: 토큰 부족 시 다음 줄을 읽어 보충
         *       while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
         *  - 변수 명확화: temp→value, answer→count 등 의미 드러나게
         *
         * 🧪 엣지/검증
         *  - N=1, target이 존재하지 않는 경우(0), 모두 target인 경우(N)
         *  - 음수/중복 값 포함 케이스
         *
         * 💡 대안 설계(언제 배열/빈도표가 유리한가)
         *  - 다중 질의, 정렬·두 포인터·부분합 등 2차 연산 필요 시 배열 보관/빈도표 사용
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (temp == target) answer++;
        }
        System.out.println(answer);
    }
}


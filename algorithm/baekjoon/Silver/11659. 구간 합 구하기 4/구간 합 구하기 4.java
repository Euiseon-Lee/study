import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 11659 - 구간 합 구하기 (Prefix Sum + Fast I/O 메모)
         *
         * 📌 문제/해법 요약
         * - prefix[i] = A1 + ... + Ai (1-index)
         * - 쿼리 [s, e]의 합 = prefix[e] - prefix[s-1]
         * - 정답 복잡도: 전처리 O(N), 질의 O(1), 총 O(N+M)
         *
         * 🔄 기존 코드 vs 개선 코드(제안안) 핵심 차이
         * 1) 입력 처리
         *   - 공통: BufferedReader + StringTokenizer 로 숫자 파싱
         *   - 차이점: 개선안은 1-index prefix 배열 사용 → 조건 분기 감소
         * 2) 출력 처리
         *   - 기존: StringBuilder 로 모든 줄을 모아 마지막에 println 1회
         *   - 개선: BufferedWriter 로 즉시 write, 마지막에 flush
         *   → 둘 다 I/O 호출 횟수를 줄이는 전략이라 성능 차이는 수십 ms 수준
         *
         * 🧵 BufferedWriter 설명
         * - 출력 시 내부 버퍼(byte[])에 데이터를 쌓아두었다가 flush()/close() 시 한 번에 내보내는 클래스
         * - 장점: 매번 println 호출보다 시스템 호출 비용을 줄여 성능 개선
         * - 사용법:
         *   1) new BufferedWriter(new OutputStreamWriter(System.out))
         *   2) bw.write(String) / bw.write(int) / bw.newLine()
         *   3) 모든 출력 후 bw.flush() 또는 bw.close()
         * - 흔한 실수: flush/close 누락 시 출력 일부가 버퍼에 남음
         *
         * ⏱️ 성능 분석
         * - 병목은 연산이 아닌 입출력 파싱/출력에 있음
         * - BufferedWriter vs StringBuilder+println 모두 “버퍼링 전략”이라 큰 차이는 없음
         * - 메모리 역시 prefix 배열 + I/O 버퍼뿐이므로 큰 차이 없음
         *
         * ✅ 실무형 체크리스트
         * - prefix[0]=0 으로 두어 분기(시작=1일 때) 제거
         * - 입력: StringTokenizer 는 라인 단위로 재사용
         * - 출력: BufferedWriter 로 write 후 flush (또는 StringBuilder+println 도 무방)
         * - 합이 int 범위를 넘어갈 가능성이 있으면 long 사용
         *
         * 📈 결론
         * - 알고리즘은 이미 최적(O(N+M))
         * - BufferedWriter 와 StringBuilder 방식 모두 “버퍼링 출력”이라 드라마틱한 개선은 없음
         * - 다만 1-index prefix + 출력 방식 선택으로 가독성과 안정성을 확보하는 것이 핵심
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] prefix = new int[n + 1]; // 1-index
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write((prefix[e] - prefix[s - 1]) + "\n");
        }

        bw.flush();
        bw.close();
    }

}

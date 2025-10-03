import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * ♟️ BOJ 3003 - 킹, 퀸, 룩, 비숍, 나이트, 폰
         *
         * 📌 문제 요약
         * - 기준 체스 말 개수: [1, 1, 2, 2, 2, 8]
         * - 입력으로 주어진 보유 개수 6개에 대해 (기준 - 보유)를 공백으로 출력
         *
         * 🧱 로직
         * - final int[] pieces 로 기준값을 불변 상수로 명시
         * - StringTokenizer 로 토큰을 읽되, 6개가 모일 때까지 부족하면 다음 줄을 읽어 보충
         * - 출력은 StringBuilder 로 누적, 첫 항목 이후에만 공백 추가하여 트레일링 스페이스 방지
         *
         * ⏱️ 복잡도
         * - 시간: O(1) (상수 6개 처리)
         * - 공간: O(1)
         *
         * ✅ 구현 포인트
         * - 분절 입력(줄바꿈/여분 공백)이 와도 안전하게 토큰 6개 확보
         * - 트레일링 스페이스 없이 정확한 포맷을 보장
         * - 기준값을 final 로 고정해 의도(불변)를 코드 수준에서 표현
         *
         * 🧪 엣지 케이스
         * - 입력이 한 줄에 6개 미만인 경우: 자동으로 다음 줄에서 이어서 파싱
         * - 여분 공백/탭: StringTokenizer 가 자연스럽게 처리
         */
        final int[] pieces = {1, 1, 2, 2, 2, 8};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int read = 0;
        while (read < 6) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                continue;
            }
            int possess = Integer.parseInt(st.nextToken());
            if (read > 0) sb.append(' ');
            sb.append(pieces[read] - possess);
            read++;
        }
        System.out.println(sb);
    }

}

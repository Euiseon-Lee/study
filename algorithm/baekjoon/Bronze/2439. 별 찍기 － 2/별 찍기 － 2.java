import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧱 BOJ 2439 - 오른쪽 정렬 별 찍기
         *
         * 📌 로직
         * - 총 n줄 출력
         * - 각 줄 i(0-index)에서: 공백 (n - i - 1) + 별 (i + 1)
         * - StringBuilder에 누적 후 한 번에 출력하여 I/O 호출 최소화
         *
         * ⏱️ 복잡도
         * - 출력 문자 수가 Θ(n^2)이므로 시간/공간 최소 하한 자체가 n^2에 수렴
         * - 현재 구현: 줄마다 String.repeat로 임시 문자열 2개 생성 → n이 매우 커지면 GC 부하 가능
         *
         * ✅ 장점
         * - 가독성이 매우 높음 (의도가 즉시 드러남)
         * - 한 번의 println으로 출력 → I/O 비용 절감
         *
         * 🛠 보완 포인트
         * - repeat로 매 줄 새 String 생성 → char[]를 재사용하면 할당 감소
         *   예) 공백으로 채운 char[]에 오른쪽부터 '*'를 1개씩 늘려가며 append
         * - 불필요한 문자열 변수(space, star)는 char 리터럴로 대체 가능
         * - '\n' 사용은 BOJ 환경에서 OK, 이식성을 높이려면 System.lineSeparator() 고려
         *
         * 🧪 엣지 케이스
         * - n의 최소/최대 (예: 1, 100)에서 패턴이 정확히 맞는지
         * - 입력 트림/개행 이슈는 BufferedReader로 안전
         */        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String space = " ";
        String star = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(space.repeat(n - i - 1)).append(star.repeat(i + 1)).append('\n');
        }
        System.out.println(sb);
    }

}

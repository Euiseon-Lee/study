import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧾 BOJ 10798 - 세로읽기
         *
         * 🧠 핵심 아이디어
         * - 5개의 서로 다른 길이의 문자열을 char[][]에 저장한 뒤,
         *   열 인덱스 기준으로 위에서 아래로 순회하며 존재하는 문자만 읽는다.
         *
         * 🧱 로직 구조
         * 1) 입력 5줄을 읽어 arr[i] = line.toCharArray() 로 저장
         * 2) maxCol = 입력 행들 중 최장 길이
         * 3) for i=0..maxCol-1, for j=0..4:
         *    - if (i < arr[j].length) sb.append(arr[j][i])
         *
         * ⚙️ 성능 분석
         * - 시간복잡도: O(T) (T = 총 문자 수)
         * - 공간복잡도: O(T) (char[][] + StringBuilder)
         *
         * 🛠 보완 포인트
         * - 분기 단순화: if (i < len) sb.append(...) 형태로 continue/else 제거
         * - 미세 최적화: sb.capacity 초기화(대략 5*maxCol)로 리사이즈 횟수 축소
         * - 가독성: arr[j].length를 지역변수 len에 담아 중복 접근 감소
         *
         * ✅ 실무 수준 평가
         * - 경계 체크가 필요한 비정형 2차원 데이터 처리의 정석 패턴
         * - 단순·명확, 예외 케이스 안전 (Level 3)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][];
        int maxCol = 0;
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            arr[i] = line.toCharArray();
            maxCol = Math.max(maxCol, chars.length);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < 5; j++) {
                int len = arr[j].length;
                if (i < len) sb.append(arr[j][i]);
            }
        }
        System.out.println(sb.toString());
    }
}

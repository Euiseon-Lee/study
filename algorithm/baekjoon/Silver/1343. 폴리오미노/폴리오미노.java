import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 폴리오미노(BOJ 1343) – 연속 X 구간을 AAAA/BB로 타일링
         *
         * ✅ 문제 요약
         *  입력 문자열의 'X' 연속 구간을 길이 4는 "AAAA", 길이 2는 "BB"로 완전히 덮고
         *  하나라도 남는 'X'가 있으면 -1을 출력한다. '.'은 원형 보존.
         *
         * ✅ 기존 코드 요약
         *  "XXXX" → "AAAA" 전역 치환 후, "XX" → "BB" 전역 치환.
         *  이후 'X' 잔존 여부 검사로 유효성 판단.
         *
         * ✅ 개선 포인트
         *  1) 불필요 루프 제거: while+contains 대신 체인 치환 2회(O(n))로 충분.
         *  2) 상수명 명확화: fourWord/twoWord → POLY_A/POLY_B 등 도메인 반영.
         *  3) 단일 패스 대안: X run 길이를 누적해 4-분할 후 2-분할로 출력(규칙이 코드에 드러남).
         *
         * ✅ 성능 분석
         *  replace 전역 치환은 호출당 O(n). 체인 2회는 O(n) 선형.
         *  while/contains는 불필요 스캔을 추가할 수 있어 제거 권장.
         *
         * ✅ 실무 활용도
         *  - 치환 체인: 가장 간결하며 유지보수성 우수(의도 파악 쉬움).
         *  - 단일 패스: 타일링 규칙을 코드로 명시, 리뷰 시 오해 최소화.
         *  - 입력 규모가 커져도 두 방식 모두 선형 처리로 안정적.
         *
         * ✅ 예시/엣지
         *  "XXXXXX" → "AAAA"→"AAAABB" 최종 OK
         *  "X" 또는 홀수 길이 run 존재 → -1
         *  ".XX.XXXX." → ".BB.AAAA."
         *
         * ✅ 보안/안정성 관점
         *  - 입력 신뢰 전제(문자셋 제한: 'X','.')가 흔들리면 예외 처리 필요.
         *  - 규칙(4와 2 외 불가)을 코드에 명시하여 비인가 입력에도 일관된 실패(-1) 보장.
         */
        final String POLY_A = "AAAA";
        final String POLY_B = "BB";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s = s.replace("XXXX", POLY_A)
             .replace("XX", POLY_B);

        if (s.indexOf('X') >= 0) {
            System.out.println(-1);
        } else {
            System.out.println(s);
        }
    }
}


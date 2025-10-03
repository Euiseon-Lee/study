import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🎓 BOJ 25206 - 너의 평점은 (가중 평균, P 제외)
         *
         * 📌 문제 규칙
         * - 입력: 20개 과목 (과목명, 학점, 등급)
         * - 등급 가중치: A+=4.5, A0=4.0, B+=3.5, B0=3.0, C+=2.5, C0=2.0, D+=1.5, D0=1.0, F=0.0, P=제외
         * - 총점 = Σ(학점 * 가중치), 총학점 = Σ(학점) [단, P 제외], 결과 = 총점 / 총학점
         * - 총학점이 0이면 0.000000 출력, 아니면 소수점 6자리 반올림 출력
         *
         * 🧱 로직 개요
         * 1) 등급→가중치 맵 구성 (P 미포함)
         * 2) 20행을 파싱하면서 grade가 맵에 있으면:
         *    - totalCredits += credit
         *    - totalScore += credit * weight
         * 3) totalScore / totalCredits → 소수점 6자리 반올림 출력
         *
         * ⏱️ 복잡도
         * - 시간: O(1) (입력 고정 20행)
         * - 공간: O(1)
         *
         * ✅ BigDecimal 베스트 프랙티스
         * - 🔸 BigDecimal.valueOf(x) 사용:
         *   new BigDecimal(double)은 이진 부동소수 오차가 스며들 수 있어 지양.
         *   valueOf(double)은 내부적으로 안전한 변환을 제공(특히 상수/리터럴).
         * - 🔸 BigDecimal.ZERO / ONE / TEN 상수 사용:
         *   new BigDecimal(0) 대신 ZERO 사용으로 의도 명확 + 객체 재사용.
         * - 🔸 RoundingMode 사용:
         *   BigDecimal.ROUND_HALF_UP(Deprecated) 대신 RoundingMode.HALF_UP.
         * - 🔸 scale 고정:
         *   divide(..., 6, RoundingMode.HALF_UP)로 소수점 6자리 보장.
         *
         * 🧠 실무 관점
         * - P는 학점·총점 모두 제외, F는 0점이지만 학점은 포함.
         * - 입력이 고정 20행이라 라인 단위 파싱이 단순·안전(토큰 부족 예외 방지).
         * - 등급 맵은 불변 구조(Map.of)로 선언하면 사이드이펙트 예방 가능.
         */
        Map<String, BigDecimal> weight = Map.of(
            "A+", BigDecimal.valueOf(4.5), "A0", BigDecimal.valueOf(4.0),
            "B+", BigDecimal.valueOf(3.5), "B0", BigDecimal.valueOf(3.0),
            "C+", BigDecimal.valueOf(2.5), "C0", BigDecimal.valueOf(2.0),
            "D+", BigDecimal.valueOf(1.5), "D0", BigDecimal.valueOf(1.0),
            "F",  BigDecimal.valueOf(0.0)
        );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int read = 0;
        BigDecimal totalCredits = BigDecimal.ZERO;
        BigDecimal totalScore = BigDecimal.ZERO;
        while (read < 20) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                continue;
            }
            st.nextToken();
            BigDecimal credit = new BigDecimal(st.nextToken());
            String grade = st.nextToken();

            if (weight.containsKey(grade)) {
                totalCredits = totalCredits.add(credit);
                totalScore = totalScore.add(credit.multiply(weight.get(grade)));
            }
            read++;
        }
        if (totalCredits.compareTo(new BigDecimal(0)) == 0) {
            System.out.println("0.000000");
        } else {
            System.out.println(totalScore.divide(totalCredits, 6, RoundingMode.HALF_UP));
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
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
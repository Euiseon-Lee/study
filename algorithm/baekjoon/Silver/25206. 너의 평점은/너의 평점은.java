import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("A+", new BigDecimal(4.5));
        map.put("A0", new BigDecimal(4.0));
        map.put("B+", new BigDecimal(3.5));
        map.put("B0", new BigDecimal(3.0));
        map.put("C+", new BigDecimal(2.5));
        map.put("C0", new BigDecimal(2.0));
        map.put("D+", new BigDecimal(1.5));
        map.put("D0", new BigDecimal(1.0));
        map.put("F", new BigDecimal(0.0));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int read = 0;
        BigDecimal totalCredits = new BigDecimal(0);
        BigDecimal totalScore = new BigDecimal(0);
        while (read < 20) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                continue;
            }
            st.nextToken();
            BigDecimal credit = new BigDecimal(st.nextToken());
            String grade = st.nextToken();

            if (map.containsKey(grade)) {
                totalCredits = totalCredits.add(credit);
                totalScore = totalScore.add(credit.multiply(map.get(grade)));
            }
            read++;
        }
        if (totalCredits.compareTo(new BigDecimal(0)) == 0) {
            System.out.println("0.000000");
        } else {
            System.out.println(totalScore.divide(totalCredits, 6, BigDecimal.ROUND_HALF_UP));
        }
    }
}
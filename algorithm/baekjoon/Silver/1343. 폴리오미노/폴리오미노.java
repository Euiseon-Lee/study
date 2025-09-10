import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
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

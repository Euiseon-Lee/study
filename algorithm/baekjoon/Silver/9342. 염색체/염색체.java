import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String GOOD = "Good";
        final String INFECTED = "Infected!";
        String pattern = "[A-F]?A+F+C+[A-F]?$";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(br.readLine().matches(pattern) ? INFECTED : GOOD).append('\n');
        }
        System.out.println(sb.toString());
    }
}

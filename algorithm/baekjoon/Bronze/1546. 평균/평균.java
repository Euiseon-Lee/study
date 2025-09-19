import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] subjects = new double[n];
        double highestScore = 0.00;
        for (int i = 0; i < n; i++) {
            subjects[i] = Double.parseDouble(st.nextToken());
            if (subjects[i] > highestScore) {
                highestScore = subjects[i];
            }
        }
        final double P = 100.00;
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            total += subjects[i] / highestScore * P;
        }
        System.out.print(total / (double) n);
    }
}
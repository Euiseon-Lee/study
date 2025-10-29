import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int found = 0;
        int current = 665;
        while (found < n) {
            current++;
            if (Integer.toString(current).contains("666")) {
                found++;
            }
        }
        System.out.print(current);
    }
}
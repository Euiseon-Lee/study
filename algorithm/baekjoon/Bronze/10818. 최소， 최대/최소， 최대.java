import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numberArray = new int[n];
        for (int i = 0; i < n; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberArray);
        System.out.println(numberArray[0] + " " + numberArray[n - 1]);
    }
}

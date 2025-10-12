import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String result = String.valueOf(a * b * c);
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[10];
        for (int i = 0; i < result.length(); i++) {
            numbers[result.charAt(i) - '0']++;
        }
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append('\n');
        }
        System.out.print(sb);
    }
}
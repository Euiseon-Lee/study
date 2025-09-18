import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - 'a';
            if (alphabet[idx] == -1) alphabet[idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]);
            if (i < 25) sb.append(' ');
        }
        System.out.print(sb);
    }
}
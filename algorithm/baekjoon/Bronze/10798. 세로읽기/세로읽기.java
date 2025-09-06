import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][];
        int maxCol = 0;
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();
            arr[i] = chars;
            maxCol = Math.max(maxCol, chars.length);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j].length - 1 < i) {
                    continue;
                } else {
                    sb.append(arr[j][i]);
                }

            }
        }
        System.out.println(sb.toString());
    }
}
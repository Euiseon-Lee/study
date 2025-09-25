import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String star = "*";
        StringBuilder sb = new StringBuilder();
        sb.append(star).append('\n');
        for (int i = 1; i < n; i++) {
            sb.append(star.repeat(i + 1)).append('\n');
        }
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String space = " ";
        String star = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(space.repeat(n - i - 1)).append(star.repeat(i + 1)).append('\n');
        }
        System.out.println(sb);
    }
}
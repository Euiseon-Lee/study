import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (count++ < 9) {
            sb.append(n + " * " + count + " = " + (n * count) + "\n");
        }
        System.out.println(sb);
    }
}

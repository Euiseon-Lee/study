import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        a = ((a % 10) * 100) + (((a / 10) % 10) * 10) + (a / 100);
        b = ((b % 10) * 100) + (((b / 10) % 10) * 10) + (b / 100);
        System.out.println(Math.max(a, b));
    }
}
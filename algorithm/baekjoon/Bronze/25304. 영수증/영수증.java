import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paid = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int compare = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            compare += price * count;
        }
        System.out.println(paid == compare ? "Yes" : "No");
    }
}

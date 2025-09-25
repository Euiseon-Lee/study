import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        boolean ascending = false;
        boolean descending = false;
        boolean mixed = false;
        for (int i = 1; i < 8; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (current > prev) {
                ascending = true;
            } else if (current < prev) {
                descending = true;
            }
            if (ascending && descending) {
                mixed = true;
                break;
            }
            prev = current;
        }
        if (mixed) {
            System.out.print("mixed");
        } else {
            System.out.print(ascending ? "ascending" : "descending");
        }
    }
}
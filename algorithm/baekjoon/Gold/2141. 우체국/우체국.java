import java.io.*;
import java.util.*;

public class Main {
    static class Town implements Comparable<Town> {
        int x;
        long a;
        Town(int x, long a) { this.x = x; this.a = a; }
        public int compareTo(Town o) { return Integer.compare(this.x, o.x); }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Town[] towns = new Town[n];
        long totalTowners = 0L;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            towns[i] = new Town(x, a);
            totalTowners += a;
        }

        Arrays.sort(towns);
        long mid = (totalTowners + 1) / 2;
        long sum = 0L;
        int answer = towns[0].x;
        for (Town t : towns) {
            sum += t.a;
            if (sum >= mid) {
                answer = t.x;
                break;
            }
        }
        System.out.println(answer);
    }
}
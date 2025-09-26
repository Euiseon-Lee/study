import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dishes = Integer.parseInt(st.nextToken());
        int sushiTypes = Integer.parseInt(st.nextToken());
        int consecutiveDishes = Integer.parseInt(st.nextToken());
        int couponNumber = Integer.parseInt(st.nextToken());
        int[] sushi = new int[dishes];
        for (int i = 0; i < dishes; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int[] count = new int[sushiTypes + 1];
        int distinct = 0;
        for (int i = 0; i < consecutiveDishes; i++) {
            if (count[sushi[i]]++ == 0) distinct++;
        }
        int answer = distinct + (count[couponNumber] == 0 ? 1 : 0);
        for (int start = 1; start < dishes; start++) {
            int left = sushi[start - 1];
            if (--count[left] == 0) distinct--;

            int right = sushi[(start + consecutiveDishes - 1) % dishes];
            if (count[right]++ == 0) distinct++;

            int current = distinct + (count[couponNumber] == 0 ? 1 : 0);
            if (current > answer) answer = current;
        }
        System.out.print(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalDays = Integer.parseInt(st.nextToken());
        int checkDays = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[totalDays];
        for (int i = 0; i < totalDays; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
        long windowSum = 0;
        for (int i = 0; i < checkDays; i++) windowSum += visitors[i];

        long maxVisitors = windowSum;
        int maxCount = (maxVisitors > 0) ? 1 : 1; // 초기 윈도우도 1회로 카운트
        for (int i = checkDays; i < totalDays; i++) {
            windowSum += visitors[i] - visitors[i - checkDays];
            if (windowSum > maxVisitors) {
                maxVisitors = windowSum;
                maxCount = 1;
            } else if (windowSum == maxVisitors) {
                maxCount++;
            }
        }

        if (maxVisitors == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitors);
            System.out.println(maxCount);
        }
    }
}

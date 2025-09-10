import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final String fourWord = "AAAA";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalDays = Integer.parseInt(st.nextToken());
        int checkDays = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[totalDays];
        for (int i = 0; i < totalDays; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
        int startSum = 0;
        for (int i = 0; i < checkDays; i++) {
            startSum += visitors[i];
        }
        int maxVisitors = startSum;
        int sameVisitors = 1;
        int compareSum = startSum;
        for (int i = 1; i <= totalDays - checkDays; i++) {
            compareSum = compareSum - visitors[i - 1] + visitors[i + checkDays - 1];
            if (compareSum > maxVisitors) {
                maxVisitors = compareSum;
                sameVisitors = 1;
            } else if (compareSum == maxVisitors){
                sameVisitors++;
            }
            startSum = compareSum;
        }
        if (maxVisitors == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitors);
            System.out.println(sameVisitors);
        }
    }
}
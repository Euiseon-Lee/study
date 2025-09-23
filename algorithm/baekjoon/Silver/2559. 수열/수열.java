import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalDays = Integer.parseInt(st.nextToken());
        int consecutiveDays = Integer.parseInt(st.nextToken());
        int[] temperatures = new int[totalDays];
        st = new StringTokenizer(br.readLine());
        int sumTemperatures = 0;
        for (int i = 0; i < totalDays; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
            if (i < consecutiveDays) {
                sumTemperatures += temperatures[i];
            }
        }
        int maxTemperature = sumTemperatures;
        for (int i = consecutiveDays; i < totalDays; i++) {
            sumTemperatures = sumTemperatures - temperatures[i - consecutiveDays] + temperatures[i];
            if (maxTemperature < sumTemperatures) {
                maxTemperature = sumTemperatures;
            }
        }
        System.out.println(maxTemperature);
    }
}
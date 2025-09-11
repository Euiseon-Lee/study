import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine()) - 1;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long[] arrDistance = new long[cityCount];
        long[] arrOilPrice = new long[cityCount];
        long totalDistance = 0;
        for (int i = 0; i < cityCount; i++) {
            long tempDistance = Integer.parseInt(st1.nextToken());
            arrDistance[i] = tempDistance;
            totalDistance += tempDistance;
            arrOilPrice[i] = Integer.parseInt(st2.nextToken());
        }
        int idx = 0;
        long boughtDistance = arrDistance[0];
        long currentOilPrice = arrOilPrice[0];
        long boughtPrice = arrDistance[0] * currentOilPrice;
        while (boughtDistance != totalDistance) {
            if (currentOilPrice > arrOilPrice[++idx]) {
                currentOilPrice = arrOilPrice[idx];
            }
            boughtPrice += arrDistance[idx] * currentOilPrice;
            boughtDistance += arrDistance[idx];
        }
        System.out.println(boughtPrice);
    }
}
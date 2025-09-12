import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalMinutes = (Integer.parseInt(st.nextToken()) * 60) + Integer.parseInt(st.nextToken());
        totalMinutes += Integer.parseInt(br.readLine());
        int hour = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        System.out.println((hour > 23 ? hour - 24 : hour) + " " + minutes);
    }
}

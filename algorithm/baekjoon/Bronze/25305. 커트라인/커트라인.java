import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int cutline = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] scores = new int[total];
        for (int i = 0; i < total; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores);
        System.out.println(scores[total - cutline]);
    }
}
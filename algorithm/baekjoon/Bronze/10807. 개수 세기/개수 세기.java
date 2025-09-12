import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (temp == target) answer++;
        }
        System.out.println(answer);
    }
}

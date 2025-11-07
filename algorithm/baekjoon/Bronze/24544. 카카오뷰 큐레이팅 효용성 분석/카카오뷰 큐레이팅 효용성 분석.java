import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int unregistered = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int content = Integer.parseInt(st1.nextToken());
            boolean isRegistered = Integer.parseInt(st2.nextToken()) == 1;
            total += content;
            if (!isRegistered) unregistered += content;
        }
        System.out.println(total);
        System.out.print(unregistered);
    }

}

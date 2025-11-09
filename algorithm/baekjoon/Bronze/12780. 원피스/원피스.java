import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int count = 0;
        for (int i = 0; i < str.length() - target.length() + 1; i++) {
            String cut = str.substring(i, i + target.length());
            if (cut.contains(target)) count++;
        }
        System.out.print(count);
    }
}
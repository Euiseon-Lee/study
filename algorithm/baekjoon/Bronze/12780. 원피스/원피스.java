import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int count = 0;
        int start = 0;
        int position;

        while ((position = str.indexOf(target, start)) != -1) {
            count++;
            start = position + target.length();
        }
        System.out.print(count);
    }
}
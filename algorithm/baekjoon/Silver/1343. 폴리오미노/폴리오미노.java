import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final String fourWord = "AAAA";
        final String twoWord = "BB";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(str.contains("XXXX")) {
            str = str.replace("XXXX", fourWord);
        }
        while(str.contains("XX")) {
            str = str.replace("XX", twoWord);
        }

        if (str.contains("X")) {
            System.out.println(-1);
            return;
        }
        System.out.println(str);
    }
}
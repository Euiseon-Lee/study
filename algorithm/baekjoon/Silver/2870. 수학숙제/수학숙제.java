import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        Pattern digits = Pattern.compile("\\d+");
        ArrayList<BigInteger> list = new ArrayList<>();

        for (int i = 0; i < line; i++) {
            String s = br.readLine();
            Matcher m = digits.matcher(s);
            while (m.find()) {
                list.add(new BigInteger(m.group()));
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (BigInteger i : list) {
            sb.append(i.toString()).append("\n");
        } 
        System.out.println(sb.toString());
    }
}
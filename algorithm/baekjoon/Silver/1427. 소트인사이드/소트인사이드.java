import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] numbers = new int[10];
        for (int i = 0; i < num.length(); i++) {
            numbers[num.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            String number = String.valueOf(i);
            sb.append(number.repeat(numbers[i]));
        }
        System.out.println(sb);
    }
}
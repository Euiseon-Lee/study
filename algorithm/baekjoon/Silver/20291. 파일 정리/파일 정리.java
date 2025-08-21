import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine().split("\\.")[1]);
        }
        Collections.sort(arr);
        String str = arr.get(0);
        int count = 0;
        for (int i = 0; i < n; i++) {
            String temp = arr.get(i);
            if (str.equals(temp)) {
                count++;
            } else {
                System.out.println(str + " " + count);
                str = temp;
                count = 1;
            }

            if (i == n - 1) {
                System.out.println(str + " " + count);
            }
        }
    }
}
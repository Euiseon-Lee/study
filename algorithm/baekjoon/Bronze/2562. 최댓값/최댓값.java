import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        int index = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int target = Integer.parseInt(br.readLine());
            if (max < target) {
                max = target;
                index = i;
            }
        }
        System.out.println(max + "\n" + index);
    }
}
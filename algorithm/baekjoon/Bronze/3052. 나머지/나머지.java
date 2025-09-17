import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int devider = 42;
        boolean[] remainder = new boolean[devider];
        for (int i = 0; i < 10; i++) {
            remainder[Integer.parseInt(br.readLine()) % devider] = true;
        }
        int answer = 0;
        for (boolean i : remainder) {
            if (i) answer++;
        }
        System.out.println(answer);
    }

}

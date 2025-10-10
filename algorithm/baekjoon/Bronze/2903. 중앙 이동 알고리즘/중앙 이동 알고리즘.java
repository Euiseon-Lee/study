import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int side = (1 << n) + 1;   // 2^n + 1 을 비트 연산으로 계산
        System.out.println(side * side);
    }
}

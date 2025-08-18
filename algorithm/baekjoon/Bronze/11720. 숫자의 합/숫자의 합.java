import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] target = sc.next().split("");
        sc.close();
        for (int i = 0; i < count; i++) {
            answer += Integer.parseInt(target[i]);
        }
        System.out.println(answer);
    }
}
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Java에서는 문자열과 + 연산을 할 때 자동으로 String.valueOf()가 호출됨
        // System.out.println(a + " + " + b + " = " + (a + b));
        System.out.print(String.format("%d + %d = %d", a, b, a+b));
    }
}
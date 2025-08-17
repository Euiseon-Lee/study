import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        System.out.println(Integer.valueOf(strArr[0]) - Integer.valueOf(strArr[1]));
    }
}
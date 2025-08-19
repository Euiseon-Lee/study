import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        String[] target = sc.nextLine().split("\\*");

        for (int i = 0; i < count; i++) {
            String s = sc.nextLine();
            if (s.length() < target[0].length() + target[1].length()) {
                System.out.println("NE");
                continue;
            }

            if (s.startsWith(target[0]) && s.endsWith(target[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
        sc.close();
    }
}
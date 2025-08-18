import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            int[] alphabet = new int[26];
            String s = sc.nextLine().replace(" ", "");
            for (char c : s.toCharArray()) {
                alphabet[c - 'a']++;
            }

            int maxCount = 0;
            char maxChar = ' ';
            boolean isOnlyOne = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] > maxCount) {
                    maxCount = alphabet[j];
                    maxChar = (char) (j + 'a');
                    isOnlyOne = true;
                } else if (alphabet[j] == maxCount) {
                    maxChar = ' ';
                    isOnlyOne = false;
                }
            }
            System.out.println(isOnlyOne ? maxChar : '?');
        }
        sc.close();
    }
}
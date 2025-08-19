import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        sc.close();
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'A']++;
        }
        int maxCount = 0;
        char maxChar = ' ';
        boolean isOnlyOne = false;
        for (int j = 0; j < alphabet.length; j++) {
            if (alphabet[j] > maxCount) {
                maxCount = alphabet[j];
                maxChar = (char) (j + 'A');
                isOnlyOne = true;
            } else if (alphabet[j] == maxCount) {
                maxChar = ' ';
                isOnlyOne = false;
            }
        }
        System.out.println(isOnlyOne ? maxChar : '?');
    }
}
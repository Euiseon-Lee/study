import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (alphabet[idx] == -1) {
                alphabet[idx] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int a : alphabet) {
            sb.append(a).append(" ");
        }
        System.out.print(sb);
    }
}
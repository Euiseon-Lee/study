import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            int index = 0;
            while (index < str.length()) {
                if (index + 1 >= str.length() || index == str.length() - 1) {
                    break;
                }
                if (str.charAt(index) == '(' && str.charAt(index + 1) == ')') {
                    str.delete(index, index + 2);
                    if (index > 0) index--;
                } else {
                    index++;
                }
            }
            sb.append(str.length() == 0 ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
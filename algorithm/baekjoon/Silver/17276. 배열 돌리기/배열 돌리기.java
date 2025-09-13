import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, degree;
    static String[][] array, copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            degree = Integer.parseInt(st.nextToken());
            int k = ((degree % 360) + 360) % 360 / 45;
            array = new String[n][];
            for (int j = 0; j < n; j++) {
                array[j] = br.readLine().split(" ");
            }
            while(k-- > 0) rotateArray();
            for(String[] arr : array){
                for(String a : arr) {
                    sb.append(a + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void rotateArray() {
        copy = new String[n][];
        for (int r = 0; r < n; r++) {
            copy[r] = array[r].clone();
        }
        int mid = n / 2;
        for(int i = 0; i < n ; i++){
            array[i][mid] = copy[i][i];
            array[i][n - 1 - i] = copy[i][mid];
            array[mid][n - 1 - i] = copy[i][n - 1 - i];
            array[i][i] = copy[mid][i];
        }
    }
}
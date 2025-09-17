import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int greater =  a >= b ? a : b;
        int less = a >= b ? b : a;
        int temp = 0;
        while (greater % less != 0) {
            temp = greater % less;
            greater = less;
            less = temp;
        }
        System.out.println(less);
        System.out.println((a * b) / less);
    }
}
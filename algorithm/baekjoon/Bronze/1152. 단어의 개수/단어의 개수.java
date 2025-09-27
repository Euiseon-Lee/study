import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        if (str.equals("")) {
            System.out.print(0);
        } else {
            String[] arr = str.split(" ");
            System.out.print(arr.length);
        }
    }
}
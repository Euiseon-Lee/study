import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer st;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())); ;
        }
    }
}
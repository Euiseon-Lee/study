import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken().replace(":",""));
        int e = Integer.parseInt(st.nextToken().replace(":",""));
        int q = Integer.parseInt(st.nextToken().replace(":",""));
        String line;
        HashSet<String> set = new HashSet<>();
        int count = 0;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int time = Integer.parseInt(st.nextToken().replace(":",""));
            String name = st.nextToken();
            if (time <= s) set.add(name);
            if (time >= e && time <= q && set.contains(name)) {
                count++;
                set.remove(name);
            }
        }
        System.out.println(count);
    }
}
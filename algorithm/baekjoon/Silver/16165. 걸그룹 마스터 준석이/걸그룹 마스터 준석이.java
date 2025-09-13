import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int groupCount = Integer.parseInt(st.nextToken());
        int quizzes = Integer.parseInt(st.nextToken());
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < groupCount; i++) {
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                list.add(br.readLine());
            }
            map.put(group, list);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quizzes; i++) {
            String q =  br.readLine();
            boolean isMemberQuiz = br.readLine().equals("1") ? true : false;
            if (isMemberQuiz) {
                for (String group : map.keySet()) {
                    if (map.get(group).contains(q)) {
                        sb.append(group + "\n");
                        break;
                    }
                }
            } else {
                List<String> list = map.get(q);
                Collections.sort(list);
                for (String memberName : list) {
                    sb.append(memberName + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}
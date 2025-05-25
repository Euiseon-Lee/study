import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < my_string.length(); i++) {
            pq.add(my_string.substring(i));
        }
        String[] answer = new String[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}
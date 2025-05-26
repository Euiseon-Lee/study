import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for (String str : intStrs) {
            Integer target = Integer.parseInt(str.substring(s, s + l));
            if (target > k) list.add(target);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}
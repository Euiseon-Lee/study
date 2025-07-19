import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                map.put(rank[i], i);
            }
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        int multiply = 10000;
        for (int key : keySet) {
            answer += map.get(key) * multiply;
            multiply /= 100;
            if (multiply < 1) return answer;
        }
        return answer;
    }
}
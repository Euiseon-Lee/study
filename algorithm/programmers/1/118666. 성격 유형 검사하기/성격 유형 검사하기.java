import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        String[] types = {"RT", "CF", "JM", "AN"};
        Map <Character, Integer> map = new HashMap<>();
        for (int i = 0; i < choices.length; i++) {
            char cons = survey[i].charAt(0);
            char pros = survey[i].charAt(1);
            int score = choices[i];
            if (score < 4) {
                map.put(cons, map.getOrDefault(cons, 0) + 4 - score);
            } else if (score > 4) {
                map.put(pros, map.getOrDefault(pros, 0) + score - 4);
            }
            
        }
        
        for (String type : types) {
            char first = type.charAt(0);
            char second = type.charAt(1);
            
            answer.append(map.getOrDefault(first, 0) >= map.getOrDefault(second, 0) ? first : second);
        }
        
        return answer.toString();
    }
}
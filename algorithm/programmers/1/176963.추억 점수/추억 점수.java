import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scoreByName = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreByName.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String person : photo[i]) {
                score += scoreByName.getOrDefault(person, 0);
            }
            answer[i] = score;
        }
        return answer;
    }
}
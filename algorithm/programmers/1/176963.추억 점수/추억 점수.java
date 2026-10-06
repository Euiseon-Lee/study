import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int size = photo.length;
        int[] answer = new int[size];
        for (int i=0; i<size; i++) {
            String[] arr = photo[i];
            int score = 0;
            for (int j=0; j<arr.length; j++) {
                score += map.getOrDefault(arr[j], 0);
            }
            answer[i] = score;
        }
        return answer;
    }
}
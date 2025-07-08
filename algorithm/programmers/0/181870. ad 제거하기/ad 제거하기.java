import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                arr.add(i);
            }
        }
        String[] answer = new String[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = strArr[arr.get(i)];
        }
        return answer;
    }
}
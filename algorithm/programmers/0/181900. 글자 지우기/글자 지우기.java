import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder(my_string);
        Arrays.sort(indices);
        for(int i = 0; i < indices.length; i++) {
            answer.deleteCharAt(indices[i] - i);
        }
        return answer.toString();
    }
}
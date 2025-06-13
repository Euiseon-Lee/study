import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int[] preArr = Arrays.copyOfRange(num_list, n, num_list.length);
        for (int i = 0; i < preArr.length; i++) {
            answer[i] = preArr[i];
        }                     
        for (int i = preArr.length, j = 0; i < num_list.length; i++) {
            answer[i] = num_list[j++];
        }
        return answer;
    }
}
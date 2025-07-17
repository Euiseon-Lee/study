import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) answer[i] = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0, idx = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!set.contains(num)) {
                set.add(num);
                answer[idx++] = num;
                if (idx == k) break;
            }
        }
        return answer;
    }
}
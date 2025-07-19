import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0, idx = 0; i < arr.length; i++) {
            int target = arr[i];
            for (int j = 0; j < delete_list.length; j++) {
                if (delete_list[j] == target) break;
                if (j == delete_list.length - 1) list.add(target);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
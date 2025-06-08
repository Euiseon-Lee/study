import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int minIdx = 100001;
        int maxIdx = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 2){
                minIdx = Math.min(minIdx, i);
                maxIdx = Math.max(maxIdx, i);
            }
        }
        return maxIdx == -1 ? new int[] {-1} : Arrays.copyOfRange(arr, minIdx, maxIdx + 1);
    }
}
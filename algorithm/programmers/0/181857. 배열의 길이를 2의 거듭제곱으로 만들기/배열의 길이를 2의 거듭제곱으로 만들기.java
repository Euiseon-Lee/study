import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        String binary = Integer.toBinaryString(arr.length);
        boolean isComplete = true;
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                isComplete = false;
                break;
            }
        }    
        int length = (int) Math.pow(2, binary.length() - (isComplete ? 1 : 0));
        return Arrays.copyOf(arr, length);
    }
}
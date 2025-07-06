import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int[] standard = new int[arr.length];
        int answer = -1;
        while (!Arrays.equals(arr, standard)) {
            standard = Arrays.copyOf(arr, arr.length);
            answer++;
            for (int i = 0 ; i < arr.length; i++) {
                int num = arr[i];
                if (num > 50 && num % 2 == 0) {
                    arr[i] /= 2;
                } else if (num <= 50 && num % 2 == 1) {
                    arr[i] = (num * 2) + 1;
                } else {
                    continue;
                }
            }
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int[] standard = new int[num_list.length];
        Arrays.fill(standard, 1);
        while (!Arrays.equals(num_list, standard)) {
            for (int i = 0; i < num_list.length; i++) {
                int num = num_list[i];
                if (num > 1) {
                    num_list[i] = num % 2 == 0 ? num / 2 : (num - 1) / 2;
                    answer++;
                }
            }
        }
        return answer;
    }
}
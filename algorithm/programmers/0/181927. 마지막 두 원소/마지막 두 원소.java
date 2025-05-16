import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int newList[] = Arrays.copyOf(num_list, length+1);
        newList[length] = num_list[length-1] > num_list[length-2] ? num_list[length-1] - num_list[length-2] : 2 * num_list[length-1];
        return newList;
    }
}
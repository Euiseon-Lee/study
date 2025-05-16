class Solution {
    public int solution(int[] num_list) {
        int odd = 0, even = 0, oddDigit = 0, evenDigit = 0;
        for (int num : num_list) {
            if (num % 2 == 1) {
                odd = odd * 10;
                odd += num;
                oddDigit++;
            } else {
                even = even * 10;
                even += num;
                evenDigit++;
            }
        }
        return odd + even;
    }
}
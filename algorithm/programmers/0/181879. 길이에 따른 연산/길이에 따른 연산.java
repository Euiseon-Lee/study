class Solution {
    public int solution(int[] num_list) {
        boolean isMultiply = num_list.length < 11;
        int answer = num_list[0];
        for (int i = 1; i < num_list.length; i++) {
            answer = isMultiply ? answer * num_list[i] : answer + num_list[i];
        }
        return answer;
    }
}
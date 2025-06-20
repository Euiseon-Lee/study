class Solution {
    public int[] solution(int[] num_list, int n) {
        int length = (num_list.length / n) + (num_list.length % n == 0 ? 0 : 1);
        int[] answer = new int[length];
        for (int i = 0, idx = 0; i < length; i++) {
            answer[i] = num_list[idx];
            idx += n;
        }
        return answer;
    }
}
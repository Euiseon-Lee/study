class Solution {
    public int[] solution(int[] arr) {
        int size = 0;
        for (int num : arr) {
            size += num;
        }
        int[] answer = new int[size];
        for (int i = 0, idx = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = 0; j < num; j++) {
                answer[idx++] = num;
            }
        }
        return answer;
    }
}
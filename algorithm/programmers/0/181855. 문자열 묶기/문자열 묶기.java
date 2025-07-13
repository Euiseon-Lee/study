class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] arr = new int[31];
        for (String str : strArr) {
            int length = str.length();
            arr[length]++;
            answer = Math.max(answer, arr[length]);
        }
        return answer;
    }
}
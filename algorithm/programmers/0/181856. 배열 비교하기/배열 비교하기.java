class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return arr1.length - arr2.length > 0 ? 1 : -1;
        }
        int answer = 0;
        for(int i = 0; i < arr1.length; i++) {
            answer += (arr1[i] - arr2[i]);
        }
        return answer == 0 ? answer : (answer > 0) ? 1 : -1;
    }
}
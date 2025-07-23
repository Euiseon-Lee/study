class Solution {
    public int solution(int[][] arr) {
        int answer = 1;
        for (int i = 0; i <= arr.length / 2; i++) {
            for (int j = 0; j <= arr[i].length / 2; j++) {
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }
        return answer;
    }
}
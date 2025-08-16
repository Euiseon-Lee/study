class Solution {
    public int[][] solution(int n) {
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int num = 1;
        int[][] answer = new int[n][n];
        while (top <= bottom && left <= right) {
            for (int col=left; col<=right; col++) answer[top][col] = num++;
            top++;

            for (int row=top; row<=bottom; row++) answer[row][right] = num++;
            right--;

            for (int col=right; col>=left; col--) answer[bottom][col] = num++;
            bottom--;

            for (int row=bottom; row>=top; row--) answer[row][left] = num++;
            left++;
        }
        return answer;
    }
}
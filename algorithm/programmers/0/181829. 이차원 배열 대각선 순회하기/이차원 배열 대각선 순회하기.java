class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        int lengthX = k > board.length - 1 ? board.length - 1 : k;
        int lengthY = board[0].length - 1;
        for (int i = 0; i <= lengthX; i++) {
            int end = (k - i) > lengthY ? lengthY : (k - i);
            for (int j = 0; j <= end; j++) {
                answer += board[i][j];
            }   
        }
        return answer;
    }
}
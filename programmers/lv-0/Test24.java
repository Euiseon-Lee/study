class Solution {
    /*
      문제 설명
        지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
        지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
        지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.

        제한사항
        board는 n * n 배열입니다.
        1 ≤ n ≤ 100
        지뢰는 1로 표시되어 있습니다.
        board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
    */
    public int solution(int[][] board) {
        //처리 속도 0.02 ~ 0.04ms
        int n = board.length;
        int[][] copy = new int[n][n];

        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if (board[row][col]==1) {
                    destroy(col, row, n, copy);
                }

            }
        }

        int cnt = 0;
        for(int i=0; i<copy.length; i++) {
            for(int j=0; j<copy.length; j++) {
                if(copy[i][j]==0) {
                    cnt++;
                }
            }
        }

        return cnt;

    }

    private static void destroy(int col, int row, int n, int[][] copy) {
        for(int r=row-1; r<=row+1; r++) {
            if(r<0 || r>=n) {
                continue;
            } else {
                for(int c=col-1; c<=col+1; c++) {
                    if(c<0 || c>=n) {
                        continue;
                    } else {
                        copy[r][c] = 1;
                    }

                }
            }
        }
    }
}

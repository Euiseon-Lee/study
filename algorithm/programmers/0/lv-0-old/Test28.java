class Solution {
    /*
      문제 설명
        빨간색, 초록색, 파란색 선분이 x축 위에 있습니다. 
        세 선분의 x좌표 시작과 끝이 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 
        두 개 이상의 선분이 겹치는 부분의 길이를return 하도록 solution 함수를 완성해보세요.
        lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 2만큼 겹쳐있습니다.

      제한사항
        lines의 길이 = 3
        lines의 원소의 길이 = 2
        모든 선분은 길이가 1 이상입니다.
        lines의 원소는 [a, b] 형태이며, a, b는 각각 양 끝점 중 하나입니다.
        -100 ≤ a < b ≤ 100
    */
    public int solution(int[][] lines) {
        //처리 속도 0.04 ~ 0.07ms
        int answer = 0;

        int[] line0 = countLines(countDots(lines[0][0], lines[0][1]));
        int[] line1 = countLines(countDots(lines[1][0], lines[1][1]));
        int[] line2 = countLines(countDots(lines[2][0], lines[2][1]));

        for(int i=0; i<line0.length; i++) {
            if(line0[i]+line1[i]+line2[i]>1) {
                answer++;
            }
        }

        return answer;
    }

    public static int[] countDots(int start, int end) {

        int[] cntDots = new int[201];

        for(int i=start+100; i<=end+100; i++) {
            cntDots[i]++;
        }

        return cntDots;
    }


    public static int[] countLines(int[] cntDots) {

        int[] cntLines = new int[200];
        for(int i=1; i<cntDots.length; i++) {
            if(cntDots[i-1]==1 && cntDots[i]==1) {
                cntLines[i-1]++;
            }
        }
        return cntLines;
    }
}

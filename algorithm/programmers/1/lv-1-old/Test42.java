import java.util.ArrayList;
class Solution {
    /*
      문제
        수포자는 수학을 포기한 사람의 준말입니다. 
        수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
        수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
        가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.


      제한 사항
        시험은 최대 10,000 문제로 구성되어있습니다.
        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    */
    public int[] solution(int[] answers) {
        //처리 속도 0.04 ~ 0.98ms
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        for (int i=0; i<answers.length; i++) {
          if(student1[i%student1.length] == answers[i]) {
            scores[0]++;
          }
          if(student2[i%student2.length] == answers[i]) {
            scores[1]++;
          }
          if(student3[i%student3.length] == answers[i]) {
            scores[2]++;
          }
        }

        int highest = 0;
        for(int i=0; i<scores.length; i++) {
          highest = Math.max(scores[i], highest);
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<scores.length; i++) {
          if(scores[i]==highest) {
            arr.add(i+1);
          }
        }

        int[] scorers = new int[arr.size()];
        for(int i=0; i<scorers.length; i++) {
          scorers[i] = arr.get(i);
        }
        return scorers;
    }
}

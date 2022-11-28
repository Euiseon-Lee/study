class Solution {
    /*
      문제
        연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 
        두 정수 num과 total이 주어집니다. 
        연속된 수 num개를 더한 값이 total이 될 때, 
        정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.

      제한 사항
        1 ≤ num ≤ 100
        0 ≤ total ≤ 1000
        num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
    */
    public int[] solution(int num, int total) {
        // 처리 속도 0.15 ~ 1.60ms
        int avg = total / num;
        int standard = num / 2;
        int start = 0;
        if(total%num==0) {
            start = avg - (standard);
        } else {
            start = avg - (standard-1);
        }


//        int test = 0;
        int[] answer = new int[num];
        int index = 0;
        for (int i=start; i<start+num; i++) {
//            test += i;
            answer[index] = i;
            System.out.println(answer[index]);
            index++;
        }
        return answer;
    }
}

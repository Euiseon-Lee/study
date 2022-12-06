import java.util.*;

public class Solution {
    /*
      문제
        배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
        이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
        단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 
        예를 들면,
            arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
            arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
        배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.


      제한 사항
        return 값은 이진수를 의미하는 문자열입니다.
        1 ≤ bin1, bin2의 길이 ≤ 10
        bin1과 bin2는 0과 1로만 이루어져 있습니다.
        bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.
    */
    public int[] solution(int[] arr) {
        //처리 속도 0.15 ~ 50.62ms
        Stack<Integer> trans = new Stack<>();
        trans.push(arr[0]);
        for(int i=1; i<arr.length; i++) {
            Integer tmp = arr[i];
            Integer compare = trans.peek();
            if(compare == tmp) {
                continue;
            } else {
                trans.push(tmp);
            }
        }

        int[] answer = new int[trans.size()];
        int index = answer.length-1;
        while (!trans.isEmpty()) {
            answer[index] = trans.pop();
            index--;
        }
        return answer;
    }
}

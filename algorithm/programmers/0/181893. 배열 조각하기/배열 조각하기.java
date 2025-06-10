import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int n : arr) {
            temp.add(n);
        }
        for (int i = 0; i < query.length; i++) {
            start = (i % 2 == 0) ? 0 : query[i];
            end = (i % 2 == 0) ? query[i] : temp.size() - 1;
            temp = new ArrayList<>(temp.subList(start, end + 1));
        }
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}
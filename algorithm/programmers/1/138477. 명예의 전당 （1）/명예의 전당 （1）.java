import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> topList = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(i < k) {
                topList.add(score[i]);
            } else {
                if(score[i] >= topList.get(0)){
                    topList.remove(0);
                    topList.add(score[i]);
                }
            }
            Collections.sort(topList);
            answer[i] = topList.get(0); 
        }
        return answer;
    }
}
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < food.length; i++) {
            int f = food[i];
            if (f == 1) continue;
            for (int j = 0; j < f / 2; j++) {
                sb.append(i);
            }
        }
        answer = sb + "0" + sb.reverse();
        return answer;
    }
}
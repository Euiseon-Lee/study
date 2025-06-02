class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(int i = 0; i < my_string.length(); i++) {
            char temp = my_string.charAt(i);
            if (Character.isUpperCase(temp)) {
                answer[temp - 65]++;
            } else {
                answer[temp - 71]++;
            }
        }
        return answer;
    }
}
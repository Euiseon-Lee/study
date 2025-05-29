class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string);
        for (int i = s; i < e; i++) {
            char temp = answer.charAt(i);
            answer.setCharAt(i, answer.charAt(e));
            answer.setCharAt(e, temp);
            e--;
        }
        return answer.toString();
    }
}
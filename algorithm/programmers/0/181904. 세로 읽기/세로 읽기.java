class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0, start = 0; i < my_string.length() / m; i++) {
            String temp = my_string.substring(start, start + m);
            answer.append(temp.charAt(c - 1));
            start += m;
        }
        return answer.toString();
    }
}
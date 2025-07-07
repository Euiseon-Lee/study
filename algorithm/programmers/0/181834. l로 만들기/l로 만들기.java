class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        for (char c : myString.toCharArray()) {
            answer.append(c < 108 ? 108 : c);
        }
        return answer.toString();
    }
}
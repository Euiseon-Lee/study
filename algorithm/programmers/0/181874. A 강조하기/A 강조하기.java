class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        for (char c : myString.toCharArray()) {
            answer.append(Character.toString(c + (c > 65 && c < 97 ? 32 : 0)));
        }
        return answer.toString().replaceAll("a", "A");
    }
}
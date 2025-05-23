class Solution {
    public int solution(String number) {
        int answer = 0;
        if (number.length() > 11) {
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                answer += c - '0';
            }
            answer %= 9;
        } else {
             answer = (int) (Integer.parseInt(number) % 9);
        }
        return answer;
    }
}
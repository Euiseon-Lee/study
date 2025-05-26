class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        int prefixLength = is_prefix.length();
        if (my_string.length() >= prefixLength) {
            answer = my_string.substring(0, prefixLength).equals(is_prefix) ? 1 : 0;
        }
        return answer;
    }
}
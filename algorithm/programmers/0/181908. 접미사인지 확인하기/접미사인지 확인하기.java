class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        if (is_suffix.length() > my_string.length()) {
            return answer;
        }                           
        if (my_string.lastIndexOf(is_suffix) == (my_string.length() - is_suffix.length())) {
            answer = 1;
        }    
        return answer;
    }
}
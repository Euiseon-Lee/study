class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int strLength = pat.length();
        for (int i = 0; i <= myString.length() - strLength; i++) {
            if (myString.substring(i, strLength + i).contains(pat)) answer++;
        }
        return answer;
    }
}
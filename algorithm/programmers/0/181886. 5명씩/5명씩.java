class Solution {
    public String[] solution(String[] names) {
        int addLength = names.length % 5 == 0 ? 0 : 1;
        String[] answer = new String[(names.length / 5) + addLength];
        for (int i = 0, idx = 0; i < names.length; i += 5) {
            answer[idx++] = names[i];
        }
        return answer;
    }
}
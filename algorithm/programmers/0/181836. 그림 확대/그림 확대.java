class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for (int i = 0; i < picture.length; i++) {
            String target = picture[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                sb.append(Character.toString(c).repeat(k));
            }
            for (int j = 0; j < k; j++) {
                answer[i * k + j] = sb.toString();   
            }
        }
        return answer;
    }
}
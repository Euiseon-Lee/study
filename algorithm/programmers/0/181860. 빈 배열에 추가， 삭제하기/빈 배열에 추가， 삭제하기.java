class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (flag[i]) {
                sb.append(String.valueOf(num).repeat(num * 2));
            } else {
                sb.replace(sb.length() - num, sb.length(), "");
            }
        }
        int[] answer = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            answer[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        return answer;
    }
}
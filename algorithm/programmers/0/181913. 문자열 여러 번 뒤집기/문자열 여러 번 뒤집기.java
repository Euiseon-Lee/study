class Solution {
    public String solution(String my_string, int[][] queries) {
        String[] arr = my_string.split("");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            for (int j = 0; j < (e - s) / 2 + 1; j++) {
                String tmp = arr[s + j];
                arr[s + j] = arr[e - j];
                arr[e - j] = tmp;
            }
        }
        for (String s : arr) {
            answer.append(s);
        }
        return answer.toString();
    }
}
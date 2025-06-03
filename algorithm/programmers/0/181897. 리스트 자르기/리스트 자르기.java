class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int range = n == 1 ? b + 1 : n == 2 ? num_list.length - a : b - a + 1; 
        switch (n) {
            case 1: answer = new int[range];
                for (int i = 0; i < range; i++) {
                    answer[i] = num_list[i];
                }
                break;
            case 2: answer = new int[range];
                for (int i = a, idx = 0; i < num_list.length; i++) {
                    answer[idx++] = num_list[i];
                }
                break;
            case 3: answer = new int[range];
                for (int i = a, idx = 0; i < b + 1; i++) {
                    answer[idx++] = num_list[i];
                }
                break;
            case 4: answer = new int[range - (range / c)];
                for (int i = a, idx = 0; i < b + 1; i += c) {
                    answer[idx++] = num_list[i];
                }
                break;
        }        
        return answer;
    }
}
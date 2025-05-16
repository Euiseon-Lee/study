class Solution {
    public int solution(int[] num_list) {
        int multiply = 1;
        int squareBase = 0;
        
        for(int num : num_list) {
            multiply *= num;
            squareBase += num;
        }
        
        return multiply < (int) Math.pow(squareBase, 2) ? 1 : 0;
    }
}
class Solution {
    public int solution(int a, int b) {
        int digitA = (int) Math.pow(10, (int) Math.log10(Math.abs(a)) + 1);
        int digitB = (int) Math.pow(10, (int) Math.log10(Math.abs(b)) + 1);
        return Math.max((a * digitB) + b, (b * digitA) + a);
    }
}
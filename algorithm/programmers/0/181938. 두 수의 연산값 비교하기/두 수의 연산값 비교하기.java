class Solution {
    public int solution(int a, int b) {
        //int digitB = (int) Math.pow(10, (int) Math.log10(Math.abs(b) + 1));
        //return Math.max((a * digitB) + b, (2 * a * b));
        int append = Integer.parseInt("" + a + b);
        return Math.max(append, (2 * a * b));
    }
}
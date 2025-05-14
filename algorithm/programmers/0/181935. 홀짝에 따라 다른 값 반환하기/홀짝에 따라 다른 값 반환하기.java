class Solution {
    public int solution(int n) {
        if (n % 2 == 1) {
            return (int) Math.pow((1 + n) / 2, 2);
        } else {
            int target = 0;
            for (int i = 1; i < n/2 + 1; i++) {
                target += (int) Math.pow(2 * i, 2);
            }
            return target;
        }
    }
}
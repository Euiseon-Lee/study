class Solution {
    public int solution(int a, int b, int c) {
        if ((a - b == 0) && (b - c == 0)) {
            return 27 * (int) Math.pow(a, 6);
        } else if ((a != b) && (b != c) && (a != c)) {
            return a + b + c;
        } else {
            return (a + b + c) * ((a * a) + (b * b) + (c * c));
        }
    }
}
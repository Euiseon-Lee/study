class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        return (eq.equals("!") ? (ineq.equals(">") ? n > m : n < m) : (ineq.equals(">") ? n >= m : n <= m)) ? 1 : 0;
    }
}
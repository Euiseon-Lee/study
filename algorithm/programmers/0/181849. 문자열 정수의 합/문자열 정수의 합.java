import java.math.BigInteger;
class Solution {
    public int solution(String num_str) {
        int answer = 0;
        int digit = 0;
        BigInteger num = new BigInteger(num_str);
        BigInteger base = new BigInteger("10");
        while (digit < num_str.length()) {
            answer += num.remainder(base).intValue();
            num = num.divide(base);
            digit++;
        }
        return answer;
    }
}
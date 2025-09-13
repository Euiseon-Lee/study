class Solution {
    public int solution(int n, int k) {
        String[] transform = Integer.toString(n, k).replaceAll("[0]+", "0").split("0");
        int answer = 0;
        for (int i = 0; i < transform.length; i++) {
            long num = Long.parseLong(transform[i]);
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    public boolean isPrime (long n) {
        if (n <= 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
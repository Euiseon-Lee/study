class Solution {
    public int solution(int n) {
        boolean[] isComposite = new boolean[n + 1];

        for (int prime = 2; prime * prime <= n; prime++) {
            if (isComposite[prime]) {
                continue;
            }

            for (int multiple = prime * prime;
                 multiple <= n;
                 multiple += prime) {
                isComposite[multiple] = true;
            }
        }

        int count = 0;

        for (int num = 2; num <= n; num++) {
            if (!isComposite[num]) {
                count++;
            }
        }

        return count;
    }
}
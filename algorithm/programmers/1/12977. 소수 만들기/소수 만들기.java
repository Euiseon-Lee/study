class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        int idx = 0;

        for (int i = 0; i < length - 2; i++) {
            for (int k = i + 1; k < length - 1; k++) {
                for (int l = k + 1; l < length; l++) {
                    int sum = nums[i] + nums[k] + nums[l];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }        
        return answer;
    }
    public boolean isPrime (int target) {
        for(int j = 2 ; j <= Math.sqrt(target); j++) {
            if (target % j == 0) {
                return false;
            }
        }
        return true;
    }
}
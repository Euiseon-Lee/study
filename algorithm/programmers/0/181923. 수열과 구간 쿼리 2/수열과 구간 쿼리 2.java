class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int l = queries.length;
        int[] returnArr = new int[l];
        for (int i = 0; i < l; i++) {
            int min = queries[i][0];
            int max = queries[i][1];
            int standard = queries[i][2];
            int val = Integer.MAX_VALUE;
            for (int j = min; j <= max; j++) {
                int target = arr[j];
                if (target > standard) {
                    val = Math.min(val, target);
                }
            }
            returnArr[i] = val == Integer.MAX_VALUE ? -1 : val;
        }
        return returnArr;
    }
}
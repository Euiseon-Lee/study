import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        // 5 1 / 5 10 / 5 11 / 5 100 / 5 101 / 5 110 / 5 111 / 5 1000
        int binaryNum = 1;
        boolean continuing = true;
        ArrayList<Integer> tmpArr = new ArrayList<>();
        while(continuing) {
            Integer target = Integer.parseInt(Integer.toBinaryString(binaryNum)) * 5;
            if (target >= l && target <= r) {
                tmpArr.add(target);
                binaryNum++;
            } else if (target > r) {
                continuing = false;
                break; 
            } else {
                binaryNum++;
            }
        }
        
        if (tmpArr.size() == 0) {
            return new int[]{-1};
        } else {
            int[] returnArr = new int[tmpArr.size()];
            for(int i = 0; i < returnArr.length; i++) {
                returnArr[i] = tmpArr.get(i);
            }
            return returnArr;
        }
    }
}
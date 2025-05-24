import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        int last = 0;
        Stack<Integer> s = new Stack<>();
        while (i < arr.length) {
            if (s.size() == 0) {
                s.push(arr[i]);
                last = arr[i];
                i++;
            } else {
                if (last < arr[i]) {
                    s.push(arr[i]);
                    last = arr[i]; 
                    i++;
                } else {
                    s.pop();
                    if (s.size() > 0) {
                        last = s.peek(); 
                    }
                }
            }
        }

        Object[] objArray = s.toArray();
        int[] stk = new int[objArray.length];
        for (int j = 0; j < objArray.length; j++) {
            stk[j] = (Integer) objArray[j];
        }
        return stk;
    }
}
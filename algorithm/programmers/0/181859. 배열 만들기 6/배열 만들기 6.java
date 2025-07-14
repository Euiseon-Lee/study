import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> d = new LinkedList<>();
        d.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (d.isEmpty()) {
                d.addLast(arr[i]);
            } else {
                int last = (int) d.getLast();
                if (last == arr[i]) {
                    d.removeLast();
                } else {
                    d.addLast(arr[i]);
                }
            }
        }
        if (d.size() == 0) {
            return new int[]{-1};
        } else {
            int[] answer = new int[d.size()];
            Iterator<Integer> it = d.iterator();
            int i = 0;
            while(it.hasNext()) {
                int n = it.next();
                answer[i++] = n;
            }
            return answer;
        }
    }
}
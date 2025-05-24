import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;

        while (i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[i++]);
            } else if (stack.peek() < arr[i]) {
                stack.push(arr[i++]);
            } else {
                stack.pop();
            }
        }

        // ArrayDeque은 스택의 top이 앞에 있어서 역순 정렬 필요
        int[] stk = new int[stack.size()];
        int idx = stk.length - 1;
        while (!stack.isEmpty()) {
            stk[idx--] = stack.pop();
        }
        return stk;
    }
}

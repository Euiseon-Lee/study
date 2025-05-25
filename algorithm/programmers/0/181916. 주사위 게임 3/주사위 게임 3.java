import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = new int[]{a, b, c, d};
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < dice.length; i++) {
            if (m.containsKey(dice[i])) {
                m.put(dice[i], m.get(dice[i]) + 1);
            } else {
                m.put(dice[i], 1); 
            }
        }
        
        if (m.size() == 1) {
            return 1111 * a;
        } else if (m.size() == 4) {
            return Math.min(Math.min(a, b), Math.min(c, d));           
        } else if (m.size() == 2) {
            int p = 0;
            int q = 0;
            if (m.containsValue(3)) {
                for (Integer i : m.keySet()){
                    if (m.get(i) == 3) {
                        p = i;
                    } else {
                        q = i;
                    }
                }
                return (int) Math.pow(10 * p + q, 2);
            } else {
                int j = 0;
                for (Integer i : m.keySet()){
                    if (j == 0) {
                        p = i;
                        j++;
                    } else {
                        q = i;
                    }
                }
                return (p + q) * Math.abs(p - q);
            }
        } else {
            int q = 0;
            int r = 0;
            int j = 0;
            for (Integer i : m.keySet()){
                if (m.get(i) != 2) {
                    if (j == 0) {
                        q = i;
                        j++;
                    } else {
                        r = i;
                    }
                }
            }
            return q * r;
        }
    }
}
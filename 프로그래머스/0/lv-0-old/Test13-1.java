import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
class Solution {
    /*
      문제 설명
        소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다.
        예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다.
        따라서 12의 소인수는 2와 3입니다.
        자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

      제한사항
        2 ≤ n ≤ 10,000
    */
    public int[] solution(int n) {
      
        //처리속도 0.49 ~ 0.93ms
        Set<Integer> st = new TreeSet<Integer>();
        st.clear();
        int primefactor = 2;
        while (primefactor<=n) {
            if(n%primefactor==0) {
                st.add(Integer.valueOf(primefactor));
                n /= primefactor;
            } else {
                primefactor++;
            }
        }


        int[] arr = new int[st.size()];
        Iterator iter = st.iterator();
        for(int i =0; i<st.size(); i++) {
            if(iter.hasNext()) {
                arr[i] = (int) iter.next();
                System.out.println(arr[i]);
            }
        }
        
        return arr;
        
    }
}

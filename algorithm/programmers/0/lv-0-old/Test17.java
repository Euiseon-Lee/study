import java.util.ArrayList;
import java.util.Collections;
class Solution {
    /*
      문제 설명
        문자열 s가 매개변수로 주어집니다. 
        s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 
        한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.

      제한사항
        0 < s의 길이 < 1,000
        s는 소문자로만 이루어져 있습니다.
    */
    public String solution(String s) {
        //처리 속도 0.39 ~ 0.73ms
        StringBuffer sb = new StringBuffer();
        String[] trans = s.split("");
        ArrayList<String> arr = new ArrayList<>();
        for (int i=0; i<trans.length; i++) {
            if(!arr.contains(trans[i])) {
                arr.add(trans[i]);
            }
        }
//        arr.sort(Comparator.naturalOrder());
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++) {
            String tmp = arr.get(i);
            if(s.indexOf(tmp) == s.lastIndexOf(tmp)) {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}

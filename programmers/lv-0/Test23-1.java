import java.util.HashMap;
import java.util.Map;
class Solution {
    /*
      문제 설명
        3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다.
        3x 마을 사람들의 숫자는 다음과 같습니다.
        10진법      3x 마을에서 쓰는 숫자
        1     ->    1
        2	    ->    2
        3	    ->    4
        4	    ->    5
        5	    ->    7
        6     ->    8
        7	    ->    10
        8	    ->    11
        9	    ->    14
        10    ->    16
        
        정수 n이 매개변수로 주어질 때, 
        n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.
        제한사항
        1 ≤ n ≤ 100
    */
    public int solution(int n) {
        //처리 속도 0.05 ~ 4.45ms
        int cnt = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=1; i<=n; i++) {
             if (i%3!=0 && !String.valueOf(i).contains("3")) {
                 if (cnt%3!=0 && !String.valueOf(cnt).contains("3")) {
                     map.put(String.valueOf(i), cnt);
                     cnt++;
                 } else if (cnt%3==0 || String.valueOf(cnt).contains("3")) {
                     while (cnt%3==0 || String.valueOf(cnt).contains("3")) {
                         cnt++;
                     }
                     map.put(String.valueOf(i), cnt);
                     cnt++;
                 }
             } else if (i%3==0 || String.valueOf(i).contains("3")) {
                 if (cnt%3!=0 && !String.valueOf(cnt).contains("3")) {
                     map.put(String.valueOf(i), cnt);
                     cnt++;
                 } else if (cnt%3==0 || String.valueOf(cnt).contains("3")) {
                     while (cnt%3==0 || String.valueOf(cnt).contains("3")) {
                         cnt++;
                     }
                     map.put(String.valueOf(i), cnt);
                     cnt++;
                 }
             }
        }
        return map.get(String.valueOf(n)).intValue();
    }
}

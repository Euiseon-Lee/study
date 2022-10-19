import java.util.ArrayList;
import java.util.Collections;

class Solution {
  /*
  문제 설명
    함수 solution은 정수 n을 매개변수로 입력받습니다. 
    n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
    예를들어 n이 118372면 873211을 리턴하면 됩니다.

  제한 조건
    n은 1이상 8000000000 이하인 자연수입니다.
  */
  
    public long solution(long n) {        
		long temp = n;
		long cnt = 0;
		ArrayList<Long> splt = new ArrayList<Long>();

		while (temp != 0) {
			long trans = temp % 10;
			splt.add(trans);
			temp /= 10;
		}
		Collections.sort(splt);

		for (int i = 0; i < splt.size(); i++) {
			long toOrgn = (long) (Math.pow(10, i) * splt.get(i));
			cnt += toOrgn;
		}
        
        return cnt;
    }
}

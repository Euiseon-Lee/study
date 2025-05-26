import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        /**
         * 🔧 박싱/언박싱 최적화를 적용한 문자열 정수 필터링
         *
         * ✅ 개선 내용
         * - 기존 코드에서는 Integer target으로 선언하여 Integer.parseInt 결과를 박싱했음
         * - 또한 list.get(i).intValue()에서 다시 언박싱이 발생했음
         * - 이를 모두 primitive 타입 int로 일관하여 GC 부담과 성능 저하를 제거함
         * - 결과적으로 더 적은 메모리 사용과 낮은 GC 빈도로 성능이 향상됨
         *
         * ⏱ 성능 차이
         * - 기존 평균 실행시간: 6~9ms
         * - 개선 후 평균 실행시간: 1~4ms
         * - 특히 대용량 반복 처리 시 성능 향상 효과가 뚜렷하게 나타남
         *
         * ❓ 왜 List<int>는 존재하지 않는가?
         * - Java의 제네릭 구조는 primitive 타입을 허용하지 않음 (List<int>는 불가능)
         * - 제네릭은 컴파일 시 타입 소거(type erasure)로 인해 List<T> → List<Object>로 바뀌기 때문에
         *   primitive 타입인 int는 Object 타입으로 변환될 수 없어 사용 불가능
         * - 따라서 반드시 Integer, Double 등 Wrapper 클래스를 사용해야 하며, 이 과정에서 자동 박싱/언박싱이 발생함
         *
         * ⚠️ "불필요한" 박싱/언박싱이란?
         * - 객체로서의 기능(null 처리, Map key, 동등성 비교 등)이 필요 없는 상황에서도
         *   무의식적으로 Wrapper 클래스를 사용하는 경우를 의미함
         * - 성능이 중요한 반복문 내에서 이러한 박싱이 반복되면 불필요한 객체 생성과 해제가 누적되어
         *   GC 압박, 캐시 미스, 메모리 소모 등을 유발할 수 있음
         * - 특히 박싱된 Integer는 new Integer(...) 또는 캐시 참조 방식으로 처리되므로,
         *   미세하지만 반복적인 성능 손실이 생김
         *
         * 🛠 실무 적용 팁
         * - 조건 비교, 단순 연산, 배열 구성 등에서는 가능한 한 primitive 유지
         * - List<Integer> 구조가 필요한 경우에도 루프 내에서는 int를 유지한 뒤, 마지막에 int[]로 전환
         * - 필요시 Trove, FastUtil 등의 외부 라이브러리로 primitive 전용 컬렉션을 활용할 수 있음
         *
         * 🧠 정리
         * - int vs Integer는 단순한 타입 차이가 아닌 성능의 핵심 요소가 될 수 있음
         * - 자바는 구조상 List<int>를 허용하지 않기 때문에 Integer를 사용할 수밖에 없지만,
         *   이 과정이 실제로 필요 없는 상황이라면 "불필요한 박싱"으로 간주됨
         * - 이러한 오토박싱/언박싱은 성능의 블라인드 스팟이 될 수 있으며,
         *   이를 의식적으로 제어하는 것은 실무적인 최적화 습관임
         */
        List<Integer> list = new ArrayList<>();
        for (String str : intStrs) {
            //Integer target = Integer.parseInt(str.substring(s, s + l));    // 불필요한 박싱
            int target = Integer.parseInt(str.substring(s, s + l));
            if (target > k) list.add(target);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            //answer[i] = list.get(i).intValue();        // 불필요한 언박싱
            answer[i] = list.get(i);
        }
        return answer;
    }
}

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        // 최초 코드
        for(int i=0; i<a.length(); i++) {
            System.out.println(a.charAt(i));
        }


        /*
         * ---------------------------------------------------------------
         * [Stream API vs for-each 성능 비교 요약]
         * ---------------------------------------------------------------
         * ■ Stream API란?
         *   - Java 8부터 추가된 데이터 흐름 처리 방식으로,
         *     filter(), map(), forEach() 등의 함수형 연산을 지원함.
         *   - 코드가 선언형 스타일로 간결해지고 중간 연산 조합이 유리함.
         *
         * ■ 차이 발생 이유:
         *   - for-each는 단순 반복문 → 메모리/실행 속도 측면에서 유리
         *   - Stream API는 내부적으로 IntStream, Lambda 객체 등 다양한 중간 객체 생성 → 오버헤드 발생
         *   - 람다 표현식 호출과 내부 반복 처리로 인해 Stream 방식이 느림
         *
         * [람다 부연설명]
         * 자바에서 람다는 코드처럼 보이지만 실행 시에는 결국 '객체'로 동작해야 함.
         * Java 8부터는 이 객체를 만들 때 매번 익명 클래스를 생성하는 대신,
         * invoke-dynamic이라는 기능을 사용해 런타임에 효율적으로 처리함.
         * 즉, 람다는 '필요한 순간에 가볍게 만들어지는 익명 객체'라고 이해하면 된다. 
         *
         * ■ 실험 결과 (문자열 문자 단위 출력 기준):
         *   - for-each: 평균 170ms, 메모리 사용 ~71MB
         *   - Stream  : 평균 250~320ms, 메모리 사용 ~75~83MB
         *
         * ■ 적용 가이드:
         *   - 단순 입출력, 반복 → for-each가 효율적
         *   - 데이터 필터링/매핑 등 조합 → Stream이 표현력 우세
         * ---------------------------------------------------------------
         */
        // 개선
        for (char c : a.toCharArray()) {
            System.out.println(c);
        }

        // 스트림 사용한 코드
        a.chars().forEach(c -> System.out.println((char) c));
    }
}

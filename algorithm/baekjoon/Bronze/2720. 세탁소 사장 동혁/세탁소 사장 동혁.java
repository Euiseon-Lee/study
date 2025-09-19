import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 2720 – 세탁소 사장 동혁
         *
         * 🧠 문제 요약
         * - 미국 동전 단위: 쿼터(25), 다임(10), 니켈(5), 페니(1)
         * - 입력: 테스트케이스 수 n, 각 거스름돈 금액
         * - 출력: 각 금액을 동전 단위별 최소 개수로 분해
         *
         * ⚙️ 로직 구조
         * 1) 동전 단위를 큰 값부터 나열: {25,10,5,1}
         * 2) 각 거스름돈 change 에 대해:
         *    - change / coin → 해당 동전 개수
         *    - change %= coin → 남은 금액 갱신
         * 3) 모든 동전에 대해 반복 후 출력
         *
         * 🚀 성능
         * - 케이스당 동전 종류 4개만 확인 → O(1)
         * - 전체 O(n)
         * - 메모리 사용량도 극소 (정수 배열 4칸)
         *
         * 🔒 final static 사용 여부
         * - 현재 코드: 지역 변수 배열 (int[] coins = {25,10,5,1};)
         * - 실무에서 권장: `private static final int[] COINS = {25,10,5,1};`
         *   → 이유:
         *     1) final: "절대 값이 변하지 않는다"를 컴파일러와 협업자에게 보장
         *        - 실수로 coins[0]=30 같은 대입 시 컴파일 에러 발생
         *     2) static: 인스턴스와 무관하게 클래스 레벨에서 단 하나만 존재
         *        - 객체 생성 없이 사용 가능, 메모리 상에도 한 번만 로드됨
         *     3) 의미 전달: "이건 전역적이고 불변의 상수"라는 의도를 명확하게 드러냄
         * - 문제 풀이용: 지역 배열만으로 충분 (간단, 빠름)
         * - 실무/공용 코드: final static으로 선언하여 안정성 + 가독성 확보
         *
         * ✅ 정리
         * - 문제 풀이에서는 지금 코드가 이미 최적
         * - 실무에서는 final static 상수로 관리하는 습관이 유지보수성에 도움 됨
         * - 이 문제 자체는 Greedy 알고리즘의 전형적인 예시
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int[] coins = new int[]{25, 10, 5, 1};
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int change = Integer.parseInt(br.readLine());
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                sb.append(change / coin).append(' ');
                change %= coin;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}

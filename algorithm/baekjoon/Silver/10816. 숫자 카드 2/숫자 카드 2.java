import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 백준 10816 - 숫자 카드 2
         *
         * [로직 개요]
         * 1) 상근이 카드 입력 → HashMap<Integer,Integer>에 (숫자, 개수) 저장
         *    - cards.put(card, cards.getOrDefault(card, 0) + 1)
         * 2) 타겟 카드 입력 → cards.getOrDefault(target, 0) 으로 개수 조회
         * 3) StringBuilder에 이어붙여 한 번에 출력
         *
         * [성능 분석]
         * - 삽입: 평균 O(1) → N번 삽입 = O(N)
         * - 조회: 평균 O(1) → M번 조회 = O(M)
         * - 전체 복잡도: O(N + M)
         * - 메모리: HashMap 엔트리 최대 N개
         *
         * [실무 활용도]
         * - 빈도수 카운팅의 전형적 구현
         * - 로그 이벤트 집계, 사용자 행동 카운트, 에러 코드 분석 등에 직접 응용 가능
         *
         * [보완 포인트]
         * - HashMap 초기 용량 지정 시 대규모 입력에서도 안정적
         * - 출력 시 마지막 공백 제거 처리 가능
         *
         * ✅ 실무 수준 평가
         * - 불필요 분기 제거(getOrDefault 활용)로 가독성과 안정성 향상
         * - 알고리즘/구조적 설계 Level 3.5 → 성능/코드 균형 우수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCount; i++) {
            int card = Integer.parseInt(st.nextToken());
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        int targetCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < targetCount; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(cards.getOrDefault(target, 0)).append(" ");
        }
        System.out.println(sb);
    }
}


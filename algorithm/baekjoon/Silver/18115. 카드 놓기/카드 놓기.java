import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🎴 백준 18115 - 카드 놓기 (역시뮬레이션, Deque)
         *
         * 🧩 로직 구조
         * - 입력 기술을 배열에 "원래 순서"로 저장한 뒤, 뒤에서부터 읽으면서 덱을 구성한다.
         * - i = N-1..0, card = 1..N:
         *   1) t=1 → addFirst(card)
         *   2) t=2 → first=pollFirst(); addFirst(card); if(first!=null) addFirst(first)
         *   3) t=3 → addLast(card)
         *
         * ⚙️ 성능 분석
         * - 각 덱 연산 O(1) → 전체 O(N)
         * - 메모리 O(N)
         * - 입력 토큰 보강: while(!st.hasMoreTokens())로 줄바꿈 안전 처리
         *
         * 🧠 자료구조/설계 근거
         * - 덱은 양끝 삽입/삭제가 O(1)로 기술 1,2,3을 직접 표현하기에 최적
         * - “역시뮬레이션”을 코드 레벨에서 명확히 드러내기 위해 입력은 원본 순서 유지, 처리에서 역순 루프
         * - 배열을 역순으로 저장하는 방법과 성능은 동일하나, 본 방식이 경계 오류/인지 부담을 줄여 안전함
         *
         * 🛠 보완 포인트
         * - ArrayDeque 초기 용량 지정으로 리사이즈 억제
         * - case 2에서 예외 안전하게 pollFirst만 사용하여 분기 단순화
         * - 마지막 공백 제거는 선택 사항(정답 판정에는 영향 없음)
         *
         * ✅ 실무 활용도
         * - 로그 리플레이/역시뮬레이션, 이벤트 소싱의 리드모델 재구성 등에서 동일 패턴 적용 가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> cardStack = new ArrayDeque<>();
        int[] tech = new int[count];
        for (int i = 0; i < count; i++) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            tech[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = count - 1, card = 1; i >= 0; i--, card++) {
            int t = tech[i];
            switch (t) {
                case 1:
                    cardStack.addFirst(card);
                    break;
                case 2:
                    if (cardStack.isEmpty()) {
                        cardStack.addFirst(card);
                    } else {
                        Integer first = cardStack.pollFirst();
                        cardStack.addFirst(card);
                        cardStack.addFirst(first);
                    }
                    break;
                case 3:
                    cardStack.addLast(card);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int card : cardStack) {
            sb.append(card).append(" ");
        }
        System.out.println(sb.toString());
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 백준 2164 - 카드2
         *
         * [로직 개요]
         * 1) 1..N까지 카드를 Deque에 삽입
         * 2) 카드가 1장 남을 때까지:
         *    - removeFirst(): 맨 위 카드 버림
         *    - pollFirst() + addLast(): 다음 카드를 맨 아래로 이동
         * 3) 마지막 남은 카드 출력
         *
         * [성능 분석]
         * - Deque 연산: O(1)
         * - 전체 반복: O(N)
         * - 메모리: O(N) (카드 저장)
         *
         * [실무 활용도]
         * - 큐 기반 시뮬레이션
         * - 라운드 로빈 스케줄링, 이벤트 큐, 버퍼 처리 로직과 유사
         *
         * [보완 포인트]
         * - Deque 선언 시 제네릭 명시: Deque<Integer> cardStack = new ArrayDeque<>();
         * - removeFirst() → pollFirst() 통일 가능 (예외 vs null 반환 차이 고려)
         * - 출력 최적화: 마지막 peek() 대신 pollFirst()로 일관된 연산 유지 가능
         *
         * ✅ 실무 수준 평가
         * - 큐 시뮬레이션 문제의 정석 풀이
         * - 자료구조 선택 합리적, 시간/공간 복잡도 최적 (Level 3)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lastCard = Integer.parseInt(br.readLine());
        Deque<Integer> cardStack = new ArrayDeque<>();
        for (int i = 1; i <= lastCard; i++) {
            cardStack.addLast(i);
        }

        while (cardStack.size() != 1) {
            cardStack.removeFirst();
            Integer card = cardStack.pollFirst();
            cardStack.addLast(card);
        }
        System.out.println(cardStack.peek());
    }

}

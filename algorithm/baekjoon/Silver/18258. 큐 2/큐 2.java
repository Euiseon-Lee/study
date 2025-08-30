import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧵 StringTokenizer & 🧺 Deque(ArrayDeque) 사용 가이드
         *
         * [🧵 StringTokenizer]
         * - 목적: 구분자(delimiter) 기준으로 문자열을 빠르게 토큰화
         * - 기본 구분자: 공백류(스페이스, 탭, 개행). new StringTokenizer(line)는 공백 기준 분리
         * - 핵심 메서드:
         *   * hasMoreTokens(): 남은 토큰 존재 여부 확인
         *   * nextToken(): 다음 토큰 반환 (없으면 NoSuchElementException)
         *   * nextToken(String delim): 런타임에 구분자 변경
         *   * countTokens(): 남은 토큰 개수(탐색과정에서 값이 변동될 수 있음)
         * - 특징/주의:
         *   * 연속 구분자 사이의 빈 토큰은 만들지 않음(빈 토큰이 필요하면 String.split 사용)
         *   * 정규식이 아닌 단순 문자 기준 분리 → split보다 오버헤드가 작아 대용량 입력에 유리
         *   * Scanner는 편리하지만 느린 편. 고성능 I/O에는 BufferedReader + StringTokenizer 권장
         *   * 사용 패턴(예): 
         *     StringTokenizer st = new StringTokenizer(line);
         *     String cmd = st.nextToken();
         *     if ("push".equals(cmd)) { int x = Integer.parseInt(st.nextToken()); }
         *
         * [🧺 Deque 인터페이스 개요]
         * - Deque(Double-Ended Queue): 양 끝(Front/Back)에서 삽입/삭제 가능
         * - ArrayDeque: 배열 기반 구현(가변 용량, null 원소 허용 X, 스레드-세이프 X)
         * - 시간 복잡도(평균): 양 끝 삽입/삭제/조회 O(1)
         *
         * [🧰 메서드 동작 차이 – 예외 vs null 반환]
         * - 삽입(뒤):
         *   * addLast(E e): 실패 시 예외(일반적으로 ArrayDeque는 실패 없음)
         *   * offerLast(E e): 실패 시 false (예외보다 안전한 반환형)
         * - 삽입(앞): addFirst / offerFirst 동일 패턴
         *
         * - 삭제(앞):
         *   * removeFirst(): 비어 있으면 NoSuchElementException
         *   * pollFirst():  비어 있으면 null 반환
         * - 삭제(뒤): removeLast / pollLast 동일 패턴
         *
         * - 조회(앞):
         *   * getFirst(): 비어 있으면 NoSuchElementException
         *   * peekFirst(): 비어 있으면 null 반환
         * - 조회(뒤): getLast / peekLast 동일 패턴
         *
         * - 스택 별칭:
         *   * push(e) == addFirst(e)
         *   * pop()   == removeFirst()
         *
         * [🛡️ 예외 안전 패턴]
         * - 빈 컨테이너 접근 시:
         *   * 삭제/조회: poll*/peek* 사용 → null 체크로 안전 처리(-1 출력 등)
         *   * get*/remove* 사용 시 빈 컨테이너에서 예외 발생
         *
         * [⚙️ 성능/메모리 포인트]
         * - ArrayDeque는 LinkedList 대비 노드 오브젝트 오버헤드가 없어 일반적으로 캐시 친화적
         * - null 원소 금지: offer/add에 null 전달 시 NullPointerException
         * - 스레드-세이프 아님: 멀티스레드 공유 시 외부 동기화 필요
         *
         * [🧩 큐 문제 적용 요령]
         * - push:  offerLast(x)  // 실패 시 false, 예외 대신 반환값으로 안전
         * - pop:   pollFirst()   // null이면 비어 있음 → -1 출력
         * - front: peekFirst()   // null이면 -1
         * - back:  peekLast()    // null이면 -1
         * - size:  size()
         * - empty: isEmpty() ? 1 : 0
         *
         * [🚩 흔한 실수]
         * - poll/peek를 한 분기에서 여러 번 호출 → 서로 다른 결과가 나와 로직 꼬임 (반드시 변수에 담아 1회 사용)
         * - getFirst/getLast로 비어 있는 큐 조회 → NoSuchElementException
         * - nextToken()를 hasMoreTokens() 확인 없이 호출 → NoSuchElementException
         *
         *
         * ✅ 큐 명령 처리 – 예외 안전 + I/O 최적화 포인트
         *
         * 🧩 핵심 구조
         * - 자료구조: ArrayDeque<Integer> (head/tail O(1))
         * - push : offerLast(x)  → 실패 시 false, 예외 발생 X
         * - pop  : pollFirst()   → null이면 -1
         * - front: peekFirst()   → null이면 -1
         * - back : peekLast()    → null이면 -1
         * - size : size()
         * - empty: isEmpty() ? 1 : 0
         *
         * 🛡️ 예외 안전성
         * - getFirst/getLast/removeFirst는 빈 큐에서 NoSuchElementException
         * - peek*/poll* 계열은 빈 큐에서도 null 반환 → 안전한 분기 가능
         *
         * ⚙️ 성능 포인트
         * - 각 연산 평균 O(1), N ≤ 2,000,000에서도 안정
         * - 출력은 StringBuilder에 누적 후 1회 print (I/O 병목 최소화)
         * - 토큰 파싱 비용 절감: 명령은 charAt(0)으로 분기, push만 숫자 파싱
         *
         * 🧪 주의/함정
         * - poll/peek를 중복 호출하지 말 것 (한 번 호출 후 변수에 담아 사용)
         * - 입력 라인 끝의 공백/빈 라인 방어: 필요 시 null/빈문자열 체크
         *
         * 🔧 선택적 확장
         * - 초극단 성능 요구 시 int[] 원형 버퍼로 직접 큐 구현 (오토박싱 제거)
         * - BufferedWriter로 출력 또는 System.out의 print 사용은 현재 구조로 충분
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int commandCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": queue.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop": Integer pop = queue.pollFirst();
                            sb.append(pop == null ? -1 : pop).append('\n');
                    break;
                case "size": sb.append(queue.size()).append('\n');
                    break;
                case "empty": sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front": Integer front = queue.peekFirst();
                            sb.append(front == null ? -1 : front).append('\n');
                    break;
                case "back": Integer back = queue.peekLast();
                            sb.append(back == null ? -1 : back).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }

}

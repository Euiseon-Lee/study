import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {/**
        /**
         * 💥 BOJ 11279 최대 힙 – PriorityQueue 기반 O(log N) 삽입/삭제
         *
         * 💡 로직 구조
         * - 입력된 정수 x에 대해:
         *   • x == 0 → 현재 최대값 출력 (없으면 0)
         *   • x != 0 → 최대 힙에 삽입
         * - PriorityQueue를 Collections.reverseOrder()로 생성해 최대 힙으로 활용
         *
         * ⏱️ 복잡도
         * - add(), poll(): O(log N)
         * - 전체: O(N log N)
         * - I/O: BufferedReader + StringBuilder로 버퍼링 출력
         *
         * ✅ 구현 포인트
         * - reverseOrder() Comparator로 최대 힙 변환
         * - queue.isEmpty()로 안전한 비어 있음 체크
         * - poll()은 비어 있으면 null 반환 → 삼항 연산자로 0 처리
         *
         * 🛠️ 보완 포인트
         * 1) 변수명 queue → maxHeap (의도 명시)
         * 2) size() == 0 → isEmpty() 사용
         * 3) Comparator 명시 버전: new PriorityQueue<>((a,b)->b-a)
         *
         * 🧩 실무 응용
         * - 우선순위 작업 스케줄링, 이벤트 타임라인 관리, 실시간 최대값/최소값 유지
         * - 동적 정렬이 필요할 때 배열 정렬보다 효율적 (특히 삽입·삭제 빈번한 경우)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(maxHeap.isEmpty() ? 0 : maxHeap.poll()).append('\n');
            } else {
                maxHeap.add(x);
            }
        }
        System.out.print(sb);
    }
}


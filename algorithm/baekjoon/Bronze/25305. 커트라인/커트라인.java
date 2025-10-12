import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🏆 BOJ 25305 - 커트라인
         *
         * 📌 문제 요약
         * - 총 N명의 학생 점수가 주어짐
         * - 상을 받는 인원 K명 중 가장 낮은 점수(=K번째 높은 점수)를 출력
         *
         * 🧱 로직 구조
         * 1) 점수 배열 입력
         * 2) Arrays.sort()로 오름차순 정렬
         * 3) 뒤에서 K번째 요소(scores[N - K]) 출력
         *
         * ⏱️ 복잡도
         * - 시간: O(N log N)
         * - 공간: O(N)
         *
         * ✅ 장점
         * - 코드 구조가 문제 설명과 1:1로 대응 → 가독성 높음
         * - Arrays.sort()는 Dual-Pivot QuickSort로 최적화
         * - 작은 입력(N ≤ 1000)에서 가장 안정적이고 실용적인 방식
         *
         * ⚙️ 확장 아이디어
         * - N이 매우 큰 경우 (예: 10^6 이상) → PriorityQueue로 O(N log K) 최적화 가능
         * - 하지만 현재 조건에서는 정렬이 가장 간단하고 빠름
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int cutline = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] scores = new int[total];
        for (int i = 0; i < total; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores);
        System.out.println(scores[total - cutline]);
    }

}

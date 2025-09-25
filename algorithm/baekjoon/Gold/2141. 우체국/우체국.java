import java.io.*;
import java.util.*;

public class Main {
    /**
     * 🧮 BOJ 2141 - 우체국 (가중 중앙값)
     *
     * 📌 문제 핵심
     * - 비용: Σ |x - x_i| * a_i (절댓값 거리의 가중합)
     * - 1차원에서 이 비용을 최소화하는 x는 "가중 중앙값"
     *
     * 🧱 로직 개요
     * 1) (x_i, a_i) 를 x 오름차순으로 정렬
     * 2) total = Σ a_i, mid = (total + 1) / 2
     * 3) 왼쪽부터 누적 sum += a_i
     * 4) sum >= mid 를 최초로 만족하는 위치 x_i 가 정답
     *
     * ⏱️ 복잡도
     * - 정렬 O(N log N) + 1패스 O(N) = 전체 O(N log N)
     * - 공간 O(N), 누적/합계는 long 사용 (오버플로 방지)
     *
     * ✅ 장점
     * - 가중 중앙값 정리에 근거한 정답 로직 → 반례에 강함
     * - 단순하고 확장 가능한 구조 (입력 파싱/정렬/스캔 분리)
     *
     * ⚠️ 주의/보완 포인트
     * - a_i, total, sum, mid는 long 유지
     * - 동일 위치 다중 마을이 있어도 누적 기준이므로 정상 동작
     * - x 범위는 int로 충분하나, 필요 시 long x 도 무해
     *
     * 🧠 직관 힌트
     * - x를 오른쪽으로 이동하면 왼쪽 인구수만큼 비용 증가, 오른쪽 인구수만큼 비용 감소
     * - 왼쪽 누적 인구 ≥ 오른쪽 누적 인구가 되는 첫 지점이 최소점 → 가중 중앙값
     */
    static class Town implements Comparable<Town> {
        int x;
        long a;
        Town(int x, long a) { this.x = x; this.a = a; }
        public int compareTo(Town o) { return Integer.compare(this.x, o.x); }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Town[] towns = new Town[n];
        long totalTowners = 0L;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            towns[i] = new Town(x, a);
            totalTowners += a;
        }

        Arrays.sort(towns);
        long mid = (totalTowners + 1) / 2;
        long sum = 0L;
        int answer = towns[0].x;
        for (Town t : towns) {
            sum += t.a;
            if (sum >= mid) {
                answer = t.x;
                break;
            }
        }
        System.out.println(answer);
    }

}

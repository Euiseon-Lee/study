import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 🍣 BOJ 2531 - 회전 초밥 (슬라이딩 윈도우 + 원형 처리 + 쿠폰)
         *
         * 📌 문제 요약
         * - 원형 벨트 위 N개의 접시, 각 접시는 1..d 사이의 초밥 종류를 가짐.
         * - 연속된 k개를 선택할 때 먹을 수 있는 "서로 다른 초밥 종류"의 최댓값을 구한다.
         * - 쿠폰 번호 c의 초밥이 현재 구간에 없다면 +1 보너스를 적용할 수 있다.
         *
         * 🧱 핵심 로직
         * 1) 초기 윈도우 [0..k-1]에 대해 count[type]을 채우고 distinct(서로 다른 종류 수) 계산
         * 2) 시작 인덱스를 1..N-1로 한 칸씩 이동 (원형 처리: 우측 인덱스는 (start + k - 1) % N)
         *    - remove: left = sushi[start - 1]
         *        if (--count[left] == 0) distinct--
         *    - add   : right = sushi[(start + k - 1) % N]
         *        if (count[right]++ == 0) distinct++
         * 3) 쿠폰 적용: count[c] == 0 이면 distinct + 1, 아니면 distinct 그대로 → 최대값 갱신
         *
         * 🧮 자료구조 선택
         * - int[] count (크기 d+1, 1-based 인덱싱): 종류당 빈도 테이블 → 조회/증감 O(1)
         * - int[] sushi : 원형 벨트를 배열로 보관, 인덱스는 모듈로 연산으로 순환
         *
         * ⏱️ 복잡도
         * - 시간: 초기 O(k) + 슬라이딩 N회 × O(1) = O(N)
         * - 공간: O(d) (count 배열), O(N) (입력 보관)
         *
         * ✅ 장점
         * - 매 이동 시 빠진/들어온 항목만 반영 → 불필요한 재계산 제거
         * - 쿠폰 검사 count[c] == 0 로 즉시 판단 → 조건 분기 단순
         * - 원형은 모듈로 1회 연산으로 해결 → 2N 확장 대비 메모리 절약
         *
         * ⚠️ 주의/엣지 케이스
         * - k == N 인 경우에도 동일 로직으로 안전 (left와 right가 같을 수 있으나 순서대로 감소→증가하면 최종 상태가 유지됨)
         * - ans의 이론적 상한은 min(k+1, d) 이므로 ans가 k+1에 도달하면 더 이상 증가 불가 (조기 종료 가능)
         * - 입력 초밥 번호는 1..d를 가정, count 크기는 d+1로 생성하여 인덱스 안전 확보
         *
         * 🧠 성능 팁
         * - count/right/left 갱신은 분기(==0)에서만 distinct 증감을 수행해 분기 비용을 최소화
         * - I/O 최적화는 BufferedReader로 충분, 대량 출력이 없으므로 StringBuilder 불필요
         *
         * 🛠 테스트 체크리스트
         * - 모든 접시가 동일 (distinct=1, 쿠폰이 같으면 그대로, 다르면 +1)
         * - 쿠폰이 항상 포함되는 경우/절대 포함되지 않는 경우
         * - k=1, k=N, d<k, d>=k 등 파라미터 경계
         * - 원형 wrap-around 구간(우측 인덱스가 0으로 돌아가는 시점)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dishes = Integer.parseInt(st.nextToken());
        int sushiTypes = Integer.parseInt(st.nextToken());
        int consecutiveDishes = Integer.parseInt(st.nextToken());
        int couponNumber = Integer.parseInt(st.nextToken());
        int[] sushi = new int[dishes];
        for (int i = 0; i < dishes; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int[] count = new int[sushiTypes + 1];
        int distinct = 0;
        for (int i = 0; i < consecutiveDishes; i++) {
            if (count[sushi[i]]++ == 0) distinct++;
        }
        int answer = distinct + (count[couponNumber] == 0 ? 1 : 0);
        for (int start = 1; start < dishes; start++) {
            int left = sushi[start - 1];
            if (--count[left] == 0) distinct--;

            int right = sushi[(start + consecutiveDishes - 1) % dishes];
            if (count[right]++ == 0) distinct++;

            int current = distinct + (count[couponNumber] == 0 ? 1 : 0);
            if (current > answer) answer = current;
        }
        System.out.print(answer);
    }

}

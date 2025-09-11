import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * ⛽ BOJ 13305 – 주유소 (Greedy: 최소 단가 유지)
         *
         * ✅ 문제 요약
         *  - N개 도시, N-1개 도로 길이와 각 도시의 리터당 가격이 주어진다.
         *  - i번째 도로(도시 i→i+1)는 도시 i에서 산 기름으로 달린다.
         *  - 전체 이동 비용의 최솟값을 구한다.
         *
         * ✅ 내 코드 요약
         *  - 거리/가격을 배열에 담고, 초기 구간(0) 비용을 먼저 누적.
         *  - while 루프에서 다음 도시 가격이 더 싸면 현재 단가를 갱신한 뒤, 해당 구간 비용을 누적.
         *  - 누적 이동 거리 == 전체 거리일 때 종료, 총 비용 출력.
         *
         * ✅ 그리디 불변식
         *  - "지금까지 만난 최소 가격(minPrice)으로 다음 도로 길이(dist[i])만큼 산다."
         *  - minPrice는 좌→우로 진행하며 비 non-increasing(갱신 시 더 작아짐).
         *
         * 🔧 보완 포인트
         *  1) 루프 경계 단순화
         *     - while(boughtDistance != totalDistance) + arrOilPrice[++idx] 대신
         *       for (i = 0..N-2) 한 번씩만 처리 → 인덱스 경계 명확, 프리인크리먼트 리스크 제거.
         *  2) 형 안전성
         *     - 거리/가격 파싱은 Long.parseLong 사용, 누적(cost)은 long 유지.
         *  3) 자료구조 최소화
         *     - 가격 배열 없이 minPrice만 유지. 거리 배열만 있으면 충분.
         *  4) 계산 순서 일관
         *     - "현재 minPrice로 dist[i] 비용 누적 → 다음 가격(nextPrice)로 minPrice 갱신" 패턴 통일.
         *  5) 명명 개선
         * 🏷 Java 네이밍 미니 가이드
         *
         * ✅ 원칙: 타입 접두어(arr/str/i64) 금지, 의미/단위/범위를 이름에 담기
         * ✅ 컬렉션: 복수형 (users, roadDistancesKm), Map은 By키 (ordersByUserId)
         * ✅ 불린: is/has/can/should 접두, 상수: UPPER_SNAKE_CASE
         * ✅ 예시 변환
         *  - cityCount → numCities
         *  - arrDistance → roadDistancesKm
         *  - arrOilPrice → pricePerLiterByCity
         *  - boughtPrice → totalCostWon
         *  - currentOilPrice → minPriceSoFar
         *
         * ⚙️ 성능 분석
         *  - 선형 1패스: 시간 O(N), 메모리 O(N) (거리 저장), 가격 배열 생략 시 O(1) 추가.
         *  - 곱셈/덧셈만 수행하여 대입 비용이 작고 브랜치 예측에 유리.
         *
         * 🧪 엣지/검증
         *  - N=2: 단일 도로만 처리(루프 1회).
         *  - 가격 단조 감소: 최초 가격으로 전 구간 구매(갱신 없음).
         *  - 가격 단조 증가: 각 구간마다 최신 minPrice 유지(실질적으로 초기값 유지).
         *  - 지그재그: 더 싼 도시를 만나면 즉시 minPrice 갱신 후 남은 구간에 적용.
         *
         * 🛠 실무 활용도
         *  - "min-so-far" 패턴은 비용·리스크 누적 최적화에 범용적으로 적용.
         *  - 입력 라인이 가변적일 수 있으므로 토큰 부족 시 다음 줄을 읽는 방어 패턴도 고려.
         *
         * 🔐 안정성
         *  - 입력 범위를 신뢰하지 못한다면 Long.parseLong, 범위 체크, 토큰 존재 확인(st.hasMoreTokens) 필요.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim()); // 도시 수
        int m = n - 1; // 도로 수

        long[] dist = new long[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) dist[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long minPrice = Long.parseLong(st.nextToken()); // 도시 0의 가격
        long cost = 0;

        // i번째 도로(도시 i → i+1)를 주행할 때의 비용: dist[i] * minPrice
        for (int i = 0; i < m; i++) {
            cost += dist[i] * minPrice;
            long nextPrice = st.hasMoreTokens() ? Long.parseLong(st.nextToken()) : minPrice; // 입력 보장됨
            if (nextPrice < minPrice) minPrice = nextPrice;
        }
        System.out.println(cost);
        
        /* 내가 작성한 기존 코드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine()) - 1;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long[] arrDistance = new long[cityCount];
        long[] arrOilPrice = new long[cityCount];
        long totalDistance = 0;
        for (int i = 0; i < cityCount; i++) {
            long tempDistance = Integer.parseInt(st1.nextToken());
            arrDistance[i] = tempDistance;
            totalDistance += tempDistance;
            arrOilPrice[i] = Integer.parseInt(st2.nextToken());
        }
        int idx = 0;
        long boughtDistance = arrDistance[0];
        long currentOilPrice = arrOilPrice[0];
        long boughtPrice = arrDistance[0] * currentOilPrice;
        while (boughtDistance != totalDistance) {
            if (currentOilPrice > arrOilPrice[++idx]) {
                currentOilPrice = arrOilPrice[idx];
            }
            boughtPrice += arrDistance[idx] * currentOilPrice;
            boughtDistance += arrDistance[idx];
        }
        System.out.println(boughtPrice);
        */
    }

}

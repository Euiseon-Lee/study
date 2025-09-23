import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 9375 – 패션왕 신해빈
         *
         * 🧠 문제 요약
         * - 의상이 (이름, 종류)로 주어짐.
         * - 같은 종류에서 동시에 2개 이상 착용 불가.
         * - 하루 착장은 "각 종류에서 0개 또는 1개 선택"의 조합이며, "모두 안 입음"은 제외.
         *
         * 🧮 조합론 핵심
         * - 한 종류에 의상 개수가 c개면, 선택지는 (c + 1)가지 (c개 중 1개 or 아무 것도 안 입기).
         * - 독립적인 종류들이 있을 때 전체 착장 수 = 모든 종류 선택지의 곱.
         * - 단, "모두 안 입는 경우" 1가지를 빼야 함.
         *   → 정답 = ∏(c_i + 1) - 1
         *
         * ⚙️ 로직 구조
         * 1) 종류별 개수 집계: Map<String, Integer> typeCount
         * 2) answer = 1 로 시작하여, 각 종류에 대해 answer *= (count + 1)
         * 3) 최종적으로 answer - 1 출력 (모두 안 입음 제거)
         *
         * 🚀 성능
         * - 입력 집계 O(N), 곱셈 O(K) (K=종류 수)
         * - 메모리: 종류 수에 비례하는 HashMap
         * - 제약에서 int로 충분하나, 극단적으로 값이 커질 수 있는 일반화 상황에선 long 고려
         *
         * 🔧 보완 포인트
         * - 변수명 의도 드러내기: map → typeCount, answer → combinations 등 (가독성↑)
         * - 테스트 케이스마다 Map 새로 생성 (지금 OK) or clear() (둘 다 가능)
         * - 실무 확장 시 오버플로/모듈러 연산 필요 시 long/BigInteger 또는 mod 연산 적용
         *
         * ✅ 예시
         * - 종류/개수: 모자 2개, 안경 1개 → (2+1)*(1+1)-1 = 5
         *   (모자만 2, 안경만 1, 모자+안경 2, 아무 것도 안 입음 제외)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < count; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int answer = 1;
            for (int value : map.values()) {
                answer *= value + 1;
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }

}

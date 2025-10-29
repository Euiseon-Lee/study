import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🎬 BOJ 1436 영화감독 숌 – 선형 스캔 기반 정답(안정/명료/충분히 빠름)
         *
         * 🧩 문제 요약
         * - 양의 정수들 중 '666'이 연속으로 포함된 수를 오름차순으로 나열할 때, n번째 수를 출력한다.
         *
         * 💡 핵심 아이디어
         * - 현재 수 cur를 666부터 1씩 증가시키며 "문자열 내 '666' 포함 여부"만 검사한다.
         * - n이 1만 정도인 범위에서는 선형 스캔이 충분히 빠르다(수백만 회 내외 검사).
         *
         * ⏱️ 성능/복잡도
         * - while 루프는 n번째를 찾을 때까지 진행. 각 스텝의 검사는 O(자릿수) ≈ O(6~7).
         * - 전체는 실질적으로 O(조회 횟수)로, BOJ 제한에서 여유롭게 통과.
         *
         * 🛠️ 구현 포인트
         * - contains("666")로 명확하게 의도를 드러냄(가독성/안정성 우선).
         * - 매직 넘버(1000/100/10) 기반의 규칙 분기는 제거 → 오프바이원/누락 리스크 감소.
         *
         * 📎 보완/대안
         * - 미세 최적화: 문자열 변환 대신 정수 자릿수 순회로 '666' 탐지 가능(성능 차이는 미미).
         * - 테스트: n=1 → 666, n=2 → 1666, n=3 → 2666, n=6 → 5666, n=7 → 6660+?가 아니라 6661이 아님에 유의(자연 증가).
         *
         * ✅ 결론
         * - 이 문제 크기에서는 간단한 선형 스캔이 최적 실용 해법. 가독성/안정성/성능 균형이 가장 좋다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int found = 0;
        int current = 665;
        while (found < n) {
            current++;
            if (Integer.toString(current).contains("666")) {
                found++;
            }
        }
        System.out.print(current);
    }

}

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🎲 BOJ 2480 – 주사위 세개
         *
         * ✅ 문제 요약
         *  - 세 주사위 눈 a,b,c가 주어질 때 상금 계산:
         *    * 세 개 같음: 10000 + v*1000
         *    * 두 개 같음: 1000 + v*100
         *    * 모두 다름: max(a,b,c)*100
         *
         * ✅ 기존 코드 요약
         *  - HashMap으로 빈도 집계(map.size()==3 → 모두 다름, 아니면 빈도 2/3 케이스)
         *  - 상금 계산을 Math.pow/round(double)로 처리
         *
         * ✅ 개선 포인트
         *  1) 정수 연산으로 직접 계산: pow/round 제거 → 가독성·안정성↑(부동소수 이슈 제거)
         *  2) 구조 단순화: 3개 입력은 if/else 또는 3원소 정렬로 분기하는 편이 명확
         *  3) 성능/메모리: Map 대신 int 비교 또는 int[7] 빈도(필요 시) → 경량
         *  4) 입력 견고성(선택): 줄바꿈 가능 입력에는 토큰 부족 시 다음 줄 읽기 패턴 적용
         *
         * ✅ 성능 분석
         *  - 상수 입력 크기 → O(1), 메모리 O(1)
         *  - 불필요한 객체/부동소수 연산 제거로 분기 명확, 실행 안정
         *
         * ✅ 예시
         *  - 3 3 6 → 1300
         *  - 2 2 2 → 12000
         *  - 1 2 3 → 300
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int prize;
        if (a == b && b == c) {                 // 세 개 같은 눈
            prize = 10000 + a * 1000;
        } else if (a == b || a == c) {          // a가 쌍
            prize = 1000 + a * 100;
        } else if (b == c) {                    // b가 쌍
            prize = 1000 + b * 100;
        } else {                                // 모두 다름
            int max = Math.max(a, Math.max(b, c));
            prize = max * 100;
        }
        System.out.println(prize);

        /* 내가 작성한 코드, 조건에 비해 너무 과한 구조
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        if (map.size() == 3) {
            int max = 0;
            for (int i : map.keySet()) {
                max = Math.max(i, max);
            }
            System.out.println(max * 100);
        } else {
            for (int i : map.keySet()) {
                int target = map.get(i);
                if (target > 1) {
                    System.out.println(Math.round(Math.pow(10, target + 1) + (i * Math.pow(10, target))));
                }
            }
        }
        */
    }
}


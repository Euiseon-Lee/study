import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * ⏰ BOJ 2884 – 45분 앞당기기: 분기식 vs 분 단위 정규화
         *
         * ✅ 현재 선택(분기식)이 맞는 상황
         *  - 요구가 "정확히 45분만 빼라"로 고정.
         *  - 로직을 바로 읽히게 하고 싶음(명확성 우선).
         *
         * ✅ 분 단위 정규화(total minutes) 패턴을 쓰는 이유
         *  - 일반화: 임의 오프셋 K(예: 90, 135, -20 등)로 바뀌어도 한 줄 수정으로 처리.
         *  - 분기 감소: (H, M) → total = H*60+M → (total±K)%1440 → (H, M) 역변환으로 경계 처리 일원화.
         *  - 조합 연산: 여러 차례 시간 보정에도 동일 패턴 반복, 실수 여지 감소.
         *  - 성능: 둘 다 O(1). 산술 연산(곱/나눗셈/모듈러) 비용은 미미.
         *
         * ✅ 권장 기준
         *  - 요구가 단순·고정(45분): 현재 분기식 유지가 가장 직관적.
         *  - 요구 변경 가능성/반복 보정/재사용 함수 필요: 분 단위 정규화로 전환.
         *
         * ✅ 예시(정규화 패턴)
         *  - MIN_PER_DAY = 1440
         *  - total = (H*60 + M - 45 + MIN_PER_DAY) % MIN_PER_DAY
         *  - H = total / 60; M = total % 60
         *
         * ✅ 매직 넘버
         *  - 45, 1440은 의미 있는 상수로 올려 가독성 향상.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        if (minute >= 45) {
            minute -= 45;
        } else {
            if (hour == 0) hour = 24;
            hour--;
            minute += 15;
        }
        System.out.println(hour + " " + minute);
    }

}

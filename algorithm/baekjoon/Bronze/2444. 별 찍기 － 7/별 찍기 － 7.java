import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🌟 BOJ 2444 - 별 찍기 7 (다이아몬드)
         *
         * 📌 로직 개요
         * - 위쪽 피라미드: i=0..n-1
         *   공백: n-i-1, 별: 2*i+1
         * - 아래쪽 역피라미드: i=n-1..1
         *   공백: n-i,   별: 2*i-1
         * - StringBuilder에 누적 후 한 번에 출력하여 I/O 호출 최소화
         *
         * ⏱️ 복잡도
         * - 출력 문자가 Θ(n^2) → 시간/공간 하한도 Θ(n^2)
         * - 줄마다 String.repeat로 임시 문자열 2개 생성 (공백, 별) → n≤100에서 충분히 빠름
         *
         * ✅ 장점
         * - 수식이 직관적(2*i±1)이고 가독성 높음
         * - println 다중 호출 대신 버퍼 누적으로 성능 안정적
         *
         * 🛠 보완 포인트
         * - 불필요한 문자열 변수 제거: " ", "*" 대신 문자 리터럴 사용 가능
         * - 사전 용량 예약: sb.ensureCapacity(대략적 n*n*2)로 재할당 감소
         * - 할당 최적화(선택): char[] 한 줄 버퍼를 재사용하면 repeat로 생성되는 임시 문자열을 줄일 수 있음
         *   예) 공백으로 채운 char[]에 좌측부터 '*'를 2개씩 늘려가며 append
         *
         * 🧪 엣지 케이스
         * - n=1: 위 루프에서 "*" 한 줄, 아래 루프는 스킵 → 기대 출력과 일치
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String space = " ";
        String star = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(space.repeat(n - i - 1));
            sb.append(star.repeat((i + 1) * 2 - 1)).append('\n');
        }
        for (int i = n - 1; i > 0; i--) {
            sb.append(space.repeat(n - i));
            sb.append(star.repeat((i * 2) - 1)).append('\n');
        }
        System.out.println(sb);
    }

}

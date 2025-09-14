import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 10813 – 공 바꾸기
         *
         * 🧠 문제 요약
         * - 바구니 1..N 각각에 공 1..N이 들어있음.
         * - M번 (x,y) 입력에 따라 바구니 x와 y의 공을 교환.
         * - 최종 상태 출력.
         *
         * ⚙️ 현재 접근(너의 코드)
         * - basket[i] 초기화를 생략하고, 0을 sentinel로 사용.
         * - basket[i]==0 → 기본 공 = i 로 해석.
         * - 스왑 시: basket[x]==0?x:basket[x], basket[y]==0?y:basket[y] 로 실제 공 번호를 계산.
         * - 출력 시도 동일하게 삼항 연산으로 기본값 보정.
         *
         * 🚀 성능
         * - 시간: O(M+N) (스왑 M번 + 출력 N회)
         * - 공간: O(N)
         *
         * 🔧 보완 포인트
         * 1) 가독성
         *    - 시작 시 for문으로 basket[i]=i 초기화 → sentinel 분기 제거.
         *    - 스왑은 temp=basket[x]; basket[x]=basket[y]; basket[y]=temp; 한 줄로 명확.
         *    - 출력도 단순히 basket[i] 사용 가능.
         *
         * 2) 분기 비용 제거
         *    - 현재는 스왑 시 2회, 출력 시 N회 삼항 분기 발생.
         *    - 명시 초기화로 분기 없는 단순 배열 참조 구조로 개선.
         *
         * 3) I/O 디테일
         *    - StringBuilder 마지막 공백은 BOJ에서 허용되나,
         *      깔끔히 하려면 if 조건으로 마지막 공백 제어 가능.
         *
         * ✅ 정리
         * - 네 접근도 정답 맞음.
         * - 다만 sentinel 방식보다 명시 초기화 후 단순 스왑이
         *   가독성과 유지보수성, 성능(분기 제거) 측면에서 더 낫다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int ballX = basket[x] == 0 ? x : basket[x];
            int ballY = basket[y] == 0 ? y : basket[y];
            basket[x] = ballY;
            basket[y] = ballX;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int num = basket[i] == 0 ? i : basket[i];
            sb.append(num + " ");
        }
        System.out.println(sb);
    }

}

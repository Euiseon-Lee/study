import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 2609 – 최대공약수와 최소공배수
         *
         * 🧠 문제 요약
         * - 두 자연수 a, b의 최대공약수(GCD)와 최소공배수(LCM)를 구하는 문제
         *
         * ⚙️ 로직 구조
         * 1) a, b 중 큰 수를 greater, 작은 수를 less 로 설정
         * 2) 유클리드 호제법 반복
         *    - while(greater % less != 0)
         *      → temp = greater % less
         *      → greater = less
         *      → less = temp
         * 3) 반복 종료 시 less 가 최대공약수(GCD)
         * 4) 최소공배수(LCM)는 (a * b) / GCD
         *
         * 🚀 성능
         * - 시간복잡도: O(log(min(a,b))) (유클리드 호제법의 특성)
         * - 공간복잡도: O(1)
         *
         * 🔧 보완 포인트
         * - (a*b)에서 오버플로 가능성 → long 캐스팅 권장
         * - gcd/ lcm 로직을 별도 메서드로 분리하면 재사용성 ↑
         * - Math 라이브러리(gcd 메서드 직접 구현)와 비교 가능
         *
         * ✅ 정리
         * - 전형적인 유클리드 호제법 구현
         * - 정답성·성능 모두 최적
         * - 실무에서는 long 타입 처리와 메서드화로 안정성/재사용성 강화 권장
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int greater =  a >= b ? a : b;
        int less = a >= b ? b : a;
        int temp = 0;
        while (greater % less != 0) {
            temp = greater % less;
            greater = less;
            less = temp;
        }
        System.out.println(less);
        System.out.println((a * b) / less);
    }

}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 🔢 BOJ 2908 - 상수 (세 자리 수 뒤집기)
         *
         * 📌 문제 요약
         * - 세 자리 수 두 개 a, b가 주어진다.
         * - 각 수를 역순으로 뒤집어 비교, 더 큰 수를 출력.
         *
         * 🧱 로직 구조
         * 1) a, b 입력
         * 2) 자리수 분리 후 역순 재조합
         *    - a = (a % 10) * 100 + ((a / 10) % 10) * 10 + (a / 100)
         *    - b 동일
         * 3) Math.max(a, b) 출력
         *
         * ⏱️ 복잡도
         * - 시간: O(1) (산술 연산만)
         * - 공간: O(1)
         *
         * ✅ 장점
         * - StringBuilder.reverse() 대신 산술 연산으로 처리 → 불필요한 객체 생성 없음
         * - 직관적이고 빠른 구현
         *
         * ⚠️ 보완 포인트
         * - 문제는 항상 세 자리 수만 주어지므로 현재 방식으로 충분
         * - 일반화(자릿수 가변) 필요 시 문자열 변환 + reverse 접근이 더 범용적
         *
         * 🧠 확장 아이디어
         * - 자리수 조작/역순 변환은 파싱 로직, 보안 코드 역해석, 난독화 해제 등에 자주 등장
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        a = ((a % 10) * 100) + (((a / 10) % 10) * 10) + (a / 100);
        b = ((b % 10) * 100) + (((b / 10) % 10) * 10) + (b / 100);
        System.out.println(Math.max(a, b));
    }

}

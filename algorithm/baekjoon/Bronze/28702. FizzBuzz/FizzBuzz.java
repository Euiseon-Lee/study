import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔢 BOJ 28702 FizzBuzz – 입력 기반 다음 값 예측 (상수 시간 완전 탐색)
         *
         * 🧩 문제 개요
         * - 입력: 3줄 (각 줄은 "Fizz", "Buzz", "FizzBuzz", 또는 정수)
         * - 조건: 세 줄 중 하나만 숫자이며, 나머지는 문자열.
         * - 목표: 주어진 입력 다음 순서(네 번째 값)에 해당하는 FizzBuzz 출력.
         *
         * 💡 핵심 아이디어
         * 1️⃣ 세 줄 중 하나는 숫자이므로, 해당 숫자가 현재 시점의 "카운트 기준".
         * 2️⃣ 이후 입력은 단순히 1씩 증가하므로 flag(`isNumber`)로 상태 전환.
         * 3️⃣ 숫자 이후의 입력은 값이 없어도 카운트 증가만 수행.
         * 4️⃣ 마지막으로 n++ → “다음 값” 계산 후 FizzBuzz 규칙 적용.
         *
         * ⚙️ 알고리즘 구조
         * - 입력 3회 반복:
         *   • 숫자 등장 전: 문자열인지 숫자인지 판별
         *   • 숫자 등장 후: n 증가만 수행
         * - 반복 종료 후 n++ → FizzBuzz 출력 규칙 적용
         *
         * 🧮 FizzBuzz 규칙
         * - 3의 배수   → "Fizz"
         * - 5의 배수   → "Buzz"
         * - 15의 배수  → "FizzBuzz"
         * - 그 외       → n 자체 출력
         *
         * ⏱️ 복잡도
         * - 시간: O(1) (3회 입력, 상수 연산)
         * - 공간: O(1)
         *
         * 🧠 구현 포인트
         * - 숫자 여부 판별: 첫 문자('F','B'가 아닌 경우)로 간단히 구분
         * - flag(`isNumber`)로 상태 전환 → 이후 입력에서 단순 카운트
         * - FizzBuzz 출력 분기: 15배수 우선 검사 → 3, 5 순서로 처리
         *
         * 🧩 실무적 관찰
         * - 입력 패턴 중 상태 전환(flag)을 통해 흐름 제어하는 간단한 FSM(Finite State Machine)의 예.
         * - 텍스트와 숫자가 섞인 입력 파싱 문제에서 자주 쓰이는 사고 패턴.
         */
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        boolean foundNumber = false;

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            if (foundNumber) { // 이미 숫자를 찾은 이후
                n++;
                continue;
            }
            if (Character.isDigit(s.charAt(0))) {
                foundNumber = true;
                n = Integer.parseInt(s);
            }
        }
        n++;

        if (n % 15 == 0) System.out.println("FizzBuzz");
        else if (n % 3 == 0) System.out.println("Fizz");
        else if (n % 5 == 0) System.out.println("Buzz");
        else System.out.println(n);
    }
}

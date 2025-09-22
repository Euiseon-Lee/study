import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 10799 – 쇠막대기
         *
         * 🧠 아이디어
         * - '(' → 막대 시작 → open++
         * - ')' → 두 가지 경우:
         *   1) 직전이 '(' → 레이저:
         *      - open-- (막대 하나 닫힘)
         *      - answer += open (현재 열린 막대 수만큼 잘려서 조각 증가)
         *   2) 직전이 ')' → 막대의 끝:
         *      - open-- (막대 하나 닫힘)
         *      - answer++ (마지막 조각 하나 추가)
         *
         * 🧮 시뮬레이션 예시 (입력: ()(((()())(())()))(()))
         * - 단계별로 open(열린 막대 수), answer(조각 수)를 추적
         * 입력: ()(((()())(())()))(())
         * 초기 상태: open=0, answer=0
         *
         * ( → 막대 시작
         * open=1, answer=0
         *
         * ) → 직전이 ( → 레이저
         * open=0, answer=0 (잘린 막대 없음)
         *
         * ( → 막대 시작
         * open=1
         *
         * ( → 막대 시작
         * open=2
         *
         * ( → 막대 시작
         * open=3
         *
         * ( → 막대 시작
         * open=4
         *
         * ) → 직전이 ( → 레이저
         * open=3, answer += 3 → answer=3
         *
         * ( → 막대 시작
         * open=4
         *
         * ) → 직전이 ( → 레이저
         * open=3, answer += 3 → answer=6
         *
         * ) → 직전이 ) → 막대 끝
         * open=2, answer++ → answer=7
         *
         * … 이런 식으로 끝까지 진행 → 최종 answer=17.
         *
         * 🚀 복잡도
         * - O(n), 메모리 O(1)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =  br.readLine();
        int open = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                if (s.charAt(i - 1) == '(') {
                    open--;
                    answer += open;
                } else {
                    open--;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}

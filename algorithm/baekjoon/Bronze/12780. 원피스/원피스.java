import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧵 BOJ 12780 원피스 – 문자열 내 비중첩(target) 등장 횟수 계산
         *
         * 💡 문제 요약
         * - 문자열 str 안에서 target이 "겹치지 않게" 몇 번 등장하는지 세기
         *
         * 🧠 접근 아이디어
         * - 문자열 탐색 시 indexOf(target, start)를 사용하면 
         *   start 이후 첫 등장 인덱스를 바로 찾을 수 있다.
         * - 찾은 경우: count++, 그리고 start를 pos + target.length()로 이동(겹침 방지)
         * - 못 찾으면 탐색 종료.
         *
         * ⚙️ 알고리즘 구조
         * 1️⃣ start = 0, count = 0
         * 2️⃣ while ((pos = str.indexOf(target, start)) != -1):
         *      count++
         *      start = pos + target.length()
         * 3️⃣ count 출력
         *
         * ⏱️ 복잡도
         * - 평균 O(N), 최악 O(N*M) (Java indexOf 내부 구현은 보통 KMP 유사)
         *
         * 🛠️ 구현 포인트
         * - substring으로 직접 잘라 검사하면 중첩 포함 → 틀림
         * - indexOf와 start 이동으로 중첩 제거
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int count = 0;
        int start = 0;
        int position;

        while ((position = str.indexOf(target, start)) != -1) {
            count++;
            start = position + target.length();
        }
        System.out.print(count);
    }

}

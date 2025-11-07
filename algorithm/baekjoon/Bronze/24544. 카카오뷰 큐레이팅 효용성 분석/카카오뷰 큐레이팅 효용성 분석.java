import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🎳 BOJ 24544 볼링 점수 계산 – 등록 여부에 따른 점수 합산
         *
         * 💡 문제 요약
         * - 각 핀의 점수(content)와 등록 여부(1=등록, 0=미등록)가 주어질 때,
         *   전체 점수 합과 미등록 핀 점수 합을 각각 출력한다.
         *
         * 🧩 로직 구조
         * 1️⃣ 두 줄 입력을 각각 StringTokenizer로 병렬 순회
         * 2️⃣ 매 인덱스 i마다:
         *     - total += content
         *     - 등록되지 않았다면 unregistered += content
         * 3️⃣ total, unregistered 출력
         *
         * ⏱️ 복잡도
         * - 시간: O(N)
         * - 공간: O(1)
         *
         * 🛠️ 구현 포인트
         * - 불필요한 삼항 연산자 제거: (x == 1 ? true : false) → (x == 1)
         * - StringTokenizer 병렬 처리로 입력 한 번에 처리 가능
         * - 입력 크기가 작을 경우 split()으로도 구현 가능(가독성↑)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int unregistered = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int content = Integer.parseInt(st1.nextToken());
            boolean isRegistered = Integer.parseInt(st2.nextToken()) == 1;
            total += content;
            if (!isRegistered) unregistered += content;
        }
        System.out.println(total);
        System.out.print(unregistered);
    }

}


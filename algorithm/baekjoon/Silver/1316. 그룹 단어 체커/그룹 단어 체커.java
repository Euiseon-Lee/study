import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * ✍️ BOJ 1316 - 그룹 단어 체커
         *
         * 📌 문제 요약
         * - 단어가 그룹 단어인지 판별:
         *   같은 문자는 반드시 연속해서 나타나야 함.
         *   중간에 다른 문자가 끼면 다시 나오면 안 됨.
         *
         * 🧱 로직 개요
         * - 각 단어에 대해:
         *   1. 이전 문자(prev) 추적
         *   2. 등장 기록(used[26]) 확인
         *   3. 연속 문자가 바뀔 때, 이미 등장했던 문자가 다시 나오면 실패
         *   4. 끝까지 통과하면 그룹 단어
         *
         * ⏱️ 복잡도
         * - 시간: O(n * L) (n=단어 개수, L=최대 단어 길이)
         * - 공간: O(26) → 상수 크기
         *
         * ✅ 장점
         * - 한 번의 순회로 그룹 단어 여부 판별 가능
         * - 불필요한 자료구조 없이 boolean 배열로 최적화 가능
         *
         * ⚠️ 주의
         * - 첫 문자를 바로 used에 등록하거나 prev=0으로 시작해도 OK
         * - 변수명은 isGroupWord처럼 의미가 드러나는 쪽이 바람직
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean[] used = new boolean[26];
            char prev = 0;
            boolean isGroupWord = true;

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (ch != prev) {
                    if (used[ch - 'a']) {
                        isGroupWord = false;
                        break;
                    }
                    used[ch - 'a'] = true;
                    prev = ch;
                }
            }
            if (isGroupWord) answer++;
        }
        System.out.println(answer);
    }
}


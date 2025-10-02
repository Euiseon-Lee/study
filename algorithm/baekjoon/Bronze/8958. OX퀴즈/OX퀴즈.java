import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📝 BOJ 8958 - OX 퀴즈
         *
         * 📌 문제 요약
         * - OX 문자열에서 연속된 O의 길이에 따라 점수를 계산
         *   * O가 연속될수록 가중치가 1씩 증가
         *   * X가 나오면 끊기고 가중치 초기화
         *
         * 🧱 로직
         * - streak: 연속된 O 개수
         * - totalScore: 현재 문자열의 총 점수
         * - 문자 검사:
         *   O → streak++ & totalScore += streak
         *   X → streak = 0
         *
         * ⏱️ 복잡도
         * - 시간: O(n * L) (n=테스트케이스 수, L=문자열 길이)
         * - 공간: O(1) (StringBuilder 제외)
         *
         * ✅ 장점
         * - 규칙을 그대로 코드로 옮겨 직관적
         * - StringBuilder로 출력 최적화
         *
         * ⚠️ 주의
         * - 매 테스트케이스마다 streak, totalScore 초기화 필요
         * - sb.append(answer + "\n") 대신 sb.append(answer).append('\n') 권장
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String score = br.readLine();
            int streak = 0;
            int totalScore = 0;

            for (int j = 0; j < score.length(); j++) {
                if (score.charAt(j) == 'O') {
                    streak++;
                    totalScore += streak;
                } else {
                    streak = 0;
                }
            }
            sb.append(totalScore).append('\n');
        }

        System.out.print(sb);
    }

}

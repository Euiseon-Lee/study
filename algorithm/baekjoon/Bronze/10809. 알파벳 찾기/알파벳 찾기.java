import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 10809 – 알파벳 찾기
         *
         * 🧠 목표
         * - 소문자 문자열 s에서 각 알파벳(a~z)이 '처음 등장하는 인덱스'를 출력
         * - 없으면 -1
         *
         * ⚙️ 효율적 접근 (현재 네 방식 = 최적)
         * - firstIndex[26]을 -1로 초기화
         * - 문자열을 한 번만 순회하며:
         *   - c = s[i]
         *   - idx = c - 'a'
         *   - firstIndex[idx]가 -1일 때만 i로 채움(최초 위치만 기록)
         * - 시간 O(n), 공간 O(26) → 더 줄일 수 없음(사실상 하한)
         *
         * 🔧 미세 개선 포인트 (가독성/사소한 비용)
         * 1) Arrays.fill(firstIndex, -1) 사용 → 초기화 루프 제거
         * 2) s.toCharArray()로 char[] 한 번 받아 순회 → charAt 호출 오버헤드 감소(미세)
         * 3) 출력은 BufferedWriter 또는 StringBuilder로 모아 한 번에 flush
         * 4) 마지막 공백 제어가 필요하면 조건부 공백 추가
         *
         * 🚫 덜 효율적인 대안(하지만 코드 짧음)
         * - for a..z: s.indexOf(ch)로 구하기 → O(26*n), n이 길면 손해
         *
         * ✅ 결론
         * - 네 알고리즘은 이미 최적
         * - 위 미세 개선으로 코드 간결/깨끗하게 다듬는 정도만 권장
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - 'a';
            if (alphabet[idx] == -1) alphabet[idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]);
            if (i < 25) sb.append(' ');
        }
        System.out.print(sb);
    }

}

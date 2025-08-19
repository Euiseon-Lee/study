import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /**
         * 🔤 알파벳 최빈 문자 찾기 (동률 시 '?')
         *
         * ✅ 문제 조건
         * - 문자열은 오직 '소문자'와 '공백'으로만 이루어짐
         * - 따라서 대문자/숫자/특수문자 처리 로직 불필요
         *
         * ✅ 구현 개요
         * 1) 입력: 첫 줄에 테스트 케이스 수 N, 이후 N줄 문자열
         * 2) 전처리: 공백 제거 (s.replace(" ", ""))
         * 3) 빈도 계산: alphabet[c - 'a']++ (소문자만 들어오기 때문에 안전)
         * 4) 최빈 탐색:
         *    - 더 큰 빈도 발견 → maxChar 갱신, 유일성 플래그 true
         *    - 같은 빈도 재발견 → 유일성 false로 전환
         * 5) 출력: 최빈 문자가 유일하면 문자, 동률이면 '?'
         *
         * 📈 성능
         * - 한 줄 길이 L일 때 O(L) + 26 (빈도 배열 스캔) → O(L)
         * - 공간 O(26) = O(1)
         *
         * 🧪 대안 설계
         * - 최빈값 먼저 구하고, 동률 개수를 세는 2단계 방식도 가능
         *   (가독성↑, 상태변수 관리↓)
         *
         * 🧩 실무 응용
         * - 입력 조건이 제한적일 때는 불필요한 방어 로직을 줄이는 것이 최적화에 유리
         * - 로그 분석/태그 집계처럼 “최빈값 + 동률 판정” 문제에 패턴 그대로 응용 가능
         */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            int[] alphabet = new int[26];
            String s = sc.nextLine().replace(" ", "");
            for (char c : s.toCharArray()) {
                alphabet[c - 'a']++;
            }

            int maxCount = 0;
            char maxChar = ' ';
            boolean isOnlyOne = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] > maxCount) {
                    maxCount = alphabet[j];
                    maxChar = (char) (j + 'a');
                    isOnlyOne = true;
                } else if (alphabet[j] == maxCount) {
                    maxChar = ' ';
                    isOnlyOne = false;
                }
            }
            System.out.println(isOnlyOne ? maxChar : '?');
        }
        sc.close();
    }

}

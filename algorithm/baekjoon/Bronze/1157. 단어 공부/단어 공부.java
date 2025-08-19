import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /**
         * 🧠 BOJ 1157 - 단어 공부
         *
         * ✅ 문제/입력 조건
         * - 하나의 단어가 주어지며, 영문 대소문자로만 구성됨(공백/기타 문자 없음)
         * - 최빈 알파벳(대문자)을 출력하되, 최빈이 여러 개면 '?' 출력
         *
         * ✅ 현재 구현 요약
         * - 정규화: 입력 문자열을 모두 대문자로 변환(toUpperCase)
         * - 집계: 길이 26의 배열에 빈도 누적(alphabet[c - 'A']++)
         * - 판정: 한 번의 배열 순회로 최빈값 갱신 및 동률 여부(isOnlyOne) 판단
         * - 출력: 유일 최빈이면 해당 문자, 아니면 '?'
         *
         * 📈 복잡도
         * - 시간: O(L) + O(26) ≈ O(L)
         * - 공간: O(1) (알파벳 크기 고정)
         *
         * 🔁 동률 판정 대안(가독성 목적)
         * - 1회 순회 방식: 더 빠르고 짧다(현재 코드). 다만 상태변수(isOnlyOne) 이해가 살짝 복잡할 수 있음.
         * - 2단계 방식: (1) 최대 빈도 구함 → (2) 최대 빈도와 같은 문자의 개수 셈
         *   규칙: "협업/가독성 우선"이면 2단계, "짧고 빠르게"면 1회 순회 유지.
         *
         * 🧩 실무 적용 포인트
         * - 입력이 큰 환경에서는 BufferedReader 권장(입력 라인 단위 처리)
         *   // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         *   // String s = br.readLine().toUpperCase();
         * - I/O 선택:
         *   - 온라인 저지 소규모 입력: Scanner로도 충분(닫지 않아도 무방)
         *   - 대규모/고성능 요구: BufferedReader + readLine() 권장
         *   규칙: "입력이 매우 길다/많다"면 BufferedReader로 전환.
         * - 입력 전처리(정규화) 규칙은 함수로 분리: 예) 대소문자 통일, 비문자 제거 등
         */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        sc.close();
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'A']++;
        }
        int maxCount = 0;
        char maxChar = ' ';
        boolean isOnlyOne = false;
        for (int j = 0; j < alphabet.length; j++) {
            if (alphabet[j] > maxCount) {
                maxCount = alphabet[j];
                maxChar = (char) (j + 'A');
                isOnlyOne = true;
            } else if (alphabet[j] == maxCount) {
                maxChar = ' ';
                isOnlyOne = false;
            }
        }
        System.out.println(isOnlyOne ? maxChar : '?');
    }

}

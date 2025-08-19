import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /**
         * 🔢 BOJ 자리수 합 문제 (11720 패턴)
         *
         * ✅ 기존 구현 방식
         * - 입력: 정수 N과 길이 N의 숫자 문자열
         * - 처리: 문자열을 split("")으로 분리 → 각 원소를 Integer.parseInt → 합산
         * - 장점: 직관적이고 빠르게 구현 가능
         * - 단점:
         *   1) split("")은 내부적으로 정규식 처리 → 불필요한 배열 생성(메모리 O(N))
         *   2) 각 자리마다 Integer.parseInt(String) 호출 → 변환 비용 상대적으로 큼
         *
         * ✅ 개선 구현 방식
         * - 처리: 문자열 그대로 순회하며 charAt(i) - '0' 으로 누적
         * - 장점:
         *   1) 추가 배열 생성 없음 → 메모리 효율적(O(1))
         *   2) parseInt 호출 대신 단순 뺄셈 연산으로 성능 개선
         *   3) 코드가 간결하고 가독성↑
         * - 단점: 입력이 반드시 숫자 문자열이라는 전제 필요
         *
         * 📈 성능/복잡도
         * - 두 방식 모두 시간복잡도 O(N)
         * - 개선 방식은 상수항 성능과 메모리 사용량에서 우위
         *
         * 🧪 실무/응용 포인트
         * - 자리수 합은 체크섬, 바코드, 카드번호 검증 등 다양한 곳에 활용됨
         * - 입력이 커지는 BOJ/실무 환경에서는 Scanner보다 BufferedReader 권장
         *   (예: br.readLine() 후 charAt 순회)
         *
         * 🛡️ 안정성
         * - N과 문자열 길이 일치 검증 가능: if (s.length() != N) throw new IllegalArgumentException();
         * - 각 문자가 '0'~'9' 범위인지 확인하려면 Character.isDigit 활용 가능
         */

        /* 기존 코드
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String s = sc.next();
        sc.close();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        System.out.println(sum);
        */

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String s = sc.next();
        sc.close();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        System.out.println(sum);
    }
}

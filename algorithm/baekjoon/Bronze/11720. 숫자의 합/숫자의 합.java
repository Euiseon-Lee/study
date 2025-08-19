import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        /**
         * 🔢 BOJ 자리수 합 문제 (11720 패턴)
         *
         * ✅ 초기 구현 방식 (Scanner + split)
         * - 입력: 정수 N과 길이 N의 숫자 문자열
         * - 처리: 문자열을 split("")으로 분리 → 각 원소를 Integer.parseInt → 합산
         * - 장점: 직관적이고 빠르게 구현 가능
         * - 단점:
         *   1) split("")은 정규식 처리 → 불필요한 배열 생성(메모리 O(N))
         *   2) 각 자리마다 Integer.parseInt(String) 호출 → 변환 비용 상대적으로 큼
         *
         * ✅ 개선 구현 (Scanner + charAt)
         * - 처리: 문자열 그대로 순회하며 charAt(i) - '0' 으로 누적
         * - 장점:
         *   1) 추가 배열 생성 없음 → 메모리 효율적(O(1))
         *   2) parseInt 호출 대신 단순 뺄셈 연산으로 성능 개선
         *   3) 코드가 간결하고 가독성↑
         * - 단점: 입력이 반드시 숫자 문자열이라는 전제 필요
         *
         * ✅ 최종 구현 (BufferedReader + charAt)
         * - Scanner 대신 BufferedReader로 입력 처리 → 큰 입력에서 속도 유리
         * - 처리: readLine()으로 한 줄 단위 입력 후 charAt(i) - '0' 연산
         * - 장점: BOJ 같은 대규모 입력 환경에 최적화
         * - 단점: 문자열만 입력 가능하므로 직접 Integer.parseInt() 호출 필요,
         *         IOException 처리 필요
         *
         * 📈 성능/복잡도
         * - 세 방식 모두 시간복잡도 O(N)
         * - 메모리/상수항 성능: split < Scanner+charAt < BufferedReader+charAt
         *
         * 🧪 실무/응용 포인트
         * - 자리수 합은 체크섬, 바코드, 카드번호 검증 등에서 활용
         * - 알고리즘 문제: Scanner 대신 BufferedReader 습관화 → 시간 초과 방지
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

        // Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());  // 첫 줄: 자리수 개수
        String s = br.readLine();                     // 둘째 줄: 숫자 문자열
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';                 // char -> 숫자 변환
        }
        System.out.println(sum);
    }
}


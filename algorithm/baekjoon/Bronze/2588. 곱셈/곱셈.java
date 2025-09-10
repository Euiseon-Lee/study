import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 2588 – 곱셈 (부분 곱 출력 + 전체 곱)
         *
         * ✅ 문제 요약
         *  A(정수)와 B(문자열, 세 자리)를 입력받아
         *  1) B의 각 자리(일의 자리부터)와 A의 곱을 줄단위로 출력
         *  2) 마지막 줄에 A × B의 전체 곱을 출력한다.
         *
         * ✅ 네 코드 요약
         *  - A는 int, B는 String으로 입력
         *  - 오른쪽(일의 자리)부터 순회하며 부분 곱을 계산해 StringBuilder에 기록
         *  - 자리 가중치를 곱해 전체 합(total)을 누적
         *
         * 🔧 개선 포인트
         *  1) 문자→숫자 변환: Integer.parseInt(b.charAt(i) + "") 대신 digit = b.charAt(i) - '0'
         *     - 불필요한 문자열 생성/파싱 제거, 분기/할당 감소
         *  2) 자리수 가중치: Math.pow(10, k) 대신 정수 place(1→10→100) 누적 사용
         *     - 부동소수 계산/캐스팅 제거, 정확성·가독성·속도 모두 개선
         *  3) 빌더 사용: sb.append(value).append('\n')로 줄바꿈을 char로 처리(GC 부담↓)
         *
         * ⚙️ 성능 분석
         *  - 길이 |B|만큼 1회 순회: O(|B|) (본 문제에선 사실상 상수 크기), 추가 메모리 O(1)
         *  - 박싱/정규연산 제거로 분기/할당 최소화 → 안정적 실행 시간
         *
         * 🛠 실무 활용도
         *  - 자리수 연산은 pow(double)보다 정수 누적이 표준 패턴
         *  - 문자→숫자 변환은 '0' 보정(d - '0')을 우선 적용, 파싱/박싱 지양
         *  - 대형 숫자 취급 시 누적·최종 결과를 long으로 승격하는 습관 권장
         *
         * 💡 digit = ch - '0' 원리
         *  - '0'..'9'는 유니코드(ASCII)에서 연속 코드포인트(48..57)
         *  - 예: '7' - '0' = 55 - 48 = 7 → 문자 '7'을 정수 7로 매핑
         *  - 장점: 문자열/파싱 없이 O(1) 정수 연산, 의도 가독성↑
         *  - 주의: 입력이 반드시 '0'~'9' 범위라는 전제가 필요
         *          (불확실하면 범위 검사 혹은 Character.isDigit/Character.digit 사용)
         *
         * 🧪 엣지/검증
         *  - B에 '0' 포함(예: A=123, B=105) 시 부분 곱 0 라인 포함되어야 함
         *  - A 또는 B가 최대값일 때도 int 안전(문제 제약 내), 일반화 시 long 고려
         *  - 입력 오염(비숫자) 가능성이 있는 실무 환경에선 예외 처리 필요
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        StringBuilder sb = new StringBuilder();
        int total = 0;
        int place = 1; // 1, 10, 100...

        for (int i = b.length() - 1; i >= 0; i--) {
            int digit = b.charAt(i) - '0';   // 문자를 숫자로
            int partial = a * digit;         // 부분 곱
            sb.append(partial).append('\n'); // 줄바꿈은 char로
            total += partial * place;        // 자리 가중치 반영
            place *= 10;
        }

        System.out.print(sb);
        System.out.println(total);
    }
}

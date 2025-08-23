import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📝 2진수 → 8진수 변환 (비트 연산 최적화)
         *
         * ✅ 핵심 로직
         * 1) 8진수 1자리는 정확히 2진수 3자리와 대응됨
         *    - 예: 2진수 "101" = 8진수 '5'
         *    - 따라서 입력 문자열을 3자리씩 끊어 읽으면 됨
         *
         * 2) Zero Padding (앞쪽 0 채우기)
         *    - 문자열 길이가 3으로 나눠떨어지지 않으면 앞에 0을 채운 것과 같은 효과를 줘야 함
         *    - 이유: 항상 "2진수 3자리 = 8진수 1자리" 규칙을 유지해야 변환 가능
         *    - 예: "1" → "001"(=1), "10" → "010"(=2)
         *
         * 3) 비트 연산을 이용한 변환
         *    - 각 자리 비트(b0, b1, b2)를 정수 0/1로 변환 후 자릿값을 곱해야 함
         *    - 일반적인 수식: b0*4 + b1*2 + b2*1
         *    - 비트 시프트(<<)를 이용하면 곱셈 대신 빠르게 처리 가능
         *
         *    👉 비트 연산자 상세 설명
         *    - << (LEFT SHIFT): 왼쪽으로 비트를 밀며, 2^k를 곱한 효과
         *        예: (1 << 2) = 4  → 2진수 001 → 100
         *    - | (BITWISE OR): 두 비트를 비교해 하나라도 1이면 결과가 1
         *        예: 100 | 001 = 101
         *    - 따라서 (b0<<2) | (b1<<1) | b2 는
         *        = (b0*4) + (b1*2) + (b2*1)
         *        = 2진수 3자리 → 10진수 값(=8진수 한 자리)
         *
         * 🚀 성능 분석
         * - 시간: O(N) 단일 패스
         * - 메모리: StringBuilder에 결과 자리수만 저장 (≈ N/3)
         * - substring/parseInt 호출 제거 → 중간 문자열 생성 없음 → GC 부담 최소화
         *
         * 🔐 실무 활용 관점
         * - 대규모 데이터 변환 시 문자열 파싱 오버헤드 제거
         * - 고정 폭(bit width) 변환 규칙(2→8, 4→16 등)에서 공통적으로 적용 가능
         *
         * ⚠️ 보완 포인트
         * - 선행 0 처리: 전체가 0이 아닐 때는 출력에서 불필요한 앞 0 제거
         * - 실무 적용 시 입력 검증 필요(0/1 외의 값이 들어오지 않는다는 보장 필요)
         *
         * 💡 ByteBuffer 관련 메모
         * - java.nio.ByteBuffer는 대용량 파일/소켓 I/O에 최적화된 구조
         * - 본 문제처럼 단순 문자열 기반 변환에는 StringBuilder가 더 적합
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();
        StringBuilder out = new StringBuilder((n + 2) / 3);

        int idx = 0;
        int rem = n % 3;

        // 1) 앞쪽 나머지 비트 처리 (논리적 Zero Padding)
        if (rem != 0) {
            int v = 0;
            for (int k = 0; k < rem; k++) {
                v = (v << 1) | (s.charAt(idx++) - '0');
            }
            out.append(v);
        }

        // 2) 이후는 3자리씩 고정 처리
        while (idx < n) {
            int b0 = s.charAt(idx++) - '0';
            int b1 = s.charAt(idx++) - '0';
            int b2 = s.charAt(idx++) - '0';
            int v = (b0 << 2) | (b1 << 1) | b2; // 2진수 3자리 → 8진수 한 자리
            out.append(v);
        }

        // 3) 선행 0 제거 (단, 전체가 0이면 한 자리만 유지)
        int start = 0;
        while (start < out.length() - 1 && out.charAt(start) == '0') start++;
        System.out.println(out.substring(start));
    }

    
    /* 기존에 내가 최초로 작성한 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();

        int pad = (3 - binary.length() % 3) % 3;
        if (pad > 0) {
            binary = "0".repeat(pad) + binary;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 3) {
            String chunk = binary.substring(i, i + 3);
            int oct = Integer.parseInt(chunk, 2);
            sb.append(oct);
        }

        System.out.println(sb.toString().replaceFirst("^0+(?!$)", ""));
    }
    */
}

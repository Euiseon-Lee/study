import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧫 BOJ 9342 – Virus (패턴 매칭)
         *
         * ✅ 문제 요약
         *  - 문자열이 다음 정규식 패턴에 맞으면 "Infected!", 아니면 "Good" 출력
         *    패턴: ^[A-F]?A+F+C+[A-F]?$
         *    설명: (선행 0~1개 A~F) + (A 1+개) + (F 1+개) + (C 1+개) + (후행 0~1개 A~F)
         *
         * ✅ 내 코드 요약
         *  - 입력 T를 받고, 각 라인에 대해 정규식 매칭 → 삼항 연산자로 결과 누적 출력
         *
         * ✅ 성능/구조 진단
         *  - String.matches는 호출마다 정규식 컴파일 → T가 크면 비효율
         *  - 패턴은 고정 상수이므로 Pattern을 사전 컴파일해 재사용하는 편이 유리
         *
         * 🔧 보완 포인트
         *  1) 정규식 사전 컴파일: static final Pattern VIRUS = Pattern.compile("^[A-F]?A+F+C+[A-F]?$");
         *  2) 앵커 명시: matches는 전체 일치지만 ^…$ 명시로 가독성/이식성 강화
         *  3) 출력: println(sb.toString()) → print(sb)로 변환 비용/여분 개행 제거
         *  4) 대안(수동 FSM): 문자 스캔으로 A+→F+→C+ 상태 전이 확인(정규식 백트래킹 회피, 디버깅 용이)
         *
         * ✅ 실무 활용도
         *  - 고정 패턴 다건 검증 시 정규식 사전 컴파일이 기본
         *  - 상태 전이(FSM)는 로깅/디버깅/확장(세그먼트 길이 수집) 시 장점
         *
         * 🧪 엣지/검증
         *  - "AFC"     → Infected!
         *  - "AAFFFCC" → Infected!
         *  - "BAFCZ"   → Good (Z 포함)
         *  - "AFCC"    → Good (A+는 OK, F+는 1, C+는 2, 선행/후행 옵션 외 문자가 있으면 실패)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            sb.append(VIRUS.matcher(s).matches() ? INFECTED : GOOD).append('\n');
        }
        System.out.print(sb);
        /* 내가 작성한 코드
        final String GOOD = "Good";
        final String INFECTED = "Infected!";
        String pattern = "[A-F]?A+F+C+[A-F]?$";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(br.readLine().matches(pattern) ? INFECTED : GOOD).append('\n');
        }
        System.out.println(sb.toString());
        */
    }
}


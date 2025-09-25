import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧮 BOJ 19583 - 싸이버개강총회
         *
         * 📌 문제 해석
         * - S(입장 이전), E(퇴장 시작), Q(마감) 시각이 주어진다.
         * - 채팅 로그에서:
         *   1) S 이전에 채팅한 사람을 후보 집합에 기록
         *   2) E~Q 사이에 다시 채팅하면 출석 인정 (1인 1회 카운트)
         *
         * 🧱 로직 구조
         * - S, E, Q를 "HH:MM" → 정수 HHMM 으로 변환
         * - HashSet<String> seenBeforeS 에 S 이전 닉네임 저장
         * - 각 로그: time, name 파싱
         *   - time <= S        → seenBeforeS.add(name)
         *   - E <= time <= Q   → if (seenBeforeS.contains(name)) { count++; remove(name); }
         *
         * ⏱️ 복잡도
         * - 시간: O(N) (로그 1패스, HashSet 평균 O(1))
         * - 공간: O(U) (S 이전 채팅자 수 U)
         *
         * ✅ 장점
         * - 중복 방지: E~Q에서 카운트 후 remove로 재카운트 차단
         * - 문자열 시각을 정수로 변환해 비교 단순화
         *
         * ⚠️ 주의/보완
         * - 표준입력은 EOF까지 계속 대기 → 로컬 실행 시 EOF 입력(Win: Ctrl+Z+Enter, macOS/Linux: Ctrl+D) 필요
         * - 디버깅 출력 제거 (S/E/Q 출력 금지)
         * - while 조건은 (line != null) 만으로 충분; 빈 줄은 스킵 처리 권장
         * - 제네릭 누락 금지: new HashSet<>() 사용
         * - replace(':','0')가 아니라 replace(':','')는 불가 → char 기반 replace 사용 권장: str.replace(":", "") 대신 str.replace(":", "")
         *   (성능상 미미하나 불필요한 String 생성 줄이기 위해 char 버전 replace 사용 고려)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken().replace(":",""));
        int e = Integer.parseInt(st.nextToken().replace(":",""));
        int q = Integer.parseInt(st.nextToken().replace(":",""));
        String line;
        HashSet<String> set = new HashSet<>();
        int count = 0;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int time = Integer.parseInt(st.nextToken().replace(":",""));
            String name = st.nextToken();
            if (time <= s) set.add(name);
            if (time >= e && time <= q && set.contains(name)) {
                count++;
                set.remove(name);
            }
        }
        System.out.println(count);
    }

}

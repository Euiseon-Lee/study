import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /**
         * 🧩 BOJ 9996 - 한국이 그리울 땐 서버에 접속하지
         *
         * ✅ 문제 요약
         * - 패턴 문자열은 prefix + "*" + suffix 형태
         * - 문자열 s가 매칭되려면:
         *   1) s.length >= prefix.length + suffix.length
         *   2) s.startsWith(prefix) && s.endsWith(suffix)
         * - 만족 시 "DA", 아니면 "NE" 출력
         *
         * ⚙️ Scanner 버전 입력 처리
         * - nextInt()는 개행문자(\n)를 버퍼에 남겨둔다
         * - 따라서 곧바로 nextLine()을 호출하면 빈 문자열("")이 들어옴
         * - 해결: sc.nextLine(); // consume EOL → 남아 있는 개행만 소모
         *
         * ⚙️ BufferedReader 버전 입력 처리
         * - br.readLine()은 한 줄 전체를 문자열로 가져오기 때문에 개행 문제 없음
         * - 숫자 입력도 readLine() + Integer.parseInt() 조합으로 처리
         *   예시:
         *   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         *   int count = Integer.parseInt(br.readLine());
         *   String[] target = br.readLine().split("\\*", -1);
         *   for (int i = 0; i < count; i++) {
         *       String s = br.readLine();
         *       ...
         *   }
         *
         * ⚠️ split 주의
         * - String.split()은 기본적으로 trailing empty token을 버림
         *   ex) "abc*" → ["abc"]
         * - split("\\*", -1)로 호출해야 ["abc", ""]가 되어 suffix를 안전하게 표현 가능
         *
         * 📈 복잡도
         * - 총 입력 길이를 M이라 할 때 O(M)
         * - 메모리 O(1) (고정 prefix/suffix 비교)
         *
         * 🧩 실무 적용 포인트
         * - 파일명 패턴 매칭, 라우팅 규칙, 로그 필터링 등 "prefix+suffix+중간 자유" 패턴에 그대로 응용 가능
         * - 실무 습관화 팁:
         *   - Scanner: 숫자+문자 혼용 시 consume EOL 반드시 넣기
         *   - BufferedReader: 대량 입력 시 readLine() + parseInt() 패턴 사용
         *   - split: 패턴 끝/연속 구분자 가능성이 있으면 split(delim, -1) 습관화
         */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        String[] target = sc.nextLine().split("\\*", -1);         // keep trailing empty

        for (int i = 0; i < count; i++) {
            String s = sc.nextLine();
            if (s.length() < target[0].length() + target[1].length()) {
                System.out.println("NE");
                continue;
            }

            if (s.startsWith(target[0]) && s.endsWith(target[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
        // sc.close();        // 온라인 저지에서는 close 생략 권장
    }

}

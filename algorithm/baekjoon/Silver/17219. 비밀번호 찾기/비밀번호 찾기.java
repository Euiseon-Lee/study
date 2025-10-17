import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 🔐 BOJ 17219 비밀번호 찾기 – HashMap 기반 O(N+M) 조회 솔루션
		 *
		 * 💡 로직 구조
		 * - 입력 1줄: total(사이트-비번 쌍 개수), n(질의 개수)
		 * - 다음 total줄: "site password"를 Map<site, password>에 저장
		 * - 다음 n줄: site를 읽어 map.get(site)로 비밀번호 조회 후 StringBuilder에 누적 출력
		 *
		 * ⏱️ 복잡도/성능
		 * - 시간: 평균 O(total + n) (HashMap 평균 O(1) 조회/삽입 가정)
		 * - 공간: O(total) (사이트/비밀번호 문자열 보관)
		 * - I/O: BufferedReader + StringBuilder로 시스템 출력 호출 최소화
		 *
		 * ✅ 구현 평가
		 * - 요구 조건 충족: 정확성, 대용량 입력 처리, 출력 묶음 처리 모두 적절
		 * - 실무 활용도: Key-Value 캐시/사전 조회 패턴의 기본형 (권한/설정/코드값 매핑 등)
		 *
		 * 🧪 엣지/주의
		 * - 문제 보장상 모든 질의 key는 존재하지만, 일반화 시 map.get() == null 방어 필요
		 * - 사이트/비밀번호에 공백이 없다는 전제에 맞춰 단일 공백 분할로 파싱
		 *
		 * 🛠️ 보완 포인트
		 * 1) 초기 용량 지정으로 리해싱 방지
		 *    - new HashMap<>((int)(total / 0.75f) + 1)  → 재해시 최소화로 CPU 절감
		 * 2) 토크나이저 대신 단일 인덱스 분할
		 *    - line.indexOf(' ')로 분할 지점 찾고 substring 두 번 → 토큰화 오버헤드 감소
		 * 3) 일관된 final/의미 있는 식별자
		 *    - 가독성·오류 예방(불변 의도 명시)
		 *
		 * 📈 기대 효과(개선 적용 시)
		 * - 대입력(≈10^5)에서 수 ms~수십 ms 수준의 미세한 개선(리해싱 제거 + 경량 파싱)
		 *
		 * 🔁 대안(상황별)
		 * - 초고속 입력이 꼭 필요하면 BufferedInputStream 기반 커스텀 파서 고려
		 *   (여기선 표준 해법으로 충분)
		 *
		 * 🔚 결론
		 * - 현재 해법은 문제 스케일에 최적화된 정석 풀이.
		 * - 초기 용량 지정 + 경량 파싱만 더하면 제출 러닝 타임 변동성을 더 낮출 수 있음.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 초기 용량 지정으로 리해싱 최소화
        final int initialCapacity = (int) (total / 0.75f) + 1;
        final Map<String, String> map = new HashMap<>(initialCapacity);
        
        // total 줄: "site password"
        for (int i = 0; i < total; i++) {
            final String line = br.readLine();
            final int sp = line.indexOf(' ');
            // 문제 조건상 공백 하나로 구분되고 공백이 없는 토큰들이므로 안전
            final String site = line.substring(0, sp);
            final String pwd = line.substring(sp + 1);
            map.put(site, pwd);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }
}

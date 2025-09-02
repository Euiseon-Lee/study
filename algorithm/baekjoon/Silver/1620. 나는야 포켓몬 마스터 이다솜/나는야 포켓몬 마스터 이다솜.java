import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 문제 요약: 백준 1620 - 이름<->번호 양방향 조회
         * - 입력: N개 포켓몬 이름(1..N로 번호 매김), M개의 질의(이름 또는 번호)
         * - 출력: 이름이면 번호, 번호면 이름
         *
         * 🧠 핵심 로직(양방향 조회 최적화)
         * 1) 번호→이름: String[] nameById (1-based 인덱스)  ➜ O(1) 순수 인덱싱, 해시/박싱 비용 없음
         * 2) 이름→번호: HashMap<String, Integer> idByName   ➜ 평균 O(1) 해시 조회
         *
         * 🚀 왜 배열 + HashMap 조합인가?
         * - 번호는 1..N 연속 정수 ➜ 배열 인덱싱이 상수항/캐시 지역성 측면에서 최적
         * - 이름은 가변 문자열 ➜ 정렬/선형 탐색 비효율, 해시가 평균 O(1)로 최적
         * - Map만으로 처리 시
         *   (a) Integer→String, String→Integer 두 Map 필요(상수항/메모리↑), 또는
         *   (b) String 키로 "1"과 "Pikachu"를 모두 키로 등록(데이터 이중화/동기화 리스크)
         *   ➜ 배열+해시맵 조합이 메모리/속도/단순성의 균형이 가장 좋음
         *
         * 🧭 왜 HashMap인가?
         * - 요구사항: "빠른 조회" + "정렬 불필요" ➜ HashMap 평균 O(1)
         * - TreeMap은 O(log N)로 불필요하게 느림, LinkedHashMap의 순서 보존도 요구 없음
         * - 대용량 실무 대안: primitive 전용 해시맵(fastutil 등)로 박싱/GC 오버헤드 절감 가능
         *
         * 📈 성능/복잡도
         * - 빌드: 이름 N개를 1회 스캔 ➜ O(N)
         * - 질의: M개 각각 평균 O(1) ➜ O(M)
         * - 전체: O(N+M), 메모리: String 참조 N+1개 + 해시 엔트리 N개 (중복 저장 최소화)
         *
         * 🧪 엣지/주의
         * - 입력 번호는 1..N 범위(배열 1-based로 선언)
         * - 질의 구분: 첫 글자 숫자면 번호로 간주(Character.isDigit) ➜ 정규식 오버헤드 회피
         * - 문제 가정상 잘못된 질의는 주어지지 않음(추가 검증 불필요)
         *
         * 🛠 보완 포인트(실무 관점)
         * - 제네릭 명시: Map<String, Integer> idByName = new HashMap<>(initialCapacity);
         * - 초기 용량: (int)(pokemonCount / 0.75f) + 1 ➜ 리사이즈/rehash 최소화
         * - 상수/네이밍: 의미 있는 이름/상수화로 코드 의도 강화(final, 네이밍 일관성)
         * - I/O: StringBuilder에 '\n' append 후 마지막에 단일 출력(System.out.print(sb))
         *
         * ✅ 실무 수준 평가
         * - 설계: 양방향 조회에 최적 자료구조 조합 적용(👍)
         * - I/O/복잡도: N,M=10만 스케일에서 병목 없음(O(N+M))
         * - 개선 여지: 제네릭/초기용량/박싱 회피(대규모) 설명을 첨부하면 설득력 향상
         * - 상대적 위치: 실무형 구조 설계 Level 3 (다음 단계: 트레이드오프 표/캐시/GC 관점까지 기술)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pokemonCount = Integer.parseInt(st.nextToken());
        int questionCount = Integer.parseInt(st.nextToken());

        String[] pokemonName = new String[pokemonCount + 1];
        Map<String, Integer> pokemonNo = new HashMap();
        for (int i = 1; i <= pokemonCount; i++) {
            String temp = br.readLine();
            pokemonName[i] = temp;
            pokemonNo.put(temp, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questionCount; i++) {
            String question = br.readLine();

            if (Character.isDigit(question.charAt(0))) {
                sb.append(pokemonName[Integer.parseInt(question)]).append('\n');
            } else {
                sb.append(pokemonNo.get(question)).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

}

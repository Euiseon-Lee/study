import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 👂 BOJ 1764 듣보잡 – 교집합 탐색과 문자열 정렬
         *
         * 💡 로직 구조
         * - 입력: 듣도 못한 사람 N명, 보도 못한 사람 M명
         * - 목표: 두 명단의 교집합(듣보잡) 이름들을 사전순으로 출력
         * 
         * 1️⃣ 첫 번째 명단(N명): HashMap 또는 HashSet에 저장 (빠른 조회 목적)
         * 2️⃣ 두 번째 명단(M명): map.containsKey()로 교집합 확인 후 list에 저장
         * 3️⃣ 결과 list를 사전순 정렬(Collections.sort)
         * 4️⃣ 교집합 개수와 정렬된 이름을 출력
         *
         * ⏱️ 복잡도 분석
         * - 삽입: O(N)
         * - 조회: O(M)
         * - 정렬: O(K log K)  (K = 교집합 크기)
         * - 총합: O(N + M + K log K)
         * 
         * ⚙️ 성능 분석
         * - HashMap으로 평균 O(1) 조회 → 대용량에서도 안정적
         * - ArrayList + Collections.sort는 비교 기반 정렬로 안정적이며,
         *   사전순 요구조건(lexicographical order)에 정확히 부합
         * - 전체 I/O를 BufferedReader + StringBuilder로 처리해 출력 병목 없음
         * 
         * ✅ 구현 포인트
         * - HashMap 대신 HashSet을 써도 동일 동작 (값이 필요 없기 때문)
         * - 정렬 기준이 단순 사전순이므로 기본 compareTo()로 충분
         * - 입력 크기(N,M ≤ 500,000)에 대응 가능한 O(N+M) 탐색 구조
         *
         * 🛠️ 보완 포인트
         * 1) HashMap → HashSet으로 구조 단순화
         *    - map.put(key, 1) 대신 set.add(key)
         *    - containsKey() → contains()
         * 2) Collections.sort → list.sort(null) 로 변경 가능 (동일 기능, 가독성↑)
         * 3) I/O 개선 (선택): BufferedWriter를 사용해 대량 출력 시 더 안정적
         *
         * 🧩 실무 응용
         * - 두 집합 간 중복 항목 탐색, 공통 고객/로그/데이터 교집합 검출 등에 활용
         * - 문자열 키 기반 조회/정렬 구조의 기본 패턴
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            final String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (String name : list) {
            sb.append(name).append('\n');
        }
        System.out.print(sb);
    }
}

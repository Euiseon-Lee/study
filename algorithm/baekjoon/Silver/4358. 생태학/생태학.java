import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 4358 – 생태학
         *
         * 🧠 문제 요약
         * - 입력: 각 줄마다 나무 이름(EOF까지 주어짐, "exit" 같은 종료 토큰 없음)
         * - 출력: 전체 나무 수 대비 각 나무의 비율(%)을 소수점 4자리까지, 사전순으로 정렬
         *
         * ⚙️ 로직 구조
         * 1) while ((line = br.readLine()) != null) → EOF까지 읽기
         * 2) Map<String,Integer> 로 나무 이름별 등장 횟수 카운트
         * 3) 전체 카운트 대비 비율 = (100.0 * value / total)
         * 4) keySet을 사전순 정렬 후 "이름 비율" 출력
         *
         * 🚀 성능
         * - 시간복잡도: O(N log N) (입력 N줄 + 키 정렬 비용)
         * - 공간복잡도: O(K) (서로 다른 나무 종류 K개)
         *
         * 🔒 실무 활용 포인트
         * - ✅ 빈도수 집계(Frequency Counting): 로그, 이벤트, 태그, 에러 메시지별 발생 횟수
         * - ✅ 비율 계산: 전체 대비 비중 파악 → 트래픽 분석, 사용자 행동 패턴 분석
         * - ✅ 정렬 처리: 사람이 읽기 좋은 보고서/리포트 형태로 가공
         * - ✅ 스트림 입력 처리: EOF까지 읽는 패턴은 파일 처리, 네트워크 소켓, Kafka 소비자 등과 동일
         *
         * 🛠 확장 아이디어
         * - 발생 빈도 기준 정렬(Top-N 분석)으로 바꾸면 "가장 많이 발생한 이벤트" 분석 가능
         * - CSV/DB로 출력하여 대시보드 연동
         * - 실시간 스트림(예: Kafka)으로 바꾸면 대규모 로그 분석기로 확장 가능
         *
         * ✅ 정리
         * - 알고리즘 문제 풀이를 통해 "빈도 집계 + 비율 + 정렬 + 스트림 처리"라는
         *   데이터 처리의 기본기를 연습할 수 있음
         * - 실무 데이터 파이프라인에도 그대로 응용 가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        double count = 0.0;
        String tree;
        while ((tree = br.readLine()) != null) {
            count++;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            int value = map.get(key);
            String portion = String.format("%.4f", (100.0 * value / count));
            sb.append(key).append(' ').append(portion).append('\n');
        }
        System.out.print(sb);
    }

}

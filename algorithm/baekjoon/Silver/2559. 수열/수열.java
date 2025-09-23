import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🌡️ 백준 2559번 - 수열 (슬라이딩 윈도우)
         *
         * ✅ 핵심 로직
         * 1. 길이가 N인 온도 배열에서 연속된 K일의 합 중 최댓값을 찾는 문제
         * 2. "슬라이딩 윈도우" 기법 사용:
         *    - 첫 K일 합을 구한 뒤,
         *    - 이후엔 앞 요소를 빼고 새 요소를 더해 O(1)로 다음 구간 합을 갱신
         *    - 전체 시간복잡도는 O(N)
         *
         * ✅ 성능 분석
         * - 배열 순회 단 한 번: O(N)
         * - 추가 메모리는 합계와 최댓값을 저장하는 int 변수 정도 → O(1)
         * - N ≤ 100,000 범위에서도 충분히 빠름
         *
         * ✅ if vs Math.max()
         * - if문 방식:
         *   if (maxTemperature < sumTemperatures) maxTemperature = sumTemperatures;
         *   ➡️ 조건 비교 + 할당만 수행, 불필요한 함수 호출 없음
         *   ➡️ 루프가 매우 클 때는 미세하게 더 빠를 수 있음
         *
         * - Math.max 방식:
         *   maxTemperature = Math.max(maxTemperature, sumTemperatures);
         *   ➡️ 가독성이 좋고 의도가 명확함 ("최대값 업데이트"라는 의미가 드러남)
         *   ➡️ 내부 구현도 결국 if문이므로 차이는 거의 없음
         *
         * 🚀 결론:
         * - 알고리즘 문제 풀이: 둘 다 통과, 차이 무시 가능
         * - 성능-critical 코드 (수천만 루프 이상): if가 조금 더 유리
         * - 협업/가독성 중시 코드: Math.max()가 더 깔끔
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalDays = Integer.parseInt(st.nextToken());
        int consecutiveDays = Integer.parseInt(st.nextToken());
        int[] temperatures = new int[totalDays];
        st = new StringTokenizer(br.readLine());
        int sumTemperatures = 0;
        for (int i = 0; i < totalDays; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
            if (i < consecutiveDays) {
                sumTemperatures += temperatures[i];
            }
        }
        int maxTemperature = sumTemperatures;
        for (int i = consecutiveDays; i < totalDays; i++) {
            sumTemperatures = sumTemperatures - temperatures[i - consecutiveDays] + temperatures[i];
            if (maxTemperature < sumTemperatures) {
                maxTemperature = sumTemperatures;
            }
        }
        System.out.println(maxTemperature);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 📂 파일 확장자 정리 프로그램 (백준 20291번)
         *
         * ✅ 문제 요약
         * - 파일 이름을 입력받아 확장자별 개수를 세고
         * - 확장자를 사전순으로 정렬해 출력하는 문제
         *
         * ✅ 현재 코드 풀이 요약
         * - BufferedReader로 빠르게 입력을 처리
         * - 확장자를 split("\\.")로 분리해 ArrayList에 저장
         * - Collections.sort()로 정렬 후, 같은 확장자를 카운트해 출력
         *
         * ✅ 잘한 점
         * 1. 📝 입력 처리  
         *    - BufferedReader 사용으로 대량 입력에서도 안정적임.
         *    - n개 파일을 for문으로 깔끔하게 처리.
         *
         * 2. 🧩 핵심 로직 단순화  
         *    - split("\\.")로 확장자만 추출하는 부분이 직관적.
         *    - 정렬 후 순회하면서 count 세는 방식은 구현 난도가 낮고 가독성도 좋음.
         *
         * 3. 📊 출력 로직  
         *    - 확장자가 바뀔 때마다 이전 확장자와 개수를 출력하는 방식이 적절함.
         *
         * ✅ 보완 포인트
         * 1. ⚡ 성능
         *    - ArrayList에 넣고 sort → O(N log N)  
         *      문제 조건(N ≤ 50,000)에서는 충분히 통과 가능.  
         *      하지만 **HashMap<String, Integer> + TreeMap** 구조를 쓰면  
         *      O(N log M) (M=확장자 종류 수)로 더 깔끔해짐.  
         *      (확장자가 많지 않기 때문에 더 효율적이고 직관적)
         *
         * 2. 🛠 코드 구조
         *    - arr.add(...split()[1])에서 split을 직접 반복 호출 → 성능적으로 큰 문제는 없으나,  
         *      `String[] parts = line.split("\\."); String ext = parts[1];`  
         *      로 명시적으로 변수 분리하면 가독성이 더 좋아짐.
         *
         * 3. 🧹 불필요 반복문
         *    - 마지막 출력 부분에서 if (i == n-1) 조건문이 들어가는데,  
         *      HashMap을 활용하면 이런 처리가 필요 없음.  
         *      자료구조 활용 → 출력 로직 단순화 가능.
         *
         * 4. 📦 확장성
         *    - 지금은 확장자만 카운트하는 문제지만,  
         *      만약 파일 이름별 분류나 정렬이 추가되면 **Map 자료구조** 기반 접근이 훨씬 유지보수에 좋음.
         *
         * ✅ 현재 실력 레벨 진단
         * - 문제 풀이 자체는 정확하고 깔끔함 → **Level 3 (실무형 기본기 보유)**  
         * - 하지만 자료구조 선택에서 조금 더 “적합한 도구”를 고르는 훈련 필요.  
         *   (ex: 단순 정렬 기반 vs Map 기반)  
         * - 지금 방식은 "문제 통과용 풀이"로는 충분하지만,  
         *   "실무 유지보수" 시에는 Map 구조를 먼저 고려하는 습관이 필요.
         *
         * ✅ 보완 학습 방향
         * 1. HashMap, TreeMap, LinkedHashMap의 차이와 활용 상황 정리
         * 2. Collections.sort() vs Stream.sorted() 비교 학습
         * 3. 데이터 카운팅 문제에서 Map을 언제 활용하는 게 좋은지 연습
         *
         * 🚀 결론
         * - 지금 풀이도 충분히 정답이고 효율적임 👍  
         * - 다만 실무/면접에서는 "자료구조 선택 근거"를 설명할 수 있어야 차별화됨.  
         *   → “정렬 기반 vs Map 기반, 어떤 게 더 적합했는가?”를 고민하는 훈련이 성장 포인트!
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine().split("\\.")[1]);
        }
        Collections.sort(arr);
        String str = arr.get(0);
        int count = 0;
        for (int i = 0; i < n; i++) {
            String temp = arr.get(i);
            if (str.equals(temp)) {
                count++;
            } else {
                System.out.println(str + " " + count);
                str = temp;
                count = 1;
            }

            if (i == n - 1) {
                System.out.println(str + " " + count);
            }
        }
    }
}

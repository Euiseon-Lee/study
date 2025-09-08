import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 1940 - 주몽의 명령 : 투 포인터(two pointers) 해법 정리
         *
         * 🧠 문제 요약
         * - 길이 N의 정수 배열에서 합이 M이 되는 "서로 다른 두 원소" 쌍의 개수를 구한다.
         * - 각 원소는 최대 한 번만 사용 가능(소모). 중복 값은 존재할 수 있다.
         *
         * 🔧 핵심 아이디어(투 포인터)
         * - 배열을 오름차순 정렬한 뒤, 양끝 인덱스 l, r을 두고 합 s = a[l] + a[r]을 비교한다.
         *   1) s == M  → 한 쌍 성립 → 정답++ 후 l++, r-- (두 원소 소모)
         *   2) s <  M  → 합을 키워야 함 → l++  (작은 쪽을 오른쪽으로)
         *   3) s >  M  → 합을 줄여야 함 → r--  (큰  쪽을 왼쪽으로)
         * - 정렬 덕분에 "합이 작으면 왼쪽을 키우고, 크면 오른쪽을 줄인다"라는 단조 이동이 보장된다.
         *
         * 🧷 불변식(Invariant)
         * - 매 반복에서 인덱스 구간 [l, r]은 아직 소모되지 않은 후보 구간이다.
         * - 정렬 상태: l를 오른쪽으로 옮기면 a[l]은 비 non-decreasing, r을 왼쪽으로 옮기면 a[r]은 비 non-increasing.
         * - s<M이면 l을 1 올려야만 s가 커질 수 있고, s>M이면 r을 1 내려야만 s가 작아질 수 있다. (필요충분)
         *
         * ✅ 올바름(Correctness) 스케치
         * - s==M인 순간에 l, r을 동시에 이동(l++, r--)하면 한 원소를 중복 사용하지 않는다.
         * - s<M에서 r--는 불필요: r을 줄이면 합은 더 작아질 수도 있어 s==M을 지나칠 위험만 커진다.
         * - s>M에서 l++는 불필요: l을 늘리면 합이 더 커질 수 있어 s==M을 지나칠 위험만 커진다.
         *
         * ⏱️ 성능
         * - 정렬 O(N log N) + 포인터 스캔 O(N) → 총 O(N log N)
         * - 추가 메모리 O(1)
         *
         * 🧪 엣지 케이스
         * - N<2 → 정답 0
         * - 중복 값(예: [1,1,1,1], M=2) → s==M 때마다 l++, r-- 처리로 정확히 쌍 수만큼 카운트
         * - 음수/양수 혼재, 매우 큰/작은 값 모두 정렬 후 동일 규칙 적용
         *
         * 🛠 흔한 실수
         * - s==M에서 l만 올리거나 r만 내리면 "한 원소를 다시 사용할" 위험 → 반드시 l++, r-- 함께
         * - l<=r로 조건을 쓰면 같은 원소를 두 번 더하는 경우 발생 → while(l<r)만 사용
         * - 정렬 누락 → 투 포인터의 단조 이동 근거가 깨짐
         *
         * 🔄 HashMap 해법과의 트레이드오프
         * - HashMap: 평균 O(N), 구현 간단, 단 박싱/메모리 오버헤드 존재
         * - 투 포인터: O(N log N)이나 추가 메모리 거의 0, 중복/동일값 처리가 자연스럽고 안정적
         * - 입력이 매우 큰 경우나 메모리가 타이트하면 투 포인터가 유리할 수 있다.
         *
         * 🧭 구현 팁
         * - Arrays.sort 사용 후, int l=0, r=N-1, while(l<r)
         * - 합 비교 후 포인터 이동은 "정확히 하나의 분기"만 실행되도록 if/else if/else 구조로
         * - 입출력: BufferedReader 사용, StringTokenizer로 빠르게 파싱
         *
         * 🔍 참고용 예시 코드(주석 내 스니펫)
         *
         *   import java.io.*;
         *   import java.util.*;
         *
         *   public class TwoPointersExample {
         *       public static void main(String[] args) throws Exception {
         *           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         *           int n = Integer.parseInt(br.readLine());
         *           int m = Integer.parseInt(br.readLine());
         *
         *           int[] a = new int[n];
         *           StringTokenizer st = new StringTokenizer(br.readLine());
         *           for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
         *
         *           Arrays.sort(a);                 // 1) 정렬
         *           int l = 0, r = n - 1, ans = 0;
         *
         *           while (l < r) {                 // 2) 양끝에서 좁혀오기
         *               long s = (long)a[l] + a[r]; // 오버플로우 방지 여유(필요 시)
         *               if (s == m) {               // 3-1) 정답이면 양쪽 소모
         *                   ans++;
         *                   l++;
         *                   r--;
         *               } else if (s < m) {         // 3-2) 합이 작으면 l++
         *                   l++;
         *               } else {                    // 3-3) 합이 크면 r--
         *                   r--;
         *               }
         *           }
         *           System.out.println(ans);
         *       }
         *   }
         *
         * 📌 미세 최적화/안전성
         * - s를 int로 더해도 범위 내면 괜찮지만, 입력 범위가 넓다면 long으로 캐스팅하여 안전하게 합산
         * - 입력 줄 분할 가능성 있으면 while(!st.hasMoreTokens())로 보충 파싱
         *
         * 🏁 결론
         * - 투 포인터는 "정렬 + 양끝 단조 이동"으로 합 문제를 O(N) 스캔으로 해결하는 표준 기법이다.
         * - HashMap 대비 메모리를 아끼고, 중복/동일값을 자연스럽게 처리한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int materialCount = Integer.parseInt(br.readLine());
        int shieldMaterial =  Integer.parseInt(br.readLine());
        int[] materialList = new int[materialCount];
        Map<Integer, Integer> materials = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < materialCount; i++) {
            int target = Integer.parseInt(st.nextToken());
            materialList[i] = target;
            materials.put(target, materials.getOrDefault(target, 0) + 1);
        }
        int answer = 0;
        for (int i = 0; i < materialCount; i++) {
            int standard = materialList[i];
            if (materials.getOrDefault(standard, 0) == 0) continue;
            materials.put(standard, materials.get(standard) - 1);
            int needed = shieldMaterial - standard;
            if (materials.getOrDefault(needed, 0) > 0) {
                answer++;
                materials.put(needed, materials.get(needed) - 1);
            }
        }
        System.out.println(answer);
    }
}


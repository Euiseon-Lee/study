import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        /**
         * ✅ 문제 해결 전략 요약
         * 
         * 📌 목적: arr에서 앞쪽부터 중복 없이 최대 k개의 값을 뽑고,
         *         부족한 자리는 -1로 채운다.
         *
         * 🚀 로직 흐름:
         *   1️⃣ 정답 배열을 -1로 초기화 (크기 k)
         *   2️⃣ Set을 활용해 중복 여부 확인
         *   3️⃣ arr 순회하며 중복되지 않은 수만 answer에 삽입
         *   4️⃣ 삽입 개수(idx)가 k가 되면 루프 종료
         *
         * ⚙️ 성능 및 구조 이점:
         *   - HashSet으로 빠른 중복 검사 → 평균 O(1)
         *   - 최대 k개만 삽입 → 조기 종료로 성능 최적화
         *   - 추가 자료구조 최소 사용
         *
         * 💼 실무 활용도:
         *   - 중복 제거된 순차 리스트 생성
         *   - 캐시, 추천, 최근 기록 필터링 등 응용 가능
         *
         * 🧩 확장 포인트:
         *   - 순서 유지가 중요할 경우 LinkedHashSet으로도 가능
         *   - 삽입 대상에 조건이 더 붙을 경우 Predicate 등 활용 고려
         *
         * 🧠 현재 실력 피드백:
         *   🎯 GPT 기준 Level 4 중후반
         *   🔍 배열, Set, 중복제거 등 기초 자료구조를 실전형으로 잘 응용
         *   ☑️ 실무에서 활용도 높은 패턴에 익숙해졌고,
         *      문제 이해력과 구현 정확도가 매우 안정적
         */
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) answer[i] = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0, idx = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!set.contains(num)) {
                set.add(num);
                answer[idx++] = num;
                if (idx == k) break;
            }
        }
        return answer;
    }
}

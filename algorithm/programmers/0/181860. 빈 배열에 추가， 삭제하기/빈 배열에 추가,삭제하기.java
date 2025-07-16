class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        /**
         * ✅ 0️⃣1️⃣ 문제 풀이 설명
         * - 정수 배열 arr, 불리언 배열 flag를 이용해 새로운 배열을 생성한다.
         * - flag[i]가 true면 arr[i]를 2배만큼 복제하여 추가
         * - flag[i]가 false면 마지막에 추가된 arr[i]개를 제거한다
         *
         * ✅ 0️⃣2️⃣ StringBuilder 방식
         * ⚡ 성능 우수 (0.2ms 내외)
         * - 내부 char 배열로 append/remove 처리
         * - 최종 결과는 char -> int로 변환 (추가 변환 비용 존재)
         * 💡 메모리 사용량 적고 속도 빠름
         * ❗ 숫자를 문자로 저장하고 다시 파싱하므로 직관성은 낮음
         *
         * ✅ 0️⃣3️⃣ List<Integer> 방식
         * 💬 실무 가독성 및 유지보수에 유리
         * - 숫자를 그대로 저장하므로 데이터 직관성 ↑
         * - 로직이 명확하게 보이며 타입 안정성 있음
         * ❗ remove(size - 1)를 반복할 경우 GC/메모리 낭비 ↑
         * ❗ 대용량 처리 시 성능 저하 가능성 있음
         *
         * ✅ 0️⃣4️⃣ List<Integer> 버전 예시 (가독성 위주)
         *
         * List<Integer> list = new ArrayList<>();
         * for (int i = 0; i < arr.length; i++) {
         *     if (flag[i]) {
         *         for (int j = 0; j < arr[i] * 2; j++) list.add(arr[i]);
         *     } else {
         *         for (int j = 0; j < arr[i]; j++) list.remove(list.size() - 1);
         *     }
         * }
         * return list.stream().mapToInt(i -> i).toArray();
         *
         * ✅ 0️⃣5️⃣ 실무 평가 및 성장 포인트
         * 🎓 현재 수준: GPT 기준 Level 4 진입 (문제 해결력 + 실무 구조 모두 고려)
         * 🔍 성장 전략:
         * - 자료구조별 성능 특성과 선택 기준 명확히 익히기
         * - 메모리 효율 vs 가독성의 균형을 실무 상황에 따라 판단할 수 있어야 함
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (flag[i]) {
                sb.append(String.valueOf(num).repeat(num * 2));
            } else {
                sb.replace(sb.length() - num, sb.length(), "");
            }
        }
        int[] answer = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            answer[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        return answer;
    }
}

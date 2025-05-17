class Solution {
    public int[] solution(String[] wallpaper) {
        /*
         * ❌ 내가 처음 작성한 코드의 실수 요약
         *
         * [1] 좌표 범위를 최솟값/최댓값으로 추적하지 않음
         *     - startRow, startCol은 첫 '#'에서만 설정됨 → 이후 더 위/왼쪽에 '#'이 있어도 무시됨
         *     - endRow, endCol은 "마지막 발견된 값"만 덮어씀 → 가장 아래/오른쪽 '#'이 아닐 수 있음
         *     → 해결: start는 Math.min(), end는 Math.max()로 갱신해야 함
         *
         * [2] endRow, endCol에 +1을 안 함
         *     - 문제에서 원하는 건 사각형의 "오른쪽 아래 끝 + 1" 좌표임
         *     - 이유: 배열 슬라이싱 범위는 [시작, 끝) 이기 때문
         *     → 해결: return 시 endRow + 1, endCol + 1 필요
         *
         * [3] 잘못된 초기값 (-1) 사용
         *     - 최소값 계산 시 startRow = -1로 시작하면 Math.min()으로 갱신 불가
         *     - max 비교도 마찬가지 → 최소/최대 갱신용으로는 극단값 (Integer.MAX/MIN) 사용해야 안정적
         *
         * ✅ 교훈: 범위 스캔 문제에서 "최소/최대 갱신" 로직은 반드시 명시적으로 작성해야 함
         */
        int startRow = Integer.MAX_VALUE, startCol = Integer.MAX_VALUE
          , endRow = Integer.MIN_VALUE, endCol = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            String rowInfo = wallpaper[i];
            for (int j = 0; j < rowInfo.length(); j++) {
                char tmp = rowInfo.charAt(j);
                if (tmp == '#') {
                    startRow = Math.min(startRow, i);
                    startCol = Math.min(startCol, j);
                    endRow = Math.max(endRow, i);
                    endCol = Math.max(endCol, j);
                } else {
                    continue;
                }
            }
        }
        return new int[] {startRow, startCol, endRow + 1, endCol + 1};
    }
}

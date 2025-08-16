class Solution {
    public int[][] solution(int n) {
        /**
         * 🌀 Spiral Fill with Boundary Pointers
         *
         * ✅ 핵심 아이디어
         * - top/bottom/left/right 네 개의 경계 포인터를 두고 한 겹(layer)씩 시계방향으로 채운다.
         * - 한 라운드 = 가로(→) → 세로(↓) → 가로(←) → 세로(↑) 순으로 1차 for문 4개 수행 후, 경계를 안쪽으로 이동(top++, right--, bottom--, left++).
         *
         * ⚙️ 로직 개요
         * 1) 위쪽 행: row=top, col=left..right  채우고 top++
         * 2) 오른쪽 열: col=right, row=top..bottom 채우고 right--
         * 3) 아래쪽 행: row=bottom, col=right..left 채우고 bottom--
         * 4) 왼쪽 열: col=left, row=bottom..top 채우고 left++
         * - 반복 조건: while (top <= bottom && left <= right)
         *
         * 🧪 안전 가드(권장)
         * - 경계를 이동시킨 뒤에는 다음 구간이 유효한지 점검하면 off-by-one 및 이중 채움 방지에 안전하다.
         *   예)
         *   // 위/오 처리 후
         *   if (top <= bottom) { 아래쪽 행(←) 처리 }
         *   if (left <= right) { 왼쪽 열(↑) 처리 }
         *
         * 📈 성능
         * - 시간복잡도: O(n^2) (모든 셀을 1회 방문)
         * - 공간복잡도: O(n^2) (출력 배열 외 추가 구조 없음)
         *
         * 🧩 실무 적용 포인트
         * - 테이블/그리드 생성, 보고서 레이아웃, 타일/이미지 라스터 처리 등 “영역 축소 + 단방향 스윕” 패턴으로 재사용 용이.
         * - 방향 배열만 바꾸면 반시계/지그재그/대각 스캔 등 변형 용이.
         */
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int num = 1;
        int[][] answer = new int[n][n];
        while (top <= bottom && left <= right) {
            for (int col=left; col<=right; col++) answer[top][col] = num++;
            top++;

            for (int row=top; row<=bottom; row++) answer[row][right] = num++;
            right--;

            for (int col=right; col>=left; col--) answer[bottom][col] = num++;
            bottom--;

            for (int row=bottom; row>=top; row--) answer[row][left] = num++;
            left++;
        }
        return answer;
    }
}

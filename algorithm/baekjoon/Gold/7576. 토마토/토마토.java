import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🍅 BOJ 7576 토마토 – 멀티 소스 BFS로 최단일수 전파 계산
         *
         * 🧩 문제 개요
         * - 격자 보관소에 토마토 상태가 주어짐: 1(익음), 0(안 익음), -1(없음)
         * - 하루가 지날 때마다 익은 토마토가 상/하/좌/우 인접 칸의 안 익은 토마토를 익게 함
         * - 모든 토마토가 익을 때까지 최소 일수를 구하되, 불가능하면 -1
         *
         * 💡 핵심 아이디어 – 멀티 소스 BFS
         * - “동시에 전파”되는 현상 → BFS의 레벨(거리) = 날짜
         * - 익은 토마토(1)들을 모두 큐에 먼저 담아 0일(또는 1일)부터 동시에 출발
         * - 전파 시 다음 칸의 날짜 = 현재 날짜 + 1 로 기록 (덮어쓰기 방식)
         *
         * ⚙️ 로직 절차
         * 1) 입력 파싱: 가로 M, 세로 N (board[N][M]) 주의
         * 2) 큐 초기화: 모든 1의 좌표를 큐에 삽입
         * 3) BFS: 4방향으로 확장하며 0인 칸만 갱신(board[ny][nx] = board[y][x] + 1)
         * 4) 종료 후:
         *    - board에 0이 남아 있으면 → 미도달 존재 → -1
         *    - 아니면 board의 최댓값(max)을 구해, 시작 오프셋(1 → 0일) 보정해 정답 = max - 1
         *
         * ⏱️ 복잡도
         * - 시간: O(N*M) – 각 칸 최대 한 번 방문
         * - 공간: O(N*M) – 큐/격자 저장
         *
         * 🛠️ 구현 포인트
         * - ArrayDeque<int[]> 사용 (x,y를 함께 저장)
         * - 범위 체크, -1(벽/빈칸) 스킵, 0만 업데이트
         * - 1부터 누적 저장 시 정답은 (max - 1)
         *
         * ⚠️ 자주 틀리는 포인트
         * - 모든 시작점(1)을 “동시에” 큐에 넣어야 함
         * - M(열), N(행) 순서 주의 → board[row][col] = board[y][x]
         * - 0이 남아 있으면 -1, 아니면 (max - 1)
         *
         * 🧠 확장
         * - 3D(7569): (z,y,x) 6방향 BFS
         * - 서로 다른 전파체: BFS 순서/계층을 분리하거나, 상태값을 분리 관리
         */
        int[] X = {1, -1, 0, 0};
        int[] Y = {0, 0, 1, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.addLast(new int[]{j, i});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            int x = current[0], y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + X[d];
                int ny = y + Y[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (board[ny][nx] != 0) continue;

                board[ny][nx] = board[y][x] + 1;
                q.addLast(new int[]{nx, ny});
            }
        }
        int max = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == 0) {
                    System.out.print(-1);
                    return;
                }
                max = Math.max(max, board[y][x]);
            }
        }
        System.out.print(max == 0 ? 0 : max - 1);
    }
}


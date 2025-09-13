import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 🎯 문제/목표(BOJ 17276): n×n(홀수) 행렬을 degree(45의 배수)만큼 회전.
     *     단, 45도 단위 회전은 "배열 전체"를 돌리는 게 아니라
     *     ① 주대각선 (i,i), ② 중앙열 (i, mid), ③ 부대각선 (i, n-1-i), ④ 중앙행 (mid, i)
     *     이 네 개의 선만 서로 자리를 바꾸는 규칙으로 정의된다.
     *
     * 🧠 전역 변수와 의미
     * - int n           : 배열 크기 (홀수)
     * - int degree      : 입력 각도(양수=시계, 음수=반시계). 구현에서는 k로 정규화해 사용
     * - String[][] array: 현재 상태(쓰기 대상)
     * - String[][] copy : 직전 상태의 스냅샷(읽기 전용; 매 회전마다 깊은 복사로 갱신)
     *
     * 🔁 회전 횟수 정규화(시계 방향 기준)
     * - k = ((degree % 360) + 360) % 360 / 45
     *   → degree가 -720, -405 처럼 커도 0~7 범위의 반복 횟수로 정규화
     *   → 이렇게 하면 구현은 "시계 +45°"만 처리해도 됨(반시계 입력 포함).
     *
     * 🧭 +45°(시계) 한 스텝의 이동 규칙(인덱스 불변식)
     *   mid = n / 2  (중앙 인덱스. i와 무관하게 '상수'여야 함)
     *   각 i = 0..n-1에 대해 다음 4개만 이동(읽기: copy, 쓰기: array):
     *   1) (i, i)         → (i, mid)        // 주대각선   → 중앙열  (행 유지, 열=mid로)
     *   2) (i, mid)       → (i, n-1-i)      // 중앙열     → 부대각선(행 유지, 열=n-1-i로)
     *   3) (i, n-1-i)     → (mid, n-1-i)    // 부대각선   → 중앙행  (열 유지, 행=mid로)
     *   4) (mid, i)       → (i, i)          // 중앙행     → 주대각선(대각 방면으로 복귀)
     *   ※ 네 선 외의 나머지 좌표는 "그대로 유지"되어야 하므로 건드리지 않는다.
     *
     * 🧷 스냅샷/깊은 복사가 필요한 이유
     * - 같은 스텝 내에서 읽기-쓰기가 섞이면 원본이 오염된다.
     * - 매 스텝 시작 시 copy[r] = array[r].clone()로 각 행을 복제(깊은 복사)해
     *   copy에서만 읽고 array에만 쓴다. 마지막에 array를 copy로 덮어쓰지 않는다.
     *
     * 🧪 작은 예시(n=5, mid=2)에서 i=1 라인 흐름
     * - (1,1)→(1,2)→(1,3)→(2,3)→(1,1) 처럼 4개 선이 링처럼 순환
     * - i=0..4 모두 같은 패턴을 독립적으로 적용
     *
     * 🚀 복잡도
     * - 스텝당 O(n) (이동 좌표 4n개만 갱신), k ≤ 8 → 전체 O(n)
     * - 공간: O(n) (copy 스냅샷)
     *
     * 🚫 흔한 실수
     * - mid를 i/2로 계산(행마다 달라져 오동작) → 항상 n/2
     * - Arrays.copyOf, array.clone 같은 얕은 복사 사용 → 행 공유로 원본 오염
     * - 4개 선 외의 좌표를 건드림 → 문제 정의 위배
     * - 스냅샷 후 결과를 다시 copy로 덮어써서 변경사항 소거
     *
     * ✅ 구현 체크리스트(너의 변수/함수 기준)
     * 1) main에서 k 계산: ((degree % 360) + 360) % 360 / 45
     * 2) while (k-- > 0) rotateArray();
     * 3) rotateArray() 시작 시 copy를 깊은 복사로 갱신
     * 4) mid = n/2; 각 i에 대해 위 4개 이동만 array에 기록(읽기는 copy)
     * 5) 나머지 좌표는 array의 기존 값 유지(건드리지 않음)
     */
    static int n, degree;
    static String[][] array, copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            degree = Integer.parseInt(st.nextToken());
            int k = ((degree % 360) + 360) % 360 / 45;
            array = new String[n][];
            for (int j = 0; j < n; j++) {
                array[j] = br.readLine().split(" ");
            }
            while(k-- > 0) rotateArray();
            for(String[] arr : array){
                for(String a : arr) {
                    sb.append(a + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    /**
     * 🧩 rotateArray() 상세 가이드
     *
     * 입력/상태
     * - array: 직전까지의 결과가 담긴 2차원 배열(이번 스텝의 "쓰기 대상")
     * - n    : 배열 크기, 홀수
     *
     * 절차
     * 1) copy 준비(깊은 복사)
     *    copy = new String[n][];
     *    for r in [0..n-1]: copy[r] = array[r].clone();
     *    → 이제 이 스텝 동안 "원본은 copy", "결과는 array"로 역할이 분리됨.
     *
     * 2) 인덱스 준비
     *    int mid = n / 2; // 중앙 인덱스. 스텝 내내 '상수'
     *
     * 3) 4개 선만 시계 +45°로 이동(읽기: copy, 쓰기: array)
     *    for i in [0..n-1]:
     *      array[i][mid]      = copy[i][i];          // 주대각(i,i)     → 중앙열(i,mid)
     *      array[i][n-1-i]    = copy[i][mid];        // 중앙열(i,mid)   → 부대각(i,n-1-i)
     *      array[mid][n-1-i]  = copy[i][n-1-i];      // 부대각(i,n-1-i) → 중앙행(mid,n-1-i)
     *      array[i][i]        = copy[mid][i];        // 중앙행(mid,i)   → 주대각(i,i)
     *
     *    주의:
     *    - 네 줄 이외의 좌표는 array에 아무 것도 쓰지 않음(= 기존 값 그대로 유지).
     *    - 대입 방향은 항상 array[...] = copy[...]; (반대로 쓰지 않기)
     *
     * 4) 종료
     *    - 스텝이 끝났을 때 array에는 새 상태가 완성되어 있음.
     *    - copy로 array를 다시 덮어쓰는 루프는 금지(결과가 사라짐).
     *
     * 검증 팁
     * - n=5로 작은 케이스를 손으로 적고 i=0..4를 따라가며
     *   주대각/중앙열/부대각/중앙행만 바뀌는지 체크.
     * - degree를 45, 90, 135, 180 등으로 주고 k=1,2,3,4가
     *   기대대로 반복 적용되는지 출력 비교.
     */
    private static void rotateArray() {
        copy = new String[n][];
        for (int r = 0; r < n; r++) {
            copy[r] = array[r].clone();
        }
        int mid = n / 2;
        for(int i = 0; i < n ; i++){
            array[i][mid] = copy[i][i];
            array[i][n - 1 - i] = copy[i][mid];
            array[mid][n - 1 - i] = copy[i][n - 1 - i];
            array[i][i] = copy[mid][i];
        }
    }

}

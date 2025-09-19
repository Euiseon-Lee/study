import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧩 BOJ 1546 – 평균 (배열 없이 풀기)
         *
         * 🧠 핵심 아이디어
         * - 모든 점수를 다 저장할 필요 없음.
         * - 합계(sum)와 최고점(max)만 있으면 결과 계산 가능.
         *
         * 🚀 성능 이점
         * - 메모리 O(1): n 크기와 상관없이 변수 몇 개만 유지
         * - 속도도 O(n): 점수 입력을 한 번만 순회
         *
         * ✅ 실무 연결
         * - 로그 분석, 대용량 데이터 처리 시 "필요한 값만 유지"하는 방식 → 스트리밍 처리와 유사
         */
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double sum = 0.0;
        double max = 0.0;

        for (int i = 0; i < n; i++) {
            double score = Double.parseDouble(st.nextToken());
            sum += score;
            if (score > max) max = score;
        }

        double average = (sum / max * 100.0) / n;
        System.out.println(average);

        /* 기존 배열을 사용한 버전
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] subjects = new double[n];
        double highestScore = 0.00;
        for (int i = 0; i < n; i++) {
            subjects[i] = Double.parseDouble(st.nextToken());
            if (subjects[i] > highestScore) {
                highestScore = subjects[i];
            }
        }
        final double P = 100.00;
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            total += subjects[i] / highestScore * P;
        }
        System.out.print(total / (double) n);
        */
    }
}

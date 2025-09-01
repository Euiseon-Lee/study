import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔢 숫자 토큰 추출 & 정렬 (BOJ 2870)
         *
         * 🧩 문제 포인트
         * - 각 줄에서 "연속된 숫자(\\d+)" 덩어리만 모두 추출
         * - 선행 0은 제거해도 됨 → BigInteger 파싱으로 자연스럽게 해결
         * - 전체 숫자를 비내림차순(오름차순)으로 출력
         *
         * 🧱 자료구조/알고리즘
         * - 정규식 Pattern("\\d+") + Matcher.find(): 숫자 토큰만 안전 추출 (빈 토큰 0%)
         * - ArrayList<BigInteger>에 수집 후 Collections.sort()로 정렬
         * - 출력은 StringBuilder로 누적 후 1회 출력 (I/O 최소화)
         *
         * ⏱ 성능
         * - 매칭: O(totalChars), 정렬: O(M log M) (M=추출된 숫자 개수)
         * - 입력 한계(100줄 × 100자)에서 충분히 여유
         *
         * 🛡️ 예외/경계
         * - 숫자가 없는 줄은 건너뜀 (Matcher.find()가 매치 없으면 추가 없음)
         * - 아주 긴 숫자도 BigInteger로 안전 (오버플로우 없음)
         * - 출력 형식: 한 줄에 하나, 비내림차순
         *
         * 🧭 구현 요령
         * - "치환 후 split" 대신 "find 매칭"을 사용해 빈 토큰/경계 버그 제거
         * - StringBuilder에 '\n'로 줄바꿈 누적 후 마지막에 1회 출력
         *
         * 🏭 실무 시사점
         * - 정규식은 "필요한 것만 추출"에 사용하고, 불필요한 치환은 피한다(부수효과/빈 토큰 방지)
         * - 숫자 길이 제약이 불명확할 땐 BigInteger로 파싱해 오버플로 리스크 제거
         * - 출력은 가능한 한 버퍼링하여 I/O 호출 횟수를 줄인다
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        Pattern digits = Pattern.compile("\\d+");
        ArrayList<BigInteger> list = new ArrayList<>();

        for (int i = 0; i < line; i++) {
            String s = br.readLine();
            Matcher m = digits.matcher(s);
            while (m.find()) {
                list.add(new BigInteger(m.group()));
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (BigInteger i : list) {
            sb.append(i.toString()).append("\n");
        } 
        System.out.println(sb.toString());
    }

}

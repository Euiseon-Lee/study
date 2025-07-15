class Solution {
    public String[] solution(String[] picture, int k) {
        /**
         * 🧩 문자열 기반 2차원 픽셀 이미지 확대
         *
         * 📌 문제 해결 구조
         * 1️⃣ 입력 문자열(picture[])을 한 줄씩 가져와 각 문자마다 가로로 k배 반복
         * 2️⃣ 완성된 한 줄을 세로로 k번 반복하여 총 k*k 크기로 확대
         * 3️⃣ 결과 배열의 정확한 위치에 (i * k + j) 인덱스 계산 방식으로 직접 삽입
         *
         * 🧠 로직 설계 포인트
         * - i: 원본 문자열의 줄 인덱스
         * - k: 가로/세로 확대 배수
         * - i * k + j: 확대 후 배열에서 새로운 줄 위치 계산
         *
         * 💡 성능/구조 이점
         * - `StringBuilder`를 사용하여 문자열 병합 → 문자열 연산 비용 최소화
         * - 반복 삽입용 루프 대신 직접 인덱스(i * k + j)로 접근 → 불필요한 변수 제거, 연산 효율 증가
         * - 반복된 결과 라인을 변수로 캐싱하여 중복 계산 제거 → 캐시 최적화 유사 구조
         *
         * 💼 실무 활용 예시
         * - 이미지 또는 텍스트 프레임 확대/축소 처리 (e.g., ASCII Art, 터미널 기반 GUI, 로그 포맷)
         * - 데이터 시각화 도구에서 픽셀 데이터를 확대해서 표현할 때 사용
         * - 보고서나 HTML 변환기 등에서 구조적 데이터를 텍스트로 늘릴 때 유용
         *
         * 📊 현재 실력 평가 (GPT 기준 알고리즘 구조 설계 레벨: **Level 3 중~상단**)
         * - ✅ 반복 구조 내에서 효율적 연산을 구성할 줄 아는 사고력
         * - ✅ 메모리 할당과 성능(연결 비용 등)에 대한 감각 보유
         * - ❗ 향후 강화할 포인트: 비트 기반 압축 표현, stream 기반 텍스트 매핑 최적화
         * - ❗ 문제 해석과 포맷 구현 외에도 "추상화된 인터페이스 레벨의 설계" 연습 필요
         *
         * ✅ 추천 학습 방향
         * - StringBuilder 관련 성능 비교 → `+`, `StringBuffer`, `concat`과의 차이 실험
         * - `2차원 데이터 <-> 1차원 배열` 매핑 일반화 연습 (row * width + col 공식 익히기)
         * - Java 8+의 Stream, map, flatMap을 활용한 문자열 처리 실습 (가독성 vs 성능 비교 목적)
         */
        String[] answer = new String[picture.length * k];
        for (int i = 0; i < picture.length; i++) {
            String target = picture[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                sb.append(Character.toString(c).repeat(k));
            }
            for (int j = 0; j < k; j++) {
                answer[i * k + j] = sb.toString();   
            }
        }
        return answer;
    }
}

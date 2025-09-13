class Solution {
    /**
     * 📌 2021 KAKAO BLIND RECRUITMENT – 신규 아이디 추천 (문자열 정규화 파이프라인)
     *
     * 🧠 요구 조건(7단계 규칙)
     * 1) 대문자 → 소문자
     * 2) 허용 문자만 통과: [a-z][0-9][-][_][.]
     * 3) 연속된 '.'은 하나로 축약
     * 4) 선행/후행 '.' 제거
     * 5) 빈 문자열이면 "a"
     * 6) 길이 > 15 → 15자로 자른 뒤, 끝 '.' 제거
     * 7) 길이 < 3 → 마지막 문자를 반복하여 길이 3으로 패딩
     *
     * ✅ 현재 구현 요약(너의 코드 기준)
     * - 1~2단계: 한 번 순회하며 대문자 소문자화 및 허용 문자만 StringBuilder(result)에 축적
     * - 3단계: replaceAll("[.]+", ".")로 '.' 연속 축약 (정규식)
     * - 4~7단계: 앞/뒤 '.' 제거, 빈 문자열 보정, 패딩(<3), 자르기(>15) 순서 처리
     * - 정확성 100% (제출 로그 통과)
     *
     * 🚀 성능·메모리 분석
     * - 시간 복잡도: 대체로 O(n)
     * - 메모리: replaceAll 및 String ↔ StringBuilder 전환으로 중간 객체가 추가 생성됨
     *   (result.toString() → new StringBuilder(removeComma))
     *
     * 🛠 보완 포인트(실무 관점까지 반영)
     * 1) 정규식 제거 + 단일 패스 스트리밍
     *    - '.' 축약은 빌드 중 직전 문자가 '.'인지 boolean으로 추적하면 즉시 처리 가능
     *      prevDot 플래그를 사용해 '.'가 연속되면 append를 건너뜀
     *    - 이 방식은 replaceAll 호출과 중간 문자열 생성이 없어지고, 전체가 한 번의 StringBuilder로 끝남
     *
     * 2) 매직 넘버 상수화
     *    - MIN_LEN = 3, MAX_LEN = 15 상수 선언
     *    - 의도 명확화와 실수 방지, 스펙 변경에 대한 내구성 확보
     *
     * 3) 스펙 순서 명확화(가독성)
     *    - 문제 명세 순서: 자르기(>15) → 끝 '.' 재제거 → 패딩(<3)
     *    - 실제 분기 순서를 명세와 동일하게 배치하면 유지보수 시 혼란이 줄어듦
     *
     * 4) 허용 문자 판정 유틸리티화
     *    - isAllowed(char c)와 toLowerAscii(char c) 같은 private 메서드로 분리
     *    - 테스트 용이성↑, 중복 조건문↓, 실수 방지
     *
     * 5) 불필요한 중간 객체 제거
     *    - result → String → new StringBuilder → 다시 조작 구조를 단일 StringBuilder로 일원화
     *    - 메모리 사용량과 GC 부담 감소
     *
     * 6) 문자인코딩/로케일 유의
     *    - 현재 스펙은 ASCII 알파벳 대상이므로 'A'~'Z' 범위 체크로 충분
     *    - 범위 외 확장 가능성을 고려하면 Character.toLowerCase(c) 사용이 안전
     *
     * 🔍 단일 패스 구현 아이디어(의사 코드, 주석용)
     * - StringBuilder sb; boolean prevDot = false;
     * - for each char c in new_id:
     *     c = toLowerAscii(c) 혹은 Character.toLowerCase(c)
     *     if (!isAllowed(c)) continue;
     *     if (c == '.'):
     *         if (prevDot) continue;
     *         prevDot = true;
     *     else:
     *         prevDot = false;
     *     sb.append(c);
     * - 앞/뒤 '.' 제거
     * - if (sb.length()==0) sb.append("a");
     * - if (sb.length() > MAX_LEN) sb.setLength(MAX_LEN), 끝 '.' 재제거
     * - while (sb.length() < MIN_LEN) sb.append(sb.charAt(sb.length()-1));
     *
     * 🧪 엣지 케이스 점검 리스트
     * - 모두 불허 문자: "..." , "@@@" → "a" → "aaa"
     * - 앞뒤 점: ".a.", "..a..", "..." → 점 축약·가장자리 제거 확인
     * - 연속 점 내포: "a...b..c" → "a.b.c"
     * - 길이 상한: 16자 이상에서 15로 자르기 후 끝 '.' 재검사
     * - 길이 하한: "a", "ab" → 패딩으로 "aaa", "abb"
     * - 대문자 혼재: "ABC-._" → "abc-._"
     *
     * 📈 복잡도/자원(개선안 적용 시)
     * - 시간: O(n) 단일 순회
     * - 공간: O(n) 한 개의 StringBuilder만 사용
     *
     * 🔒 품질 체크(사후 불변식)
     * - 반환 문자열은 길이 3~15를 만족
     * - 문자 집합은 [a-z0-9-_.]만 존재
     * - 연속 '.' 없음, 선행/후행 '.' 없음
     */
    public int solution(int n, int k) {
        String[] transform = Integer.toString(n, k).replaceAll("[0]+", "0").split("0");
        int answer = 0;
        for (int i = 0; i < transform.length; i++) {
            long num = Long.parseLong(transform[i]);
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    public boolean isPrime (long n) {
        if (n <= 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}

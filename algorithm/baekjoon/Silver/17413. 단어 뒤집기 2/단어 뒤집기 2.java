import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🔁 단어 뒤집기 2 – 태그 보호 + 태그 밖 단어만 뒤집기
         *
         * ✅ 문제 규칙 요약
         * - 입력은 소문자/숫자/공백과 특수문자 '<', '>'로만 구성
         * - 태그는 '<'로 시작해 '>'로 끝남(내부는 소문자/공백), 단어는 태그 밖의 [소문자+숫자]
         * - 목표: 태그(<...>)는 원문 그대로, 태그 밖의 "단어"만 역순으로 출력
         *
         * ⚙️ 알고리즘 개요(상태/버퍼)
         * - boolean inTag: 태그 내부 여부 플래그
         * - StringBuilder temp: 태그 밖 단어 누적 버퍼
         * - StringBuilder answer: 최종 출력 버퍼
         *
         * 🔍 처리 흐름(문자 단위 스캔)
         * - '<'  : 단어 flush(temp.reverse()를 answer에 append) → temp 비우기 → inTag=true → '<' 출력
         * - '>'  : inTag=false → '>' 출력 → 아래 일반 로직으로 내려가지 않도록 분기 우선 처리
         * - inTag==true : 태그 내부 문자는 가공 없이 answer에 그대로 추가
         * - inTag==false:
         *   * ' ' : 단어 종료 → temp.reverse() flush → 공백 출력 → temp 비우기
         *   * 그외 : 단어 구성 문자 → temp에 누적
         * - 종료 : temp에 남은 문자가 있으면 reverse 후 마지막 flush
         *
         * ⏱️ 복잡도
         * - 시간: O(n) (각 문자를 1회 처리, reverse는 단어 길이만큼)
         * - 공간: O(n) (출력 버퍼 크기)
         *
         * 🧪 구현 팁
         * - StringBuilder 재사용: temp.setLength(0)으로 초기화하면 불필요한 객체 생성/GC 감소
         * - answer 초기 용량을 s.length()로 잡으면 내부 배열 확장 비용 감소
         * - 분기 우선순위 명확화: '<'와 '>' 처리(상태 전이)를 최우선으로 하고 일반 로직은 그 다음
         *
         * 🔧 보완 포인트(이 코드 기준)
         * 1) 메모리/성능 미세 최적화: temp = new StringBuilder() 대신 temp.setLength(0)로 재사용
         * 2) 네이밍 가독성: temp→word, answer→out 등 의미 중심 이름으로 의도 명확화
         * 3) 분기 안정성: '>' 처리 직후는 반드시 다음 문자로 넘어가도록 처리하여(continue 등) 태그 종료 후 일반 로직 진입 방지
         * 4) 스트리밍 일반화(확장 과제): 여러 보호 구간(예: 따옴표, 코드블록) 동시 지원하도록 상태를 enum으로 확장
         *
         * 🧭 현재 실력 레벨 점검(의선, 문자열/파싱 관점)
         * - 강점: 상태 플래그(inTag)와 버퍼 분리(temp/answer)로 스트리밍 파싱의 핵심 패턴을 스스로 구현함
         * - 보완: 경계 문자 처리 우선순위('<','>')와 flush 타이밍을 규칙으로 체화 필요
         * - 상대 위치: 실무형 구조 설계 Level 3.5
         * - 레벨업 로드맵:
         *   1) 보호 구간 다중화(예: 따옴표, 백틱 코드블록)와 상태 전이 표 주석화
         *   2) 입력 다중 라인 처리로 일반화(줄 경계 보존 + 상태 carry-over)
         *   3) 동일 패턴을 로그/마크업 전처리, 템플릿 엔진 미니 파서 등에 적용하여 전이 학습
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean inTag = false;
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                answer.append(temp.reverse());
                temp = new StringBuilder();
                inTag = true;
            } else if (c == '>') {
                inTag = false;
                answer.append(c);
                continue;
            }

            if (inTag) {
                answer.append(c);
            } else {
                if (c == ' ') {
                    answer.append(temp.reverse());
                    temp = new StringBuilder();
                    answer.append(c);
                } else {
                    temp.append(c);
                }
            }
        }
        answer.append(temp.reverse());
        System.out.println(answer.toString());
    }

}

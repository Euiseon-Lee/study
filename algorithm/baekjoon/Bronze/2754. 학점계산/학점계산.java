import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 🎓 BOJ 2754 학점계산 – 문자 코드 연산 기반 등급 → 점수 매핑
		 *
		 * 💡 로직 구조
		 * - 입력: A+, B0, C-, F 중 하나
		 * - 'A'~'D'인 경우: ('F' - alphabet - 1) → 4.0, 3.0, 2.0, 1.0
		 *   → 문자 코드 차이를 이용해 기본 점수를 수식으로 계산
		 * - 'F'일 경우: 0.0F
		 * - 보조기호('+', '-', '0')에 따라 0.3F 가감
		 *
		 * ⏱️ 복잡도
		 * - 시간 복잡도: O(1) (단일 문자 연산)
		 * - 공간 복잡도: O(1)
		 *
		 * ⚙️ 성능 분석
		 * - 분기 최소화 및 산술 기반 점수 계산으로 실행 비용이 거의 없음
		 * - StringTokenizer, Map, switch 등을 사용하지 않아 불필요한 오브젝트 생성 제거
		 *
		 * ✅ 구현 포인트
		 * - ('F' - alphabet - 1) 수식은 ASCII 코드 차를 이용해 A~D를 4~1로 변환
		 * - '+' → +0.3F, '-' → -0.3F, '0' → ±0.0F
		 * - 문자 비교만으로 모든 학점 케이스 처리 가능
		 *
		 * 🛠️ 보완 포인트
		 * 1) 가독성 향상: ('F' - alphabet - 1)의 의미를 주석으로 명시해 협업 시 혼동 방지
		 * 2) 입력 방어: 문제 외 입력이 들어올 경우 예외처리 필요 (실무 코드 기준)
		 * 3) 출력 형식 통일: 실무에선 String.format("%.1f", score) 사용 권장
		 *
		 * 🧩 실무 응용
		 * - 등급, 코드, 점수 등 규칙적인 문자형 데이터를 수치로 변환할 때 유용
		 * - 규칙성이 없는 경우엔 Map<Character, Float> 또는 enum 구조가 더 명시적
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();
        float score = 0.0F;
        char alphabet = grade.charAt(0);
        if (alphabet != 'F') {
            char extra = grade.charAt(1);
            score = ('F' - alphabet - 1) + (extra == '+' ? 0.3F : extra == '-' ? -0.3F : 0.0F);
        }
        System.out.println(score);
    }

}

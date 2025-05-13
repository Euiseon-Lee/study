import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        /*
         * ==========================================
         *  Scanner 입력 메서드 비교 (next vs nextLine)
         * ------------------------------------------
         *  | 메서드      | 설명                       |
         *  |------------|---------------------------|
         *  | next()     | 공백 전까지 한 단어 입력     |
         *  | nextLine() | 한 줄 전체 입력 (공백 포함)  |
         *
         *  주의:
         *   - next()는 '\n'을 버퍼에 남기므로,
         *     nextLine()과 함께 사용할 때는 주의 필요
         *   - 해결 방법: sc.nextLine(); // 버퍼 비우기
         * ==========================================
         */
        
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(a + b);
    }
}

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
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
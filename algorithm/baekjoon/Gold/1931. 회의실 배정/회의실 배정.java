import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] schedule = new int[n][2];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(schedule, new Comparator<int[]>() {
			@Override
			public int compare (int[] t1, int[] t2) {
				if (t1[1] == t2[1]) return t1[0] - t2[0];
				return t1[1] - t2[1];
			}

		});

		int count = 0;
		int prev_end_schedule = 0;
		for (int i = 0; i < n; i++) {
			if (prev_end_schedule <= schedule[i][0]) {
				prev_end_schedule = schedule[i][1];
				count++;
			}
		}
		System.out.print(count);
	}

}
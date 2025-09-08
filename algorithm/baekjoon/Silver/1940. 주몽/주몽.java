import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int materialCount = Integer.parseInt(br.readLine());
        int shieldMaterial =  Integer.parseInt(br.readLine());
        int[] materialList = new int[materialCount];
        Map<Integer, Integer> materials = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < materialCount; i++) {
            int target = Integer.parseInt(st.nextToken());
            materialList[i] = target;
            materials.put(target, materials.getOrDefault(target, 0) + 1);
        }
        int answer = 0;
        for (int i = 0; i < materialCount; i++) {
            int standard = materialList[i];
            if (materials.getOrDefault(standard, 0) == 0) continue;
            materials.put(standard, materials.get(standard) - 1);
            int needed = shieldMaterial - standard;
            if (materials.getOrDefault(needed, 0) > 0) {
                answer++;
                materials.put(needed, materials.get(needed) - 1);
            }
        }
        System.out.println(answer);
    }
}

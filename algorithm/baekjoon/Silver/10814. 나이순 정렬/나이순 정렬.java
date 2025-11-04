import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final Person[] persons = new Person[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            persons[i] = new Person(age, name, i);
        }

        Arrays.sort(persons, (p1, p2) -> {
            if (p1.age != p2.age) {
                return Integer.compare(p1.age, p2.age);
            }
            return Integer.compare(p1.order, p2.order);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(persons[i].age)
              .append(' ')
              .append(persons[i].name)
              .append('\n');
        }
        System.out.print(sb);
    }

    public static class Person {
        int age;
        String name;
        int order;

        public Person(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
}
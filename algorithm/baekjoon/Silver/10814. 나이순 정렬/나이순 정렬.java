import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 🧑‍🤝‍🧑 BOJ 10814 나이순 정렬 – 나이 기준 + 입력 순서 유지(Stable Sort)
         *
         * 🧩 문제 개요
         * - 각 회원의 (나이, 이름)가 주어지고,
         *   나이 오름차순으로 정렬하되, 나이가 같으면 입력된 순서를 유지해야 하는 문제.
         *
         * 💡 핵심 아이디어
         * - 같은 나이일 때 "먼저 가입한 사람"이 먼저 나와야 하므로,
         *   → 정렬이 안정적(stable)이어야 한다.
         * - 구현 방법 2가지:
         *   1) Arrays.sort(Object[])의 안정 정렬 성질을 이용하고, Comparator에서 나이만 비교
         *   2) Person에 입력 순서(order)를 저장하고, (age → order) 순으로 명시적으로 비교
         *
         * ⚙️ 알고리즘 구조
         * 1️⃣ 입력을 Person[ ] 배열에 저장 (age, name, order=입력 인덱스)
         * 2️⃣ Arrays.sort로 나이 기준(필요 시 order까지 포함) 정렬
         * 3️⃣ 정렬된 배열을 (age, name) 형식으로 순서대로 출력
         *
         * ⏱️ 복잡도
         * - 정렬: O(N log N)
         * - 출력: O(N)
         * - 메모리: O(N) (Person 배열)
         *
         * 🛠️ 구현 포인트
         * - 입력 인덱스를 order로 함께 저장해 두면, Comparator에서 tie-breaker로 사용 가능
         * - StringBuilder로 출력 버퍼링
         * - Arrays.sort(Object[])는 Java에서 안정 정렬이므로, age만 기준으로 두어도 입력 순서 유지됨
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];

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

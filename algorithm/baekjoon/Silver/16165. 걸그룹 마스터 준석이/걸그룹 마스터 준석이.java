/**
 * 🧩 BOJ 16165 – 걸그룹 마스터 준석이 (리팩터링 버전)
 *
 * 🎯 목적
 * - type=1(멤버→그룹) 질의의 선형 탐색 제거 → O(1) 응답
 * - type=0(그룹→멤버) 질의에서 매번 정렬 제거 → 입력 후 1회 정렬만
 *
 * 🧠 핵심 구조
 * - groupToMembers : Map<String, List<String>>  // 그룹 → 멤버 목록
 * - memberToGroup  : Map<String, String>        // 멤버 → 그룹 (역인덱스)
 *
 * 🔁 처리 흐름
 * 1) 입력 로딩
 *    - 각 그룹의 멤버 목록을 ArrayList에 담고,
 *    - 동시에 멤버마다 memberToGroup.put(member, group) 해서 역인덱스 구축
 * 2) 로딩 완료 후, 모든 그룹의 멤버 목록을 1회만 정렬(Collections.sort)
 * 3) 질의 처리
 *    - type==1: memberToGroup.get(멤버명) → O(1)로 그룹명 출력
 *    - type==0: groupToMembers.get(그룹명)를 그대로 순회 출력(이미 정렬됨)
 *
 * 🚀 성능
 * - 로딩: Σ(k_g log k_g) (그룹별 멤버 k_g 정렬 1회)
 * - 질의: type=1 → O(1), type=0 → O(k_g) (출력만)
 *
 * 🔒 주의
 * - 문제 스펙상 존재하는 키만 들어오지만, 실무라면 null 가드 권장
 * - 동일 멤버의 중복 소속 없음(스펙); 실무라면 중복 방지 Set 고려
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int groupCount = Integer.parseInt(st.nextToken());
        int quizzes    = Integer.parseInt(st.nextToken());

        Map<String, List<String>> groupToMembers = new HashMap<>(groupCount * 2);
        Map<String, String>       memberToGroup  = new HashMap<>(groupCount * 3);

        // 1) 입력 로딩 + 역인덱스 구축
        for (int i = 0; i < groupCount; i++) {
            String group = br.readLine();                 // 그룹명
            int num      = Integer.parseInt(br.readLine());// 멤버 수

            List<String> list = new ArrayList<>(num);
            for (int j = 0; j < num; j++) {
                String member = br.readLine();
                list.add(member);
                memberToGroup.put(member, group);         // 멤버 → 그룹 역인덱스
            }
            groupToMembers.put(group, list);
        }

        // 2) 로딩 완료 후, 모든 그룹의 멤버를 1회만 정렬
        for (List<String> list : groupToMembers.values()) {
            Collections.sort(list);
        }

        // 3) 질의 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quizzes; i++) {
            String q = br.readLine();              // 문제의 대상(멤버명 또는 그룹명)
            boolean isMemberQuiz = "1".equals(br.readLine()); // 1이면 멤버→그룹, 0이면 그룹→멤버

            if (isMemberQuiz) {
                // 멤버 → 그룹 : 역인덱스로 O(1) 조회
                sb.append(memberToGroup.get(q)).append('\n');
            } else {
                // 그룹 → 멤버 : 이미 정렬된 리스트를 그대로 출력
                List<String> list = groupToMembers.get(q);
                for (String name : list) {
                    sb.append(name).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
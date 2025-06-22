/*
 📌 게임 아이템 트리에서 ROOT 아이템 조회

 ✅ 핵심 로직
 - ROOT 아이템은 업그레이드 체계에서 부모 아이템(PARENT_ITEM_ID)이 NULL인 경우
 - ITEM_TREE 테이블의 PARENT_ITEM_ID가 NULL인 레코드를 기준으로 ITEM_INFO를 JOIN하여 이름 등 상세 정보 조회

 ✅ JOIN 방식
 - ITEM_INFO(T1) ⨝ ITEM_TREE(T2): ITEM_ID 기준 내부 조인
 - 조건: T2.PARENT_ITEM_ID IS NULL → ROOT 아이템만 필터링

 ✅ 정렬
 - 결과를 ITEM_ID 기준 오름차순 정렬

 ✅ 실무 활용도
 - 조직도, 메뉴 계층, 상품 카테고리 등 트리 구조 데이터에서 루트 노드(최상위 요소) 추출에 매우 유용
 - 계층적 구조 데이터 분석 및 UI 렌더링의 시작점 구성 시 활용 가능

 ✅ 보완 포인트
 - 실무에서는 트리의 깊이가 있는 경우 재귀 CTE를 활용하여 전체 계층 구조 탐색 필요
 - PARENT_ITEM_ID가 NULL이 아닌 경우에 대한 분기 처리 및 오류 데이터 검증 로직 추가 필요
*/
SELECT T1.ITEM_ID
     , T1.ITEM_NAME
  FROM ITEM_INFO AS T1
  JOIN ITEM_TREE AS T2
    ON T1.ITEM_ID = T2.ITEM_ID
 WHERE T2.PARENT_ITEM_ID IS NULL
 ORDER BY T1.ITEM_ID;

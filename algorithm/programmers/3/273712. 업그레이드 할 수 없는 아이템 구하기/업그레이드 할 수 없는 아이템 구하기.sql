/*
 ✅ 더 이상 업그레이드할 수 없는 아이템 조회 쿼리

 📌 문제 조건
 - ITEM_TREE 테이블에서 PARENT_ITEM_ID로 등장한 적이 없는 ITEM_ID → 자식이 없는 아이템
 - 해당 아이템의 ITEM_ID, ITEM_NAME, RARITY를 출력하고 ID 기준 내림차순 정렬

 🔎 쿼리 구조
 - ITEM_INFO 테이블에서 ITEM_ID가 ITEM_TREE의 PARENT_ITEM_ID 목록에 없는 경우를 조회
 - 단, PARENT_ITEM_ID에는 NULL이 존재 → COALESCE를 사용해 9999로 치환하여 비교

 ⚠️ NOT IN 사용 시 주의사항
 - 서브쿼리 결과에 NULL이 존재하면, NOT IN 전체 비교가 NULL 처리되어 **빈 결과**가 나옴
 - COALESCE를 사용하면 이 문제를 회피할 수 있음 (예: COALESCE(PARENT_ITEM_ID, 9999))

 ✨ 정리
 - 이 쿼리는 NULL-safe한 방식으로 NOT IN을 사용한 예시
 - 실무에서는 NULL 값 여부가 명확하지 않을 경우, NOT EXISTS 또는 LEFT JOIN 방식 권장
*/
SELECT ITEM_ID
     , ITEM_NAME
     , RARITY
  FROM ITEM_INFO
 WHERE ITEM_ID NOT IN (SELECT DISTINCT PARENT_ITEM_ID FROM ITEM_TREE WHERE PARENT_ITEM_ID IS NOT NULL)
 ORDER BY ITEM_ID DESC;

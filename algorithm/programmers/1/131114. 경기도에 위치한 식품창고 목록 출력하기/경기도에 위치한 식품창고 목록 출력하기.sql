/** 📌 경기도 소재 창고 조회 SQL (NULL 처리 포함)

  ✅ 핵심 로직
  - `WHERE ADDRESS LIKE '경기도%'`: 주소가 '경기도'로 시작하는 창고만 필터링
  - `COALESCE(FREEZER_YN, 'N')`: 냉동시설 여부가 NULL이면 'N'으로 치환
  - `ORDER BY WAREHOUSE_ID`: 창고 ID 기준 오름차순 정렬

  ✅ 성능 분석
  - LIKE 연산은 와일드카드가 접두에 없으므로 인덱스 활용 가능 (효율적)
  - COALESCE는 NULL 처리에 적합하며, NVL과 달리 표준 SQL로 호환성 높음

  ✅ 실무 활용도
  - 주소 기반 지역 필터링 시 자주 사용되는 패턴 (LIKE '지역%')
  - COALESCE는 NULL-safe 출력에 필수적이며, UI 데이터 노출 시 안정성 확보에 기여
  - SELECT 컬럼에 COALESCE 적용 시 조회 결과와 NULL 변동성 제어가 용이

  ✅ 보완 포인트
  - 주소 컬럼에 인덱스가 없다면 성능 저하 우려 (→ 인덱스 고려 필요)
  - 냉동시설 여부가 'Y', 'N', NULL 외 다른 값이 존재하는지 데이터 정합성 점검 필요
  - COALESCE는 단순 치환이므로 의미적 구분이 필요한 경우 CASE WHEN도 고려할 것

*/
SELECT WAREHOUSE_ID
     , WAREHOUSE_NAME
     , ADDRESS
     , COALESCE(FREEZER_YN, 'N') AS FREEZER_YN
  FROM FOOD_WAREHOUSE
 WHERE ADDRESS LIKE '경기도%'
 ORDER BY WAREHOUSE_ID;

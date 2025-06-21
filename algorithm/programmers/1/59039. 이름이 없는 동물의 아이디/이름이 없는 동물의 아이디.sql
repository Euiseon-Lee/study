/** 📌 이름이 없는 동물의 ID 조회

  ✅ 핵심 로직
  - `WHERE NAME IS NULL`: 이름이 없는 동물만 필터링
  - `ORDER BY ANIMAL_ID`: ID 기준 오름차순 정렬

  ✅ 성능 및 구조
  - 조건절에 `IS NULL` 사용: NULL 여부 필터링 시 필수 문법
  - 정렬은 인덱스가 잡혀 있으면 매우 효율적으로 수행됨 (ANIMAL_ID가 PK일 가능성 높음)

  ✅ 실무 활용도
  - 사용자 정보, 상품명 등에서 '값이 비어 있는 데이터' 추적 시 자주 사용
  - 입력 데이터 누락 검사, 비정상 입력 데이터 로그 추출 등에 적합
  - 단순하지만 데이터 정합성 점검을 자동화할 때 자주 쓰이는 패턴

  ✅ 보완 포인트
  - NAME 컬럼이 공백(빈 문자열)으로 들어간 경우는 제외되므로, `TRIM(NAME) = ''` 처리를 추가 고려할 수도 있음
  - `IS NULL`은 null만 감지하므로 실무에선 NULL과 EMPTY 구분 전략 필요
*/
SELECT ANIMAL_ID
  FROM ANIMAL_INS
 WHERE NAME IS NULL
 ORDER BY ANIMAL_ID;

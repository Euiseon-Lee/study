/** 📌 이름이 있는 동물의 ID 조회

  ✅ 핵심 로직
  - `WHERE NAME IS NOT NULL`: 이름이 존재하는 동물만 필터링
  - `ORDER BY ANIMAL_ID`: ID 기준으로 오름차순 정렬

  ✅ 성능 분석
  - 필터 조건이 단순하고, 정렬 기준도 PK 또는 인덱스 컬럼일 가능성이 높아 성능 부담이 적음
  - 데이터양이 많더라도 효율적인 인덱스 스캔이 가능함

  ✅ 실무 활용도
  - 사용자 정보, 고객 데이터, 제품 등에서 이름이 명확히 입력된 데이터만 추출할 때 유용
  - 전처리 단계에서 null 필터링을 통해 통계나 사용자 인터페이스에서 사용할 수 있는 신뢰 가능한 데이터 집합 확보 가능

  ✅ 보완 포인트
  - 공백 문자열("")은 NOT NULL 조건을 통과하므로, 이름이 의미 없는 값인지 추가 필터링 필요
    예: `WHERE NAME IS NOT NULL AND TRIM(NAME) <> ''`
  - 데이터 품질 향상을 위해 NULL 이외의 예외값(예: '-', 'unknown')에 대한 정책적 처리도 병행하는 것이 좋음
*/
SELECT ANIMAL_ID
  FROM ANIMAL_INS
 WHERE NAME IS NOT NULL
 ORDER BY ANIMAL_ID;

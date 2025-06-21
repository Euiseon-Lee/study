/*
 📌 ANIMAL_INS 테이블 조회 - 이름 누락 시 'No name' 대체 출력

 ✅ 핵심 로직
 - 동물 보호소 입소 동물 중, 생물 종(ANIMAL_TYPE), 이름(NAME), 성별/중성화 정보(SEX_UPON_INTAKE)를 조회
 - 이름이 NULL인 경우 'No name'으로 치환하여 사용자에게 전달
 - 최종 결과는 ANIMAL_ID 기준으로 오름차순 정렬

 ✅ 사용 함수
 - COALESCE(NAME, 'No name') → NAME이 NULL이면 'No name' 반환

 ✅ 성능 및 안정성
 - WHERE 조건 없이 전체 조회이므로, 인덱스가 없다면 대량 데이터 시 느릴 수 있음
 - COALESCE는 NULL 안전성이 높아 예외 없이 처리 가능

 ✅ 실무 활용도
 - 사용자 인터페이스(UI)에 표시될 데이터를 가공할 때 자주 사용되는 패턴
 - 특히 비기술 사용자나 외부 노출 화면에서는 NULL 그대로 출력하지 않도록 조치 필요
 - ‘빈 값’을 직관적인 메시지로 대체함으로써 사용자 경험(UX) 향상에 기여

 ✅ i18n (Internationalization) 개념 정의
 - 국제화를 의미하는 'internationalization'을 앞 글자 i와 끝 글자 n만 남기고 사이 18자를 생략한 축약어
 - 예: 'No name' → 다국어 사용자에 따라 '이름 없음', '名前なし', 'Без имени' 등으로 변환될 수 있음
 - 실무에선 하드코딩 대신 다국어 리소스 파일(.properties, JSON 등)을 통해 처리하는 것이 표준

 ✅ 예시 개선 방향
 - 다국어 지원이 필요한 시스템에서는 'No name' 문자열도 별도 리소스 처리 필요
 - ex) COALESCE(NAME, :no_name_label) 형태로 동적 바인딩 처리
*/
SELECT ANIMAL_TYPE
     , COALESCE(NAME, 'No name') AS NAME
     , SEX_UPON_INTAKE
  FROM ANIMAL_INS
 ORDER BY ANIMAL_ID;

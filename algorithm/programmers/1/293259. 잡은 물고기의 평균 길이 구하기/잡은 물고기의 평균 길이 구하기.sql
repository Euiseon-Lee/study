/*
 📌 평균 물고기 길이 계산 - NULL은 10cm로 간주

 ✅ 핵심 로직
 - FISH_INFO 테이블에서 LENGTH 값의 평균을 구하되,
   NULL인 경우에는 길이를 10cm로 처리하여 평균을 구함
 - 소수점 둘째 자리까지 반올림하여 결과 출력

 ✅ 사용 함수 및 처리 방식
 - COALESCE(LENGTH, 10): NULL이면 10로 대체
 - ROUND(AVG(...), 2): 평균을 소수점 둘째 자리까지 반올림
 - AS AVERAGE_LENGTH: 결과 컬럼명을 명시적으로 지정

 ✅ 실무 활용도
 - 실측 데이터에 NULL이 포함될 수 있는 상황에서 기본값으로 대체하여 통계 산출 시 유용
 - COALESCE는 데이터 분석, 리포트, 대시보드 등에서 누락값 보완 시 자주 사용됨
 - ROUND는 사용자에게 친숙한 숫자 표현을 제공하는 데 필수

 ✅ 주의사항
 - LENGTH 컬럼이 모두 NULL일 가능성은 없다고 문제에 명시되었지만,
   실무에서는 AVG()와 같은 집계 함수의 NULL 처리 유무를 항상 검토해야 함
*/
SELECT ROUND(AVG(COALESCE(LENGTH, 10)), 2) AS AVERAGE_LENGTH FROM FISH_INFO;

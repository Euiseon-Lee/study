/** 🍨 SQL 코드 리뷰 – 성분 타입별 총주문량 집계 쿼리
 *
 * 🚀 성능 및 안정성
 * - 두 테이블 모두 FLAVOR가 기본 키이므로 조인에서 중복 없음
 * - GROUP BY 대상 컬럼이 SELECT와 일치하고, SUM 대상이 명확함
 * - 인덱스가 FLAVOR 기준으로 존재하면 성능도 매우 우수
 *
 * 📌 실무 적용 팁
 * 1. AS 키워드는 생략 가능하지만, 가독성을 위해 명시하는 것이 좋음 (T1, T2)
 * 2. GROUP BY 이후 사용하는 컬럼은 반드시 SELECT 또는 ORDER BY에 함께 명시
 * 3. ORDER BY 컬럼은 별칭(TOTAL_ORDER) 또는 위치(2)로도 정렬 가능하나, 가독성 위해 별칭 추천
 * 4. COUNT 또는 SUM의 대상이 NULL일 수 있는 경우 COALESCE로 안전하게 감싸는 습관도 고려
 *
 * 🎯 학습 포인트
 * - 다대일 조인 + GROUP BY + 집계 함수(SUM)는 SQL에서 가장 자주 쓰이는 패턴 중 하나
 * - 구조는 단순하지만 실무에서는 JOIN 조건, NULL 처리, 컬럼 명확성 등이 오류 포인트가 되므로 항상 검토
 * - 문제 조건을 잘 읽고 컬럼명까지 정확히 맞추는 습관을 들일 것
 */
SELECT T2.INGREDIENT_TYPE
     , SUM(T1.TOTAL_ORDER) AS TOTAL_ORDER
  FROM FIRST_HALF AS T1
  JOIN ICECREAM_INFO AS T2
    ON T1.FLAVOR = T2.FLAVOR
 GROUP BY T2.INGREDIENT_TYPE
 ORDER BY TOTAL_ORDER;

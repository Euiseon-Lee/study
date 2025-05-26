-- 🔍 상품별 총 매출액 계산 후 정렬

-- ✅ 문제 요구사항
-- - 각 상품의 총 매출액(SALES = PRICE * 총 판매 수량)을 계산
-- - 매출액 내림차순, 상품코드 오름차순으로 정렬
-- - 필요한 테이블: PRODUCT, OFFLINE_SALE

-- ✅ 쿼리 구성 평가
-- 1. 서브쿼리로 OFFLINE_SALE에서 PRODUCT_ID별 판매 수량 합계를 미리 계산
-- 2. 이를 PRODUCT 테이블과 JOIN하여 가격과 곱해 총 매출액 계산
-- 3. SALES DESC, PRODUCT_CODE ASC 조건에 따라 정확히 정렬 처리함

-- ✅ 코드 구조 장점
-- - 가독성을 위해 서브쿼리에 별칭(T2)을 부여하고, 중간 집계(SUM_AMOUNT)를 분리함
-- - 연산 순서가 명확하여 JOIN 이후의 계산이 혼동 없이 진행됨
-- - GROUP BY → JOIN → 계산 → 정렬 흐름이 문제 해결 방식과 일치함

-- ✅ 성능 참고
-- - OFFLINE_SALE 테이블에 인덱스가 없다면 GROUP BY 성능에 영향 줄 수 있음
-- - 필요시 PRODUCT_ID에 인덱스 설정 고려 가능

-- 🧠 정리
-- - 총 매출액 산정 + 정렬 문제를 명확하고 효율적으로 해결한 쿼리
-- - 실무에서도 집계 후 연산 → JOIN → 정렬 패턴은 자주 사용되는 안정된 방식
-- - 별칭 및 연산 위치 처리도 모두 명확하여 매우 적절한 구현임

-- 코드를 입력하세요
SELECT T1.PRODUCT_CODE
     , T1.PRICE * T2.SUM_AMOUNT AS SALES
  FROM PRODUCT AS T1
  JOIN (
        SELECT SUM(SALES_AMOUNT) AS SUM_AMOUNT
             , PRODUCT_ID
          FROM OFFLINE_SALE
         GROUP BY PRODUCT_ID
        ) AS T2
    ON T1.PRODUCT_ID = T2.PRODUCT_ID
 ORDER BY SALES DESC, PRODUCT_CODE ASC;

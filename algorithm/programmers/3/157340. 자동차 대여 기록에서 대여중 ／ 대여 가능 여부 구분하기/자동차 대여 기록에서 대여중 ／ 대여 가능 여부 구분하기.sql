/** 🚗 특정 날짜 기준 자동차 대여 상태 조회 – MySQL vs PostgreSQL GROUP BY 처리 비교
 *
 * ✅ 문제 요약
 * - 2022-10-16에 대여중인 자동차는 '대여중', 그 외는 '대여 가능'으로 표기
 * - 각 자동차 ID(CAR_ID)에 대해 하나의 상태(AVAILABILITY)만 출력
 *
 * ⚠️ [너의 원래 코드] – MySQL에서만 허용되는 구조
 * - GROUP BY CAR_ID만 하고, SELECT 절의 CASE에는 집계 함수 없음
 * - MySQL에서는 ONLY_FULL_GROUP_BY 모드가 꺼져 있으면 SELECT에서 그룹 외 컬럼도 허용함
 *   → 이때 GROUP 내에서 어떤 행의 값을 선택할지는 **비결정적이며 불안정**
 *   → 실질적으로 “임의의 행”을 대표로 반환함 → CASE 평가 결과가 실제 상태와 다를 수 있음
 *
 * 💣 예시 위험
 * - CAR_ID 2번이 대여중인데, 조건을 만족하지 않는 다른 행이 대표가 되면 '대여 가능'으로 표기됨
 * - 데이터가 누락되거나 오판단되는 실무 리스크 발생
 *
 * ❗ PostgreSQL의 GROUP BY 철학
 * - ANSI SQL 표준을 엄격히 지키므로,
 *   SELECT에 나오는 컬럼은 반드시:
 *     1) GROUP BY에 포함되거나
 *     2) 집계 함수로 감싸야 함
 * - 그렇지 않으면 실행 시도 시 명확한 오류 발생
 *   → ERROR: column "X" must appear in the GROUP BY clause or be used in an aggregate function
 * - 철학: “모호한 대표값 선택은 명백한 버그로 간주 → 방지”
 *
 * ✅ [개선된 정답 코드]
 * - 조건을 CASE로 표현하고, MAX로 그룹 전체 기준 참 여부를 판정
 * - 조건부 집계(CASE WHEN + MAX)를 통해 PostgreSQL에서도 정확히 작동
 *
 * 🎯 학습 포인트
 * - 집계 없이 GROUP BY를 사용하면 DB에 따라 결과가 다를 수 있음 → 항상 의도 명확화 필요
 * - 조건 기반 분기를 그룹 단위로 평가하려면 집계 함수와 함께 사용
 * - 실무에서는 항상 사용하는 DB의 SQL 모드(예: MySQL의 ONLY_FULL_GROUP_BY)를 고려해야 함
 */

-- ✅ 개선된 표준 호환 정답 (PostgreSQL 포함)
SELECT CAR_ID,
       CASE WHEN MAX(CASE WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE THEN 1 ELSE 0 END) = 1
            THEN '대여중'
            ELSE '대여 가능'
       END AS AVAILABILITY
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

-- ⚠️ 원래 작성한 코드 (MySQL에서는 동작하지만 표준 위반 가능)
SELECT CAR_ID,
       CASE WHEN CAR_ID IN (
                  SELECT CAR_ID
                  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                  WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
             )
            THEN '대여중'
            ELSE '대여 가능'
       END AS AVAILABLITY
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

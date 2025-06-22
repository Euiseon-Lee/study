/**
 * 🧪 연도별 최대 대장균 크기 편차 조회 쿼리
 *
 * 🗂️ WITH 절 사용 - 연도별 최대 SIZE 계산 (YEARLY_MAX)
 *    - YEAR(DIFFERENTIATION_DATE) 기준 그룹핑
 *    - MAX(SIZE_OF_COLONY)로 최대 크기 추출
 *
 * 🔗 본문에서 ECOLI_DATA와 YEARLY_MAX 연도 기준 조인
 *    - YEAR_DEV = 최대 크기 - 개체 크기
 *    - SELECT 항목: 연도, 편차, 개체 ID
 *
 * 📊 정렬 기준
 *    - 연도(YEAR) 오름차순
 *    - 연도 내 편차(YEAR_DEV) 오름차순
 *
 * ✅ 실무 적용성
 *    - 집계 → 조인 → 비교 패턴 구조 이해도 탁월
 *    - CTE 구조 분리로 가독성과 재사용성 향상
 */
WITH YEARLY_MAX AS (
    SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR
         , MAX(SIZE_OF_COLONY) AS YEARLY_MAX
      FROM ECOLI_DATA
      GROUP BY YEAR(DIFFERENTIATION_DATE)
)
SELECT YEAR(T1.DIFFERENTIATION_DATE) AS YEAR
     ,  (T2.YEARLY_MAX - T1.SIZE_OF_COLONY) AS YEAR_DEV
     , T1.ID
  FROM ECOLI_DATA AS T1
  JOIN YEARLY_MAX AS T2
    ON YEAR(T1.DIFFERENTIATION_DATE) = T2.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC;

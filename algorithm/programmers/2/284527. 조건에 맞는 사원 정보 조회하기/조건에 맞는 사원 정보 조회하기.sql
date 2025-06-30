/**
 * 📌 2022년도 평가 최고 점수 사원 조회 쿼리 - 실무적 확장과 개선 팁 포함
 *
 * ✅ 기본 로직
 * - HR_GRADE 테이블에서 2022년도 점수만 SUM하여 사번(EMP_NO) 기준 집계
 * - HR_EMPLOYEES와 EMP_NO로 JOIN하여 사원 정보 병합
 * - SCORE 내림차순 정렬 후 LIMIT 1 → 가장 높은 점수의 사원 1명 조회
 *
 * ✅ 개선된 실무 팁
 * 1. 🎯 ORDER BY는 숫자 인덱스보다 명시적 컬럼 사용 권장
 *    → ORDER BY T1.SCORE DESC (O), ORDER BY 1 DESC (X)
 *    → 쿼리 구조가 바뀔 때 순번 기준 정렬은 위험
 *
 * 2. 👥 공동 1등 처리 필요 시 RANK() 또는 DENSE_RANK() 사용
 *    → LIMIT 1은 동점자 배제하므로 성과 평가 시 오류 발생 가능
 *
 * 3. 🚀 JOIN 대상 범위를 줄이면 성능 향상
 *    → 먼저 2022년도 최고 점수자만 필터링 후 소수 대상만 JOIN
 *    → JOIN 대상 테이블이 클수록 중요
 *
 * 4. 🧠 인덱스 고려
 *    → HR_GRADE.YEAR, EMP_NO 복합 인덱스 생성 시 WHERE + GROUP BY 성능 향상
 *
 * 5. 📊 컬럼명에 의미 부여
 *    → SCORE 대신 2022_SCORE, ANNUAL_SCORE 등 사용 시 다년간 리포트 작성에 유리
 *
 * ✅ 공동 1등 포함 개선 쿼리 예시
 * WITH GRADED AS (
 *   SELECT EMP_NO, SUM(SCORE) AS SCORE
 *     FROM HR_GRADE
 *    WHERE YEAR = 2022
 *    GROUP BY EMP_NO
 * )
 * , RANKED AS (
 *   SELECT G.EMP_NO, G.SCORE, E.EMP_NAME, E.POSITION, E.EMAIL,
 *          RANK() OVER (ORDER BY G.SCORE DESC) AS RNK
 *     FROM GRADED G
 *     JOIN HR_EMPLOYEES E USING (EMP_NO)
 * )
 * SELECT EMP_NO, SCORE, EMP_NAME, POSITION, EMAIL
 *   FROM RANKED
 *  WHERE RNK = 1;
 *
 * ▶ 이 쿼리는 공동 1위 사원 모두를 정확히 반환하며, 실무에서 신뢰성 있는 분석 결과를 보장함
 */
SELECT T1.SCORE, T1.EMP_NO, T2.EMP_NAME, T2.POSITION, T2.EMAIL
  FROM (
        SELECT EMP_NO
             , SUM(SCORE) AS SCORE
          FROM HR_GRADE
         WHERE YEAR = 2022 
         GROUP BY EMP_NO
       ) AS T1
  JOIN HR_EMPLOYEES AS T2
 USING (EMP_NO)
 ORDER BY T1.SCORE DESC
 LIMIT 1;

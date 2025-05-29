-- 날짜 함수의 성능 이슈
-- YEAR()와 MONTH()를 사용하면 인덱스를 무시하게 되어 성능에 영향을 줄 수 있어.
-- BETWEEN을 쓰는 방식으로 리라이팅하면 성능에 더 유리함.
SELECT MCDP_CD AS 진료과코드
     , COUNT(MCDP_CD) AS 5월예약건수
  FROM APPOINTMENT
 --WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
 WHERE DATE(APNT_YMD) BETWEEN '2022-05-01' AND '2022-05-31'
 GROUP BY MCDP_CD
 ORDER BY 5월예약건수, 진료과코드
;

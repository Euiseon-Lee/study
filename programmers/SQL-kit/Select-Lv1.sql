/* 평균 일일 대여 요금 구하기
문제 설명
다음은 어느 자동차 대여 회사에서 대여중인 자동차들의 정보를 담은 CAR_RENTAL_COMPANY_CAR 테이블입니다. CAR_RENTAL_COMPANY_CAR 테이블은 아래와 같은 구조로 되어있으며, CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS 는 각각 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트를 나타냅니다.

Column name	Type	Nullable
CAR_ID	INTEGER	FALSE
CAR_TYPE	VARCHAR(255)	FALSE
DAILY_FEE	INTEGER	FALSE
OPTIONS	VARCHAR(255)	FALSE
자동차 종류는 '세단', 'SUV', '승합차', '트럭', '리무진' 이 있습니다. 자동차 옵션 리스트는 콤마(',')로 구분된 키워드 리스트(예: '열선시트', '스마트키', '주차감지센서')로 되어있으며, 키워드 종류는 '주차감지센서', '스마트키', '네비게이션', '통풍시트', '열선시트', '후방카메라', '가죽시트' 가 있습니다.

문제
CAR_RENTAL_COMPANY_CAR 테이블에서 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금을 출력하는 SQL문을 작성해주세요. 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림하고, 컬럼명은 AVERAGE_FEE 로 지정해주세요.
*/

-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE), 0) AS average_fee
  FROM CAR_RENTAL_COMPANY_CAR
 WHERE car_type = 'SUV';


/* 흉부외과 또는 일반외과 의사 목록 출력하기
문제 설명
다음은 종합병원에 속한 의사 정보를 담은DOCTOR 테이블입니다. DOCTOR 테이블은 다음과 같으며 DR_NAME, DR_ID, LCNS_NO, HIRE_YMD, MCDP_CD, TLNO는 각각 의사이름, 의사ID, 면허번호, 고용일자, 진료과코드, 전화번호를 나타냅니다.

Column name	Type	Nullable
DR_NAME	VARCHAR(20)	FALSE
DR_ID	VARCHAR(10)	FALSE
LCNS_NO	VARCHAR(30)	FALSE
HIRE_YMD	DATE	FALSE
MCDP_CD	VARCHAR(6)	TRUE
TLNO	VARCHAR(50)	TRUE

문제
DOCTOR 테이블에서 진료과가 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용일자를 조회하는 SQL문을 작성해주세요. 이때 결과는 고용일자를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬해주세요.
*/

-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, TO_CHAR(HIRE_YMD, 'YYYY-MM-DD') AS HIRE_YMD
  FROM DOCTOR
 WHERE MCDP_CD IN ('CS', 'GS')
 ORDER BY HIRE_YMD DESC, DR_NAME ASC;


/* 과일로 만든 아이스크림 고르기
문제 설명
다음은 아이스크림 가게의 상반기 주문 정보를 담은 FIRST_HALF 테이블과 아이스크림 성분에 대한 정보를 담은 ICECREAM_INFO 테이블입니다. FIRST_HALF 테이블 구조는 다음과 같으며, SHIPMENT_ID, FLAVOR, TOTAL_ORDER 는 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다. FIRST_HALF 테이블의 기본 키는 FLAVOR입니다.

NAME	TYPE	NULLABLE
SHIPMENT_ID	INT(N)	FALSE
FLAVOR	VARCHAR(N)	FALSE
TOTAL_ORDER	INT(N)	FALSE
ICECREAM_INFO 테이블 구조는 다음과 같으며, FLAVOR, INGREDITENT_TYPE 은 각각 아이스크림 맛, 아이스크림의 성분 타입을 나타냅니다. INGREDIENT_TYPE에는 아이스크림의 주 성분이 설탕이면 sugar_based라고 입력되고, 아이스크림의 주 성분이 과일이면 fruit_based라고 입력됩니다. ICECREAM_INFO의 기본 키는 FLAVOR입니다. ICECREAM_INFO테이블의 FLAVOR는 FIRST_HALF 테이블의 FLAVOR의 외래 키입니다.

NAME	TYPE	NULLABLE
FLAVOR	VARCHAR(N)	FALSE
INGREDIENT_TYPE	VARCHAR(N)	FALSE

문제
상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.
*/

-- 문제를 푸는 데까지 시간이 걸렸는데, 그 이유는 PGSQL과 ORACLE의 차이 때문이다.
-- !!!! Oracle SQL에서는 테이블 별칭(alias)을 지정할 때 AS 키워드를 사용할 수 없습니다.
-- !!!! AS는 컬럼 별칭에만 사용할 수 있으며, 테이블 별칭을 지정할 때는 AS를 생략해야 합니다.

-- 코드를 입력하세요
SELECT A.FLAVOR
  FROM FIRST_HALF A
  INNER JOIN ICECREAM_INFO B
    ON A.FLAVOR = B.FLAVOR
 WHERE A.TOTAL_ORDER > 3000
   AND B.INGREDIENT_TYPE = 'fruit_based'
 ORDER BY A.TOTAL_ORDER DESC;

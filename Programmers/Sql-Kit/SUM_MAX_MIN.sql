/* LEVEL 1 - 가장 비싼 상품 구하기
문제 설명
다음은 어느 의류 쇼핑몰에서 판매 중인 상품들의 정보를 담은 PRODUCT 테이블입니다. PRODUCT 테이블은 아래와 같은 구조로 되어있으며, PRODUCT_ID, PRODUCT_CODE, PRICE는 각각 상품 ID, 상품코드, 판매가를 나타냅니다.

Column name	Type	Nullable
PRODUCT_ID	INTEGER	FALSE
PRODUCT_CODE	VARCHAR(8)	FALSE
PRICE	INTEGER	FALSE
상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.

문제
PRODUCT 테이블에서 판매 중인 상품 중 가장 높은 판매가를 출력하는 SQL문을 작성해주세요. 이때 컬럼명은 MAX_PRICE로 지정해주세요.
*/
SELECT MAX(PRICE) FROM PRODUCT;


/* LEVEL 1 - 최댓값 구하기
문제 설명
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

NAME	TYPE	NULLABLE
ANIMAL_ID	VARCHAR(N)	FALSE
ANIMAL_TYPE	VARCHAR(N)	FALSE
DATETIME	DATETIME	FALSE
INTAKE_CONDITION	VARCHAR(N)	FALSE
NAME	VARCHAR(N)	TRUE
SEX_UPON_INTAKE	VARCHAR(N)	FALSE
가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
*/
-- 코드를 입력하세요
SELECT MAX(DATETIME) FROM ANIMAL_INS;


/*  LEVEL 1 - 잡은 물고기 중 가장 큰 물고기의 길이 구하기
문제 설명
낚시앱에서 사용하는 FISH_INFO 테이블은 잡은 물고기들의 정보를 담고 있습니다. FISH_INFO 테이블의 구조는 다음과 같으며 ID, FISH_TYPE, LENGTH, TIME은 각각 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜를 나타냅니다.

Column name	Type	Nullable
ID	INTEGER	FALSE
FISH_TYPE	INTEGER	FALSE
LENGTH	FLOAT	TRUE
TIME	DATE	FALSE
단, 잡은 물고기의 길이가 10cm 이하일 경우에는 LENGTH 가 NULL 이며, LENGTH 에 NULL 만 있는 경우는 없습니다.

문제
FISH_INFO 테이블에서 잡은 물고기 중 가장 큰 물고기의 길이를 'cm' 를 붙여 출력하는 SQL 문을 작성해주세요.

이 때 컬럼명은 'MAX_LENGTH' 로 지정해주세요.
*/
-- 코드를 작성해주세요
SELECT CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH FROM FISH_INFO;


/* LEVEL 2 - 가격이 제일 비싼 식품의 정보 출력하기
제출 내역
문제 설명
다음은 식품의 정보를 담은 FOOD_PRODUCT 테이블입니다. FOOD_PRODUCT 테이블은 다음과 같으며 PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE는 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 의미합니다.

Column name	Type	Nullable
PRODUCT_ID	VARCHAR(10)	FALSE
PRODUCT_NAME	VARCHAR(50)	FALSE
PRODUCT_CD	VARCHAR(10)	TRUE
CATEGORY	VARCHAR(10)	TRUE
PRICE	NUMBER	TRUE
문제
FOOD_PRODUCT 테이블에서 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회하는 SQL문을 작성해주세요.
*/



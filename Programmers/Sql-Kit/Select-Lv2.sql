/* 업그레이드 된 아이템 구하기
문제 설명
어느 한 게임에서 사용되는 아이템들은 업그레이드가 가능합니다.
'ITEM_A'->'ITEM_B'와 같이 업그레이드가 가능할 때
'ITEM_A'를 'ITEM_B' 의 PARENT 아이템,
PARENT 아이템이 없는 아이템을 ROOT 아이템이라고 합니다.

예를 들어 'ITEM_A'->'ITEM_B'->'ITEM_C'와 같이 업그레이드가 가능한 아이템이 있다면
'ITEM_C'의 PARENT 아이템은 'ITEM_B'
'ITEM_B'의 PARENT 아이템은 'ITEM_A'
ROOT 아이템은 'ITEM_A'가 됩니다.

다음은 해당 게임에서 사용되는 아이템 정보를 담은 ITEM_INFO 테이블과 아이템 관계를 나타낸 ITEM_TREE 테이블입니다. ITEM_INFO 테이블은 다음과 같으며, ITEM_ID, ITEM_NAME, RARITY, PRICE는 각각 아이템 ID, 아이템 명, 아이템의 희귀도, 아이템의 가격을 나타냅니다.

Column name	Type	Nullable
ITEM_ID	INTEGER	FALSE
ITEM_NAME	VARCHAR(N)	FALSE
RARITY	INTEGER	FALSE
PRICE	INTEGER	FALSE
ITEM_TREE 테이블은 다음과 같으며, ITEM_ID, PARENT_ITEM_ID는 각각 아이템 ID, PARENT 아이템의 ID를 나타냅니다.

Column name	Type	Nullable
ITEM_ID	INTEGER	FALSE
PARENT_ITEM_ID	INTEGER	TRUE
단, 각 아이템들은 오직 하나의 PARENT 아이템 ID를 가지며, ROOT 아이템의 PARENT 아이템 ID는 NULL 입니다.

ROOT 아이템이 없는 경우는 존재하지 않습니다.

문제
아이템의 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 이때 결과는 아이템 ID를 기준으로 내림차순 정렬주세요.
*/
-- SUBQUERY 사용하여 처리
SELECT t1.ITEM_ID, t1.ITEM_NAME, t1.RARITY
  FROM ITEM_INFO t1
 INNER JOIN ITEM_TREE t2
    ON t1.ITEM_ID = t2.ITEM_ID
 WHERE t2.PARENT_ITEM_ID IN (SELECT ITEM_ID FROM ITEM_INFO WHERE RARITY = 'RARE')
 ORDER BY t1.ITEM_ID DESC
;

-- JOIN 중첩 사용하여 처리
SELECT t3.ITEM_ID, t3.ITEM_NAME, t3.RARITY
  FROM ITEM_INFO t1
 INNER JOIN ITEM_TREE t2 
    ON t1.ITEM_ID = t2.PARENT_ITEM_ID
 INNER JOIN ITEM_INFO t3 
    ON t2.ITEM_ID = t3.ITEM_ID
 WHERE t1.RARITY = 'RARE'
 ORDER BY t3.ITEM_ID DESC
;


/* 조건에 맞는 개발자 찾기
문제 설명
SKILLCODES 테이블은 개발자들이 사용하는 프로그래밍 언어에 대한 정보를 담은 테이블입니다. SKILLCODES 테이블의 구조는 다음과 같으며, NAME, CATEGORY, CODE는 각각 스킬의 이름, 스킬의 범주, 스킬의 코드를 의미합니다. 스킬의 코드는 2진수로 표현했을 때 각 bit로 구분될 수 있도록 2의 제곱수로 구성되어 있습니다.

NAME	TYPE	UNIQUE	NULLABLE
NAME	VARCHAR(N)	Y	N
CATEGORY	VARCHAR(N)	N	N
CODE	INTEGER	Y	N
DEVELOPERS 테이블은 개발자들의 프로그래밍 스킬 정보를 담은 테이블입니다. DEVELOPERS 테이블의 구조는 다음과 같으며, ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_CODE는 각각 개발자의 ID, 이름, 성, 이메일, 스킬 코드를 의미합니다. SKILL_CODE 컬럼은 INTEGER 타입이고, 2진수로 표현했을 때 각 bit는 SKILLCODES 테이블의 코드를 의미합니다.

NAME	TYPE	UNIQUE	NULLABLE
ID	VARCHAR(N)	Y	N
FIRST_NAME	VARCHAR(N)	N	Y
LAST_NAME	VARCHAR(N)	N	Y
EMAIL	VARCHAR(N)	Y	N
SKILL_CODE	INTEGER	N	N
예를 들어 어떤 개발자의 SKILL_CODE가 400 (=b'110010000')이라면, 이는 SKILLCODES 테이블에서 CODE가 256 (=b'100000000'), 128 (=b'10000000'), 16 (=b'10000') 에 해당하는 스킬을 가졌다는 것을 의미합니다.

문제
DEVELOPERS 테이블에서 Python이나 C# 스킬을 가진 개발자의 정보를 조회하려 합니다. 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요.
결과는 ID를 기준으로 오름차순 정렬해 주세요.
*/
-- 비트 연산자 사용
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
  FROM DEVELOPERS
 WHERE SKILL_CODE &(SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')
    OR SKILL_CODE &(SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')
 ORDER BY ID ASC;

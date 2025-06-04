/** 🚘 특정 옵션 포함 차량의 차종별 대수 집계 – REGEXP 활용 필터링 + GROUP BY
 *
 * ✅ 문제 요약
 * - 자동차 옵션 중 '통풍시트', '열선시트', '가죽시트' 중 하나 이상이 포함된 차량만 필터링
 * - 해당 차량들을 자동차 종류(CAR_TYPE)별로 묶어서 총 몇 대인지(CARS) 계산
 * - 결과는 CAR_TYPE 오름차순 정렬
 *
 * 🧠 핵심 로직 해설
 * - WHERE 절의 REGEXP는 OPTIONS 필드(문자열)에 정규표현식 적용
 *   → '통풍시트', '열선시트', '가죽시트' 중 하나라도 포함되면 참
 * - COUNT는 CAR_TYPE별로 차량 개수를 집계
 * - GROUP BY와 ORDER BY 모두 CAR_TYPE 기준으로 정렬 및 출력
 *
 * 🚀 성능 및 주의사항
 * - REGEXP는 문자열 패턴 검색이므로 성능 비용이 있음 (인덱스 미적용)
 *   → 차량 수가 많은 경우 성능 저하 가능
 * - 실무에서는 옵션을 콤마로 저장하지 않고 별도 테이블로 정규화하는 것이 일반적
 *
 * 📌 실무 설계 팁
 * 1. 정규표현식은 간결하지만 비용이 큼 → LIKE OR 방식도 대안
 *    예: OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%열선시트%' ...
 * 2. 옵션 정보는 CSV보다 JSON 배열 또는 별도 옵션 테이블로 분리하면 추후 확장성과 성능이 우수함
 * 3. COUNT(*)와 COUNT(CAR_TYPE)의 결과는 동일하지만, 명시적 컬럼 사용은 가독성에 유리
 *
 * 🎯 학습 포인트
 * - 텍스트 필드에서 다중 키워드 필터링이 필요한 경우 REGEXP는 강력한 도구
 * - GROUP BY + COUNT 패턴은 데이터 분류 집계에서 가장 많이 사용되는 기본 구조
 * - 문자열 컬럼 조건 필터링 방식(REGEXP vs LIKE vs JSON_CONTAINS vs FIND_IN_SET 등)의 장단점 비교도 익혀두면 좋음
 */
SELECT CAR_TYPE
     , COUNT(CAR_TYPE) AS CARS
  FROM CAR_RENTAL_COMPANY_CAR
 WHERE OPTIONS REGEXP ('통풍시트|열선시트|가죽시트')
 GROUP BY CAR_TYPE
 ORDER BY CAR_TYPE;

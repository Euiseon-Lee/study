/**
 * 🐾 보호소에 가장 먼저 들어온 동물의 이름 조회
 *
 * 🧭 정렬 기준: 보호 시작일시(DATETIME) 오름차순
 * 🐢 LIMIT 1: 가장 먼저 들어온 1마리만 선택
 *
 * 📌 성능 이점
 * - DATETIME 인덱스 활용 시 빠르게 탐색 가능
 * - LIMIT 1로 불필요한 정렬 결과를 줄여 리소스 절약
 *
 * 💡 실무 사용 예
 * - 첫 등록된 사용자, 최초 주문 내역 등 조회 시 동일 패턴 사용
 */
SELECT NAME
  FROM ANIMAL_INS
 ORDER BY DATETIME
 LIMIT 1;

class Solution {
    public int[] solution(int[] num_list, int n) {
        /** 📌 n칸 간격으로 배열 원소 추출
        
          ✅ 핵심 로직
          - 배열 `num_list`에서 n칸 간격으로 원소를 추출하여 새 배열에 저장
          - 결과 배열의 크기는 (길이 / n) + (길이 % n != 0 ? 1 : 0)로 미리 계산
          - `i`는 결과 배열의 인덱스, `idx`는 원본 배열의 위치를 n씩 증가하며 순회
        
          ✅ 성능 분석
          - 시간복잡도: O(num_list.length / n)
            → 입력 배열을 n개 단위로 건너뛰며 순회하므로 매우 효율적
          - 공간복잡도: O(num_list.length / n)
            → 필요한 만큼만 정해진 크기로 결과 배열을 할당
        
          ✅ 실무 활용도
          - 로그, 시계열, 센서 데이터 등에서 주기적인 간격으로 데이터 추출 시 유용
          - 예: 5분 간격 데이터 추출, n개씩 샘플링, 차트 축소 등
        
          ✅ 보완 포인트
          - 이 문제는 명시적으로 1 ≤ n ≤ 4 범위를 보장하므로
            → 유효성 검증 생략 가능
          - 단, 실무에서는 n 값이 외부 입력일 경우 `n <= 0` 또는 `n > num_list.length` 여부를 반드시 확인해야 함
        */
        int length = (num_list.length / n) + (num_list.length % n == 0 ? 0 : 1);
        int[] answer = new int[length];
        for (int i = 0, idx = 0; i < length; i++) {
            answer[i] = num_list[idx];
            idx += n;
        }
        return answer;
    }
}

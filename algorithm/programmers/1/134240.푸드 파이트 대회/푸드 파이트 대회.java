class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int countPerPerson = food[i] / 2;
            for (int count = 0; count < countPerPerson; count++) {
                left.append(i);
            }
        }
        return left.toString() + '0' + left.reverse();
    }
}
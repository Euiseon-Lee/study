class Solution {
    private static final int BREAD = 1;
    private static final int VEGETABLE = 2;
    private static final int MEAT = 3;
    private static final int BURGER_SIZE = 4;

    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int size = 0;
        int answer = 0;

        for (int item : ingredient) {
            stack[size++] = item;
            if (size >= BURGER_SIZE
                    && stack[size - BURGER_SIZE] == BREAD
                    && stack[size - 3] == VEGETABLE
                    && stack[size - 2] == MEAT
                    && stack[size - 1] == BREAD) {
                size -= BURGER_SIZE;
                answer++;
            }
        }
        return answer;
    }
}
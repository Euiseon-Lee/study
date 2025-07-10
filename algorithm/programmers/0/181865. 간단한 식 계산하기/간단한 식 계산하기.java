class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        int answer = 0;
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String op = arr[1];
        switch (op) {
            case "+": answer = a + b;
                break;
            case "-": answer = a - b;
                break;
            case "*": answer = a * b;
                break;
            default:
                break;
        }
        return answer;
    }
}
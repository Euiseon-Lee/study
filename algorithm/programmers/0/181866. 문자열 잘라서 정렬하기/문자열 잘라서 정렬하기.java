import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.replaceAll("^[x]|[x]$", "").replaceAll("x+", "x").trim().split("x");
        Arrays.sort(answer);
        return answer;
    }
}
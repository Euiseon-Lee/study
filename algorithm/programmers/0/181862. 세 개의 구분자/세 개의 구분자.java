class Solution {
    public String[] solution(String myStr) {
        String refinedStr = myStr.replace("a", "c").replace("b", "c").replaceAll("c+", " ").trim();
        return refinedStr.length() == 0 ? new String[]{"EMPTY"} : refinedStr.split(" ");
    }
}
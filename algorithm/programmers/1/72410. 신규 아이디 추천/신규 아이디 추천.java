class Solution {
    public String solution(String new_id) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) (ch + 32));
            } else if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                result.append(ch);
            } else if (ch == '-' || ch == '_' || ch == '.') {
                result.append(ch);
            }
        }
        String removeComma = result.toString().replaceAll("[.]+", ".");
        result = new StringBuilder(removeComma);
        if (result.length() > 0 && result.charAt(0) == '.') result.deleteCharAt(0);
        if (result.length() > 0 && result.charAt(result.length() - 1) == '.') result.deleteCharAt(result.length() - 1);

        if (result.length() == 0) {
            result.append("a");
        }
        if (result.length() < 3) {
            char ch = result.charAt(result.length() - 1);
            for (int i = result.length(); i < 3; i++) {
                result.append(ch);
            }
        } else if (result.length() > 15) {
            result.replace(15, result.length(), "");
            if (result.charAt(result.length() - 1) == '.') result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}
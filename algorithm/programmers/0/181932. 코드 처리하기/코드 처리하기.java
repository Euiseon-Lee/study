class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            String s = Character.toString(code.charAt(i));
            if (s.equals("1")) {
                mode = mode == 0 ? 1 : 0;
            } else {
                if (mode == 0) {
                    ret.append(i % 2 == 0 ? s : "");
                } else {
                    ret.append(i % 2 == 1 ? s : "");
                }
            }
        }
        return ret.length() > 0 ? ret.toString() : "EMPTY";
    }
}
class Solution {
    public String solution(String s, String skip, int index) {
        final int ALPHABET_SIZE = 'z' - 'a' + 1;
        StringBuilder sb = new StringBuilder(s.length());
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int moved = 0;
            
            while (moved < index) {
                currentChar = (char) (
                    'a' + (currentChar - 'a' + 1) % ALPHABET_SIZE
                );

                if (skip.indexOf(currentChar) == -1) {
                    moved++;
                }
            }
            sb.append(currentChar);
        }
        return sb.toString();
    }
}
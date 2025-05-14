class Solution {
    public String solution(String my_string, String overwrite_string, int s) { 
        int endpoint = s+overwrite_string.length();
        String prefix = my_string.substring(0, s);
        String suffix = my_string.substring(endpoint);
        return prefix + overwrite_string + suffix;
    }
}
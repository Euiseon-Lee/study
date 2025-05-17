class Solution {
    public int[] solution(String[] wallpaper) {
        int startRow = Integer.MAX_VALUE, startCol = Integer.MAX_VALUE
          , endRow = Integer.MIN_VALUE, endCol = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            String rowInfo = wallpaper[i];
            for (int j = 0; j < rowInfo.length(); j++) {
                char tmp = rowInfo.charAt(j);
                if (tmp == '#') {
                    startRow = Math.min(startRow, i);
                    startCol = Math.min(startCol, j);
                    endRow = Math.max(endRow, i);
                    endCol = Math.max(endCol, j);
                } else {
                    continue;
                }
            }
        }
        return new int[] {startRow, startCol, endRow + 1, endCol + 1};
    }
}
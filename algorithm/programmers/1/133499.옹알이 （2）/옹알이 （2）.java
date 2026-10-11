class Solution {
    private static final String[] SOUNDS = {
        "aya", "ye", "woo", "ma"
    };

    public int solution(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
            if (canPronounce(word)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean canPronounce(String word) {
        int position = 0;
        String previous = "";

        while (position < word.length()) {
            boolean matched = false;
            for (String sound : SOUNDS) {
                if (!word.startsWith(sound, position)) {
                    continue;
                }

                if (sound.equals(previous)) {
                    return false;
                }
                position += sound.length();
                previous = sound;
                matched = true;
                break;
            }
            if (!matched) {
                return false;
            }
        }
        return true;
    }
}
package medium;

public class _245_ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return same(words, word1);
        } else {
            return notsame(words, word1, word2);
        }
    }

    private int same(String[] words, String word1) {
        int res = Integer.MAX_VALUE;
        int index = -1;
        int temp = 0;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                if (index != -1) {
                    temp = Math.abs(i - index);
                    if (temp < res) {
                        res = temp;
                    }
                }
                index = i;
            }
        }
        return res;
    }

    private int notsame(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        int temp = 0;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
                if (index2 != -1) {
                    temp = Math.abs(index1 - index2);
                    if (temp < res) {
                        res = temp;
                    }
                }
            }
            if (word2.equals(words[i])) {
                index2 = i;
                if (index1 != -1) {
                    temp = Math.abs(index1 - index2);
                    if (temp < res) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }
}

package easy;

public class _243_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        int temp = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
                if (index2 != -1) {
                    temp = Math.abs(index1 -index2);
                    if (temp < res) {
                        res = temp;
                    }
                }
            }
            if (word2.equals(words[i])) {
                index2 = i;
                if (index1 != -1) {
                    temp = Math.abs(index1 -index2);
                    if (temp < res) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }
}

package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _127_WordLadder {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int[] steps = new int[wordList.size()];
//        for (int i = 0; i < steps.length; i++) {
//            steps[i] = Integer.MAX_VALUE;
//        }
//        String[] words = wordList.toArray(new String[0]);
//        int index = 0;
//        int step = 1;
//        boolean done = false;
//        while (true) {
//            if (index == words.length) {
//                index = 0;
//                if (done) {
//                    break;
//                }
//                done = true;
//            }
//            if (steps[index] == Integer.MAX_VALUE) {
//                String temp = words[index];
//                int j = 0;
//                if (computerDistance(beginWord, temp) == 1) {
//                    steps[index] = 1;
//                    done = false;
//                } else {
//                    while (j < words.length) {
//                        if (steps[j] != Integer.MAX_VALUE && computerDistance(temp, words[j]) == 1) {
//                            steps[index] = steps[index] < steps[j] + 1? steps[index]:steps[j] + 1;
//                            done = false;
//                        }
//                        j++;
//                    }
//                }
//            }
//            index++;
//        }
//        for (int i = 0; i < words.length; i++) {
//            if (words[i].equals(endWord) && steps[i] != Integer.MAX_VALUE) {
//                return steps[i]+1;
//            }
//        }
//        return 0;
//
//    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] steps = new int[wordList.size()];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        String[] words = wordList.toArray(new String[0]);
        int index = 0;
        int step = 1;
        boolean done = false;
        while (true) {
            if (done) {
                break;
            }
            done = true;
            index = 0;
            while (index < words.length) {

                if (steps[index] == Integer.MAX_VALUE) {
                    String temp = words[index];
                    int j = 0;
                    if (step == 1) {
                        if (computerDistance(beginWord, temp) == 1) {
                            steps[index] = 1;
                            done = false;
                        }
                    } else {
                        while (j < words.length) {
                            if (steps[j] == step - 1 && computerDistance(temp, words[j]) == 1) {
                                steps[index] = step;
                                done = false;
                            }
                            j++;
                        }
                    }
                }
                index++;
            }
            step++;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(endWord) && steps[i] != Integer.MAX_VALUE) {
                return steps[i] + 1;
            }
        }
        return 0;

    }

    public int computerDistance(String word1, String word2) {
        int distance = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        _127_WordLadder s = new _127_WordLadder();
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        s.ladderLength("hit", "cog", wordList);
    }
}

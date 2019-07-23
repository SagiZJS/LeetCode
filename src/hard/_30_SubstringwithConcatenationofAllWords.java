package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30_SubstringwithConcatenationofAllWords {

//    private static class LinkedString {
//        String val;
//        LinkedString next;
//
//        private LinkedString(String val) {
//            this.val = val;
//        }
//    }
//    
//    int[] countsProto = null;
//    int[] counts = null;
//    Map<String, Integer> map = null;
//    LinkedString[] mark = null;
//    int totalWords = 0;
//    int len = 0;
//    public List<Integer> findSubstring(String s, String[] words) {
//        len = s.length();
//        List<Integer> res = new ArrayList<>();
//        mark = new LinkedString[s.length()];
//        map = new HashMap<>();
//        totalWords = words.length;
//        countsProto = new int[words.length];
//        for (int i = 0; i< words.length; i++) {
//            String string = words[i];
//            map.put(string, map.get(string) == null ? i : map.get(string));
//            countsProto[map.get(string)]++;
//            int start = -1;
//            while ((start = s.indexOf(string, start + 1)) != -1) {
////                System.out.println(string+start);
//                if (mark[start] == null) {
//                    mark[start] = new LinkedString(string);
//                } else {
//                    mark[start].next = new LinkedString(string);
//                }
//            }
//        }
//        LinkedString thisString = null;
//        for (int i = 0; i < mark.length; i++) {
//            thisString = mark[i];
//            while (thisString != null) {
//                counts = Arrays.copyOf(countsProto, words.length);
//                if (process(thisString, i) == 0) {
//                    // process result
//                    res.add(i);
//                    break;
//                } 
//                thisString = thisString.next;
//            }
//        }
//        return res;
//    }
//    
//    private int process(LinkedString linkedString, int wordIndex) {
//        int ret = -1;
//        String word = linkedString.val;
//        // index is for retrieve from counts
//        int index = map.get(word);
//        if (counts[index] == 0) {
//            return -1;
//        } else {
//            counts[index]--;
//            totalWords--;
//            if (totalWords==0) {
//                totalWords++;
//                counts[index]++;
//                return 0;
//            }
//            if (wordIndex+word.length() >= len) {
//                totalWords++;
//                counts[index]++;
//                return -1;
//            }
//            LinkedString next = mark[wordIndex+word.length()];
//            while (next != null) {
//                if(process(next, wordIndex + word.length())==0) {
//                    totalWords++;
//                    counts[index]++;
//                    return 0;
//                } else {
//                    next = next.next;
//                }
//            }
//            totalWords++;
//            counts[index]++;
//        }
//        return ret;
//    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        int wordLength = words[0].length();
        if (wordLength > s.length()) {
            return new ArrayList<>();
        }
        // store each word's counts
        Map<String, Integer> indexMap = new HashMap<>();
        int[] expectedCounts = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int gotten = indexMap.getOrDefault(words[i], -1);
            if (gotten == -1) {
                expectedCounts[i] = 1;
                indexMap.put(words[i], i);
            } else {
                expectedCounts[gotten] = expectedCounts[gotten] + 1;
            }
        }

        char[] chars = s.toCharArray();

        int[] matches = new int[chars.length];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (i >= wordLength) {
                builder.deleteCharAt(0);
            }
            builder.append(chars[i]);
            if (i >= wordLength - 1) {
                int match = indexMap.getOrDefault(builder.toString(), -1);
                matches[i - wordLength + 1] = match;
            }
        }

        List<Integer> indexMatches = new ArrayList<>();

        int[] counts = null;
        int total = -1;
        int index = -1;
        int countsindex = -1;
        for (int i = 0; i < s.length() - wordLength * words.length + 1; i++) {
            counts = Arrays.copyOf(expectedCounts, expectedCounts.length);
            index = i;
            countsindex = matches[index];
            total = words.length;
            while (countsindex != -1) {
                if (counts[countsindex] == 0) {
                    break;
                } else {
                    counts[countsindex]--;
                    total--;
                    if (total == 0) {
                        indexMatches.add(i);
                        break;
                    }
                    index += wordLength;
                    if (index >= s.length()) {
                        break;
                    }
                    countsindex = matches[index];
                }
            }
        }
        return indexMatches;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[] { "word", "good", "best", "good" };
        _30_SubstringwithConcatenationofAllWords solution = new _30_SubstringwithConcatenationofAllWords();
        System.out.println(solution.findSubstring(s, words));
    }
}

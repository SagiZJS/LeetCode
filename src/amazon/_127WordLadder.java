package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }
        int distance = 0;
        Set<String> currentSet = new HashSet<>();
        currentSet.add(beginWord);
        while (currentSet.size() != 0) {
            Set<String> nextSet = new HashSet<>();
            set.removeAll(currentSet);
            for (String current : currentSet) {
                nextSet.addAll(computeNext(current));
            }
            if (nextSet.contains(endWord)) {
                return distance+1;
            }
            nextSet.retainAll(set);
            currentSet = nextSet;
            distance++;
        }
        return 0;
    }

    List<String> computeNext(String s) {
        int len = s.length();
        List<String> ret = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                char[] cs = s.toCharArray();
                cs[i] = c;
                if (c == s.charAt(i)) {
                    continue;
                }
                ret.add(new String(cs));
            }
        }
        return ret;
    }
}

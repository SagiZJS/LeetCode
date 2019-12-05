package amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        int maxLen = 0;
        for (String word : wordDict) {
            if (maxLen < word.length()) {
                maxLen = word.length();
            }
        }
        Boolean[] dp = new Boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = null;
        }
        return recursive(s, 0, set, maxLen, dp);
    }

    boolean recursive(String s, int start, Set<String> wordDict, int maxLen, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        if (start > s.length()) {
            return false;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int i = start + maxLen; i > start; i--) {
            if (i > s.length()) {
                continue;
            }
            String subString = s.substring(start, i);
            if (wordDict.contains(subString)) {
                if (recursive(s, i, wordDict, maxLen, dp)) {
                    return true;
                }
            }
        }
        dp[start] = false;
        return false;
    }
}

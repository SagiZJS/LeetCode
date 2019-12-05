package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _140_WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<>();
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
        recursive(s, 0, set, maxLen, dp, ret, new ArrayList<>());
        return ret;

    }

    boolean recursive(String s, int start, Set<String> wordDict, int maxLen, Boolean[] dp, List<String> ret,
            List<String> current) {
        if (start == s.length()) {
            ret.add(String.join(" ", current));
            return true;
        }
        if (start > s.length()) {
            return false;
        }
        if (dp[start] != null && dp[start] == false) {
            return false;
        }
        boolean flag = false;
        for (int i = start + maxLen; i > start; i--) {
            if (i > s.length()) {
                continue;
            }
            String subString = s.substring(start, i);
            if (wordDict.contains(subString)) {
                current.add(subString);
                flag = recursive(s, i, wordDict, maxLen, dp, ret, current) || flag;
                current.remove(current.size() - 1);
            }
        }
        dp[start] = flag;
        return dp[start];
    }

    public static void main(String[] args) {
        _140_WordBreakII s = new _140_WordBreakII();
        String str = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(s.wordBreak(str, wordDict));
    }
}

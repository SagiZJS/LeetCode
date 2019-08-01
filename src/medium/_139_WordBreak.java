package medium;

import java.util.ArrayList;
import java.util.List;

public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return false;
        int len = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            len = len > wordDict.get(i).length() ? len : wordDict.get(i).length();
        }
        Boolean[] matches = new Boolean[s.length()];
        for (int i = 0; i < matches.length; i++) {
            matches[i] = null;
        }
        return recursion(s, wordDict, len, matches, 0);
    }

    public boolean recursion(String s, List<String> wordDict, int len, Boolean[] matches, int index) {
        if (index >= s.length()) {
            return true;
        }
        if (matches[index] == null) {
            for (int i = index + len; i > index; i--) {
                if (i > s.length()) {
                    continue;
                }
                if (wordDict.contains(s.subSequence(index, i)) &&  recursion(s, wordDict, len, matches, i)) {
                    matches[index] =true;
                    break;
                }
            }
        }
        if (matches[index] == null) {
            matches[index] = false;
        }
        return matches[index];
    }

    public static void main(String[] args) {
        _139_WordBreak sol = new _139_WordBreak();
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<String>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(sol.wordBreak(s, wordDict));
    }
}

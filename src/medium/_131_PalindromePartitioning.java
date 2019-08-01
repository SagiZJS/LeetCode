package medium;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        char[] word = s.toCharArray();
        for (int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i][i] = true;

        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                if (word[i] == word[i + len - 1]) {
                    isPalindrome[i][i + len - 1] = (len > 2 ? isPalindrome[i + 1][i + len - 2] : true);
                }
            }
        }
        recursion(result, s, isPalindrome, new ArrayList<>(),0);
        return result;
    }
    
    public void recursion(List<List<String>> result, String s, boolean[][] isPalindrome, List<String> temp, int start) {
        if (s.length() - start == 0) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i <s.length();i++) {
            if (isPalindrome[start][i]) {
                temp.add(s.substring(start,i+1));
                recursion(result, s, isPalindrome, temp, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        _131_PalindromePartitioning s =new _131_PalindromePartitioning();
        s.partition("aab");
    }

}

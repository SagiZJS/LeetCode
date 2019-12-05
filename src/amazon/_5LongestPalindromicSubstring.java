package amazon;

public class _5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        if (s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                isPal[i][j] = true;
            }
        }
        char[] c = s.toCharArray();
        int max = 0;
        String ret = s.substring(0,1);
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len - 1;
                if (c[i] == c[j]) {
                    isPal[i][j] = isPal[i + 1][j - 1];
                    if (isPal[i][j]) {
                        if (j - i > max) {
                            max = j - i;
                            ret = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return ret;
    }
}

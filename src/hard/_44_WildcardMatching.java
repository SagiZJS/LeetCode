package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() == 0) {
            String[] temp = p.split("\\*");
            for (String string : temp) {
                if (string.length() > 0) {
                    return false;
                }
            }
            return true;
        }
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        List<String> temp = new ArrayList<>();
        String[] noWildCards = null;
        int start = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                temp.add(p.substring(start, i));
                start = i + 1;
            }
        }
        temp.add(p.substring(start, p.length()));
        noWildCards = temp.toArray(new String[0]);
        if (noWildCards.length == 0) {
            return true;
        }
        if (noWildCards.length == 1 && noWildCards[0].length() != s.length()) {
            return false;
        }
        int[][] matches = new int[noWildCards.length][];
        int[] length = new int[noWildCards.length];
        for (int i = 0; i < noWildCards.length; i++) {
            if (noWildCards[i].length() > 0) {
                length[i] = noWildCards[i].length();
                matches[i] = matchWithoutWildcards(s, noWildCards[i]);
            } else {
                matches[i] = null;
            }
        }
        int end = -1;
        if (matches[0] != null && (matches[0].length == 0 || matches[0][0] != 0)) {
            return false;
        }
        if (matches[matches.length - 1] != null && ((matches[matches.length - 1].length == 0)
                || (matches[matches.length - 1][matches[matches.length - 1].length - 1]
                        + length[length.length - 1]) != s.length())) {
            return false;
        }
        outer: for (int i = 0; i < matches.length; i++) {
            if (matches[i] == null) {
                continue;
            }
            for (int j = 0; j < matches[i].length; j++) {
                if (matches[i][j] > end) {
                    end = matches[i][j] + length[i] - 1;
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }

    public int[] matchWithoutWildcards(String s, String p) {
        int[] res = new int[s.length()];
        int count = 0;

        outer: for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (i + j >= s.length()) {
                    continue outer;
                }
                if (p.charAt(j) == '?') {
                    continue;
                }
                if (p.charAt(j) != s.charAt(i + j)) {
                    continue outer;
                }
            }
            res[count++] = i;
        }
        return Arrays.copyOf(res, count);
    }

}

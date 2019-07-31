package hard;

public class _32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        while (start < s.length()) {
            // find first (
            while (chars[start] == ')') {
                start++;
                end++;
                if (start == s.length()) {
                    return max;
                }
            }
            // find the longest valid string from the start index
            end = subValidParentheses(s, start, start);
            // update
            
            if (end != start && end - start + 1 > max) {
                max = end - start + 1;
            }
            start = end + 1;
            end = start;
        }
        return max;
    }

    public int subValidParentheses(String s, int index, int end) {
        char[] chars = s.toCharArray();
        int count = 0;
        int lastValidEnd = index;
        while (count >= 0) {
            if (end == s.length()) {
                break;
            }
            if (chars[end] == '(') {
                count++;
            }
            if (chars[end] == ')') {
                if (count > 0) {
                    count--;
                } else {
                    return lastValidEnd;
                }
            }
            if (count == 0) {
                lastValidEnd = end;
            }
            end++;
        }
        return lastValidEnd;
    }

    public static void main(String[] args) {
        _32_LongestValidParentheses s = new _32_LongestValidParentheses();
        String str = ")(())))(())())";
        System.out.println(s.longestValidParentheses(str));
    }
}

package amazon;

public class _20ValidParentheses {
    public boolean isValid(String s) {
        int[] stack = new int[s.length()];
        int p = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[p++] = 0;
            }
            if (c==')') {
                if( p==0 || stack[--p] != 0) {
                    return false;
                }
            }
            if (c == '{') {
                stack[p++] = 1;
            }
            if (c=='}') {
                if( p==0 || stack[--p] != 1) {
                    return false;
                }
            }
            if (c == '[') {
                stack[p++] = 2;
            }
            if (c==']') {
                if( p==0 || stack[--p] != 2) {
                    return false;
                }
            }
        }
        return p==0;
    }
}

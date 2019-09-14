package medium;

public class _161_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() >= t.length() + 2 || s.length() <= t.length() - 2) {
            return false;
        }
        if (s.length() == t.length()) {
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (flag) {
                        return false;
                    } else {
                        flag = true;
                    }
                }
            }
            return flag;
        } else if (s.length() == t.length() - 1) {
            return isOneAdd(s, t);
        } else {
            return isOneAdd(t, s);
        }
    }

    public boolean isOneAdd(String s, String l) {
        if (s.length() == 0) {
            return true;
        }
        int add = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != l.charAt(i + add)) {
                if (add == 1) {
                    return false;
                } else {
                    add++;
                    i--;
                }
            }
        }
        return true;
    }
}

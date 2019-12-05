package easy;

public class _246_StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        for (;i < num.length()  / 2;i++) {
            if (!test(num.charAt(i), num.charAt(num.length() - 1 - i))) {
                return false;
            }
        }
        if (num.length() %2 == 1) {
            return test(num.charAt(i));
        }
        return true;
    }
    boolean test(char c1, char c2) {
        if (c1=='6' && c2=='9') {
            return true;
        }
        if (c1=='9' && c2=='6') {
            return true;
        }
        if (c1=='8' && c2=='8') {
            return true;
        }
        if (c1=='0' && c2=='0') {
            return true;
        }
        if (c1=='1' && c2=='1') {
            return true;
        }
        return false;
    }
    boolean test(char c) {
        if (c=='0' || c=='8' || c=='1') {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        _246_StrobogrammaticNumber s = new _246_StrobogrammaticNumber();
        s.isStrobogrammatic("69");
    }
}

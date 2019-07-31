package medium;

public class _91_Decode_Ways {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i < ways.length; i++) {
            int num = Integer.valueOf(s.substring(i - 2, i));
            if (num > 9 && num < 27) {
                ways[i] += ways[i - 2];
            }
            if (s.charAt(i - 1) != '0') {
                ways[i] += ways[i - 1];
            }
        }
        return ways[ways.length - 1];
    }

    public static void main(String[] args) {
        System.out.println("0123456789".substring(2 - 2, 2));
        _91_Decode_Ways s = new _91_Decode_Ways();
        s.numDecodings("12");
    }
}

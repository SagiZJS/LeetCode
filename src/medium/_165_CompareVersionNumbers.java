package medium;

public class _165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] ns1 = version1.split("\\.");
        String[] ns2 = version2.split("\\.");
        if (version1.length() == 0) {
            ns1 = new String[0];
        }
        if (version2.length() == 0) {
            ns2 = new String[0];
        }
        int i = 0;
        while (i < ns1.length && i < ns2.length) {
            int a = Integer.valueOf(ns1[i]);
            int b = Integer.valueOf(ns2[i]);
            if (a < b) {
                return -1;
            }
            if (a > b) {
                return 1;
            }
            i++;
        }
        int ai = i;
        while (i < ns1.length) {
            int a = Integer.valueOf(ns1[ai]);
            if (a> 0) {
                return 1;
            }
            ai++;
        }
        while (i < ns2.length) {
            int a = Integer.valueOf(ns2[i]);
            if (a> 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        _165_CompareVersionNumbers
        s = new _165_CompareVersionNumbers();
        s.compareVersion("", "1.1");
    }
}

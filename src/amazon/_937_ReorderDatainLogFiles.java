package amazon;

import java.util.Arrays;
import java.util.Comparator;

public class _937_ReorderDatainLogFiles {
    private boolean isLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c>='a' && c<='z' ) {
                return true;
            }
            if (c>='A' && c<='Z' ) {
                return true;
            }
        }
        return false;
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);
                boolean d1 = !isLetter(s1[1]);
                boolean d2 = !isLetter(s2[1]);
                if (d1 && d2) {
                    return 0;
                } else if (d1) {
                    return 1;
                } else if (d2) {
                    return -1;
                } else {
                    return s1[1].compareTo(s2[1]) == 0? s1[0].compareTo(s2[0]):s1[1].compareTo(s2[1]);
                }
            }
        });

        return logs;
    }
}

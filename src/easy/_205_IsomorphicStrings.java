package easy;

import java.util.Arrays;

public class _205_IsomorphicStrings {

    // A = 26 a = 0;
    public boolean isIsomorphic(String s, String t) {
        int[] sConvertTable = new int[1000];
        int[] tConvertTable = new int[1000];
        Arrays.fill(sConvertTable, -1);
        Arrays.fill(tConvertTable, -1);
        int countS = 0;
        int countT = 0;
        for (int i = 0; i < s.length(); i++) {
            int index1 = s.charAt(i) - 0;
            int index2 = t.charAt(i) - 0;
            if (sConvertTable[index1] == - 1) {
                sConvertTable[index1] = countS++;
                index1 = countS-1;
            } else {
                index1 = sConvertTable[index1];
            }
            if (tConvertTable[index2] == - 1) {
                tConvertTable[index2] = countT++;
                index2 =  countT-1;
            } else {
                index2 = tConvertTable[index2];
            }
            if (countT != countS) {
                return false;
            }
            if (index1 != index2) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    }
}



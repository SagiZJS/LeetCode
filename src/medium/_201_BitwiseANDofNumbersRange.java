package medium;

public class _201_BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m = m >>> 1;
            n = n >>> 1;
            count++;
        }
        m = m << count;
        return m;
    }
}

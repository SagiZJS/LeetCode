package easy;

public class _191_Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        if (n < 0) {
            n = n ^ 0x80000000;
            count++;
        }
        int origin;
        while (n != 0) {
            origin = n;
            if ((n >>> 1) << 1 != origin) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}

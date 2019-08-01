package medium;

public class _137_SingleNumberII {
    public int singleNumber(int[] nums) {
        long res = 0;
        long minusRes = 0;
        for (long i : nums) {
            if (i>0) {
                 res = threeBitXOR(res, i);
             } else {
                minusRes = threeBitXOR(minusRes, -i);
            }
        }
        if (res> 0) {
            return (int) res;
        } else {
            if (minusRes == Integer.MAX_VALUE + 1L) {
                return Integer.MIN_VALUE;
            }
            return (int) -minusRes;
        }
    }

    public long threeBitXOR(long a, long b) {
        long res = 0;
        long aDigit = 0;
        long bDigit = 0;
        long count = 1;
        if (a < b) {
            long temp = 0;
            temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            bDigit = b % 3;
            b = b / 3;
            aDigit = a % 3;
            a = a / 3;
            res += count*((aDigit + bDigit) % 3);
            count*=3;
        }
        while (a != 0) {
            res+= count*(a%3);
            count*=3;
            a/=3;
        }
        return res;
    }
    
    public static void main(String[] args) {
        _137_SingleNumberII s = new _137_SingleNumberII();
        int[] nums = {43,16,45,89,45,45,43,2147483647,89,89,2147483646,16,16,2147483646,43}
        ;
        System.out.println(s.singleNumber(nums));
    }
    
}

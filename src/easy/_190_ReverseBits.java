package easy;

public class _190_ReverseBits {
//    public int reverseBits(int n) {
//        char[] digits = new char[32];
//        for (int i = 0; i < 32;i++) {
//            digits[i] = '0';
//        }
//                
//        char[] tempChars = Integer.toBinaryString(n).toCharArray();
//        System.arraycopy(tempChars, 0, digits, 32 - tempChars.length, tempChars.length);
//        for (int i = 0; i < 16; i++) {
//            char temp = digits[i];
//            digits[i] = digits[31 - i];
//            digits[31-i] = temp;
//        }
//        
//        if (digits[0] != '1') {
//            return Integer.valueOf(new String(digits).substring(1), 2);
//        } else {
//            int add = Integer.valueOf(new String(digits).substring(1), 2);
//            return Integer.MIN_VALUE + add;
//        }
//    }
    public int reverseBits(int n) {
        int lp = 0X80000000;
        int rp = 0X00000001;
        int count = 0;
        int ret = 0X00000000;
        while(count < 16){
            int step = 31 - count * 2;
            int l = (lp & n) >>> step;
            int r = (rp & n) << step;
            ret |=  l | r;
            lp >>>= 1;
            rp <<= 1;
            count++;
        }
        return ret;
    }


    public static void main(String[] args) {
        _190_ReverseBits s = new _190_ReverseBits();
        System.out.println(s.reverseBits(-3));
        
        System.out.println((-1 ^ 0x40000000)<<1);
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println("11111111111111111111111111111111".length());
//        System.out.println(Integer.valueOf("11111", 2));
    }
}

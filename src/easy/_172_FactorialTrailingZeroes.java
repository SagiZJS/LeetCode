package easy;

public class _172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        int divider = 5;
        while (n >= divider) {
            result += n / divider;
            n = n/5;
        }
        
        return result;
    }
}

package easy;

public class _202_HappyNumber {
    public boolean isHappy(int n) {
        boolean[] hashTable = new boolean[2500];
        while (true) {
            n = computeSumDigitSquare(n);
            if (n == 1) {
                return true;
            }
            if (hashTable[n] == true) {
                return false;
            }
            hashTable[n] = true;
        }
    }
    
    public int computeSumDigitSquare(int n) {
        int result = 0;
        while (n > 0) {
            result += ((n%10)*(n%10));
            n = n/10;
        }
        return result;
    }
    
    public static void main(String[] args) {
        _202_HappyNumber
        s = new _202_HappyNumber();
        s.isHappy(19);
    }
}

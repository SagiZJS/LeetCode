package easy;

public class _171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int digit = c - 'A' + 1;
            result += (digit * base);
            base *= 26;
        }
        return result;
    }
    
    public void flipBetween(char[] chars,int start, int end) {
        char temp = ' ';
        while (start < end) {
            temp = chars[start];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
    }
}

package easy;


public class _168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuilder output = new StringBuilder();
        char c = '1';
        int divider = 26;
        while (n > 0) {
            int res = n % divider;
            n = n/divider;
            if (res == 0) {
                c = 'Z';
                n--;
            } else {
                c = (char) ('A' + res - 1);
            }
            output.insert(0,c);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _168_Excel_Sheet_Column_Title t = new _168_Excel_Sheet_Column_Title();
        System.out.println(t.convertToTitle(52));
    }

}

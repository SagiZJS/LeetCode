package medium;

public class _227_BasicCalculatorII {
    public int calculate(String s) {
        
        char[] ss = s.replace(" ", "").toCharArray();;
        int[] numstack = new int[s.length()];
        int np = 0;
        boolean[] ops = new boolean[s.length()];
        int op = 0;
        int lastop = 0;
        int num = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] >= '0' && ss[i] <= '9') {
                num *= 10;
                num += ss[i] - '0';
            } else {
                if (lastop == 1) {
                    int lastNum = numstack[--np];
                    numstack[np++] = lastNum * num;
                    num = 0;
                    lastop = 0;
                } else if (lastop == -1) {
                    int lastNum = numstack[--np];
                    numstack[np++] = lastNum / num;
                    num = 0;
                    lastop = 0;
                } else {
                    numstack[np++] = num;
                    num = 0;
                }
                if (ss[i] == '+') {
                    ops[op++] = true;
                } else if (ss[i] == '-') {
                    ops[op++] = false;
                } else if (ss[i] == '*') {
                    lastop = 1;
                } else if (ss[i] == '/') {
                    lastop = -1;
                }
            }
        }
        if (lastop == 1) {
            int lastNum = numstack[--np];
            num = num * lastNum;
        } else if (lastop == -1) {
            int lastNum = numstack[--np];
            num =  lastNum / num;
        }
        numstack[np++] = num;
        int sum = 0;
        while (np > 1) {
            if (ops[--op]) {
                sum += numstack[--np];
            } else {
                sum -= numstack[--np];
            }
        }
        return sum + numstack[--np];
    }

    public static void main(String[] args) {
        _227_BasicCalculatorII s = new _227_BasicCalculatorII();
        s.calculate("3 /2");

    }
}

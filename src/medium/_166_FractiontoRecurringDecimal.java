package medium;

import java.util.HashMap;

public class _166_FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (numerator > 0 && denominator > 0) {
            return helper(numerator, denominator);
        } 
        if (numerator > 0 && denominator < 0) {
            return "-"+helper(numerator, -(long)denominator);
        } 
        if (numerator < 0 && denominator < 0) {
            return helper(-(long)numerator, -(long)denominator);
        } 
        if (numerator < 0 && denominator > 0) {
            return "-"+helper(-(long)numerator, denominator);
        } 
        return null;
    }

    public String helper(long numerator, long denominator) {
        StringBuilder res = new StringBuilder();
        res.append(numerator / denominator);
        numerator = numerator % denominator;
        HashMap<Long, Integer> map = new HashMap<>();
        if (numerator != 0) {
            res.append('.');
        }
        int count = res.length();
        while (numerator != 0) {
            if (!map.containsKey(numerator)) {
                map.put(numerator, count);
                numerator *= 10;
                long digit = numerator / denominator;
                numerator = numerator % denominator;
                res.append(digit);
                count++;
            } else {
                res.insert((int) map.get(numerator), '(');
                res.append(')');
                return res.toString();
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        _166_FractiontoRecurringDecimal s = new _166_FractiontoRecurringDecimal();
        System.out.println(s.fractionToDecimal(-1,
                -2147483648));
    }
}

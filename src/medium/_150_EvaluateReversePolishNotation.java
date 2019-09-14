package medium;

import java.util.Arrays;

public class _150_EvaluateReversePolishNotation {
//    public int evalRPN(String[] tokens) {
//        if (tokens.length == 0) {
//            return 0;
//        }
//        if (tokens.length == 1) {
//            return Integer.valueOf(tokens[0]);
//        }
//        int i = 0;
//        int a = 0;
//        int b = 0;
//        char op = ' ';
//        int result = 0;
//        while (true) {
//            i = tokens.length - 1;
//            while (isOp(tokens[i]) != 1 ) {
//                i--;
//                if (i == 1) {
//                     return result;
//                }
//            }
//            op = tokens[i].charAt(0);
//            int ai = i-1;
//            while (isOp(tokens[ai]) == -1) {
//                ai--;
//            }
//            if (isOp(tokens[ai]) == 1) {
//                continue;
//            }
//            a = Integer.valueOf(tokens[i-2]);
//            b = Integer.valueOf(tokens[i-1]);
//            Integer res = 0;
//            if (op == '+') {
//                res = a + b;
//            }
//            if (op == '-') {
//                res = a - b;
//            }
//            if (op == '*') {
//                res = a * b;
//            }
//            if (op == '/') {
//                res = a / b;
//            }
//            result = res;
//            tokens[i] = res.toString();
//            tokens[i - 1] = null;
//            tokens[i - 2] = null; 
//        }
//
//    }

//    public boolean isOperatable(String[] strs, int i) {
//        if (isOp(strs[i]) != -1) {
//            return false;
//        }
//        while (isOp(strs[i]) == -1) {
//            
//        }
//    }
//    
//    public int isOp(String s) {
//        if (s == null) {
//            return -1;
//        }
//        if (s.length() != 1) {
//            return 0;
//        }
//        if (s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 9) {
//            return 0;
//        }
//        return 1;
//    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1) { 
            return Integer.valueOf(tokens[0]);
        }
        return Integer.valueOf(twoRPN(tokens, tokens.length - 1)[0]);
    }

    public String[] twoRPN(String[] tokens, int p) {
        char operator = tokens[p].charAt(0);
        tokens[p] = null;
        p--;
        int a = 0;
        int b = 0;
        try {
            a = Integer.valueOf(tokens[p]);
            p--;
        } catch (Exception e) {
            tokens = twoRPN(tokens, p);
            a = Integer.valueOf(tokens[tokens.length - 1]);
            p = tokens.length - 2;
        }
        try {
            b = Integer.valueOf(tokens[p]);
            p--;
        } catch (Exception e) {
            tokens = twoRPN(tokens, p);
            b = Integer.valueOf(tokens[tokens.length - 1]);
            p = tokens.length - 2;
        }
        Integer res = 0;
        if (operator == '+') {
            res = a + b;
        }
        if (operator == '-') {
            res = b - a;
        }
        if (operator == '*') {
            res = a * b;
        }
        if (operator == '/') {
            res = b / a;
        }

        tokens[++p] = res.toString();
        return Arrays.copyOf(tokens, p+1);
    }
    public static void main(String[] args) {
        _150_EvaluateReversePolishNotation s = new _150_EvaluateReversePolishNotation();
        String[] tokens = 
            { "4", "13", "5", "/", "+" }
//            {"2","1","+","3","*"}
        ;
        System.out.println(s.evalRPN(tokens));
    }

}

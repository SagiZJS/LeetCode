package medium;

import java.util.ArrayList;
import java.util.List;

public class _241_DifferentWaystoAddParenthese {
    private static class LinkedVal{
        int val;
        LinkedVal next;
        public LinkedVal(int val) {
            this.val = val;
        }
        
    }
    public List<Integer> diffWaysToCompute(String input) {
        int[] nums = new int[input.length()];
        int np = 0;
        char[] ops = new char[input.length()];
        int op = 0;
        int num = 0;
        for (char temp : input.toCharArray()) {
            if (isDigit(temp)) {
                num *= 10;
                num += temp - '0';
            } else {
                nums[np++] = num;
                num = 0;
                ops[op++] = temp;
            }
        }
        nums[np++] = num;
        
        LinkedVal[][] DPM = new LinkedVal[np][np];
        for (int i = 0; i < DPM.length - 1; i++) {
            DPM[i][i] = new LinkedVal(nums[i]);
            DPM[i][i + 1] = new LinkedVal(compute(nums[i], nums[i+1], ops[i]));
        }
        DPM[DPM.length - 1][DPM.length - 1] = new LinkedVal(nums[np - 1]);
        
        for (int len = 3; len <= np; len++) {
            for (int i = 0; i + len - 1 <np; i++) {
                int j = i + len - 1;
                for (int mid = i;  mid < j; mid++) {
                    LinkedVal left = DPM[i][mid];
                    LinkedVal right = DPM[mid+1][j];
                    LinkedVal temp;
                    while (left != null) {
                        right = DPM[mid+1][j];
                        while (right != null) {
                            temp = new LinkedVal(compute(left.val, right.val, ops[mid]));
                            temp.next = DPM[i][j];
                            DPM[i][j] = temp;
                            right = right.next;
                        }
                        left = left.next;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        LinkedVal res = DPM[0][np-1];
        while (res!=null) {
            result.add(res.val);
            res = res.next;
        }
        return result;
    }
    private boolean isDigit(char temp) {
        if (temp >= '0' && temp <='9') {
            return true; 
        } else {
            return false;
        }
    }
    private int compute(int a, int b, char op) {
        switch (op) {
        case '+':
            return a+b;
        case '-':
            return a-b;
        case '*':
            return a*b;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        _241_DifferentWaystoAddParenthese s= new _241_DifferentWaystoAddParenthese();
        s.diffWaysToCompute("2*3-4*5");
    }
}

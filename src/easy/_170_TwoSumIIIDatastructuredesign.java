package easy;

import java.util.ArrayList;
import java.util.List;

public class _170_TwoSumIIIDatastructuredesign {

    List<Integer> nums = new ArrayList<>();

    public _170_TwoSumIIIDatastructuredesign() {
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        nums.sort((num1, num2) -> {
            return num1 - num2;
        });
        Integer[] numsArr = nums.toArray(new Integer[0]);
        int i = 0;
        int j = numsArr.length - 1;
        while (i < j) {
            int sum = numsArr[i] + numsArr[j];
            if (sum == value) {
                return true;
            } else if (sum < value) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _170_TwoSumIIIDatastructuredesign s = new _170_TwoSumIIIDatastructuredesign();
        s.add(1);
        s.add(3);
        s.add(5);
        s.find(4);
        s.find(7);
    }
}

package jishun.utils.sort;

import java.util.Arrays;

public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = nums.length - 1;
        int end = start;
        while (true) {
            end--;
            if (end == -1)
                break;
            if (nums[end] < nums[end + 1]) {
                int min = nums[end];
                int minindex = start;
                for (int i = end + 1; i <= start; i++) {
                    if (nums[i] <= min) {
                        min = nums[end + 1];
                        minindex = i - 1;
                        int temp = nums[end];
                        nums[end] = nums[minindex];
                        nums[minindex] = temp;
                        break;
                    }
                    if (i == start) {
                        int temp = nums[end];
                        nums[end] = nums[minindex];
                        nums[minindex] = temp;
                    }
                }

                break;
            }
        }
        int len = start - end;
        for (int i = 0;i < len / 2;i++) {
            int temp = nums[end + 1 + i];
            nums[end + 1 + i] = nums[start - i];
            nums[start - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] testcase = new int[] { 1,2,5,4,3,2,1 };
        _31_NextPermutation s = new _31_NextPermutation();
        s.nextPermutation(testcase);
        System.out.println(Arrays.toString(testcase));
    }
}

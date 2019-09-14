package medium;

import java.util.Arrays;

public class _179_LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, (n1, n2) -> {
            return -compare(n1, n2);
        });
        int index = 0;
        StringBuilder output = new StringBuilder();
        while (index < numbers.length) {
            output.append(numbers[index++]);
        }
        while (output.length() > 1 && output.charAt(0) == '0') {
            output.deleteCharAt(0);
        }
        return output.toString();
    }

    public static int compare(int n1, int n2) {
        String s1 = Integer.toString(n1);
        String s2 = Integer.toString(n2);

        return (s1 + s2).compareTo(s2 + s1);
    }

    public static void main(String[] args) {
        _179_LargestNumber s = new _179_LargestNumber();
        int[] nums = { 3, 30, 34, 5, 9, 30, 300 };
        System.out.println(s.largestNumber(nums));
    }
}

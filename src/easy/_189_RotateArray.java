package easy;

public class _189_RotateArray {

    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        flipBetween(nums, 0, nums.length - 1);
        flipBetween(nums, 0, k - 1);
        flipBetween(nums, k, nums.length - 1);
    }

    public void flipBetween(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

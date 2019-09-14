package medium;

public class _153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[0] < nums[nums.length - 1] || nums.length == 1) {
            return nums[0];
        }
        while (true) {
            int middle = (low + high) / 2;
            if (nums[middle] > nums[0]) {
                low = middle;
            }
            if (nums[middle] < nums[nums.length - 1]) {
                high = middle;
            }
            if (low + 1 == high) {
                return nums[high];
            }
        }
    }
}

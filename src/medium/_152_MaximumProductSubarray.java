package medium;

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i],
                    Math.max(nums[i] * min[i - 1], nums[i] * max[i - 1]));
            min[i] = Math.min(nums[i],
                     Math.min(nums[i] * min[i - 1], nums[i] * max[i - 1]));
            if (res < max[i]) {
                res = max[i];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        _152_MaximumProductSubarray s = new _152_MaximumProductSubarray();
        int[] nums = { 2, 3, -2,4 };
        s.maxProduct(nums);
    }
}

package easy;

public class _198_HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
            
        int[] DPMatirx = new int[nums.length];
        DPMatirx[0] = nums[0];
        DPMatirx[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for (int i = 2; i < DPMatirx.length; i++) {
            int planA = nums[i] + DPMatirx[i - 2];
            int planB = DPMatirx[i - 1];
            if (planA> planB) {
                DPMatirx[i] = planA;
            } else {
                DPMatirx[i] = planB;
            }
        }
        return DPMatirx[nums.length - 1];
    }

}

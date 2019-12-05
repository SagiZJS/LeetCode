package amazon;

public class _45JumpGameII {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] steps = new int[nums.length];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = -1;
        }
        steps[0] = 0;
        int step = 0;
        int i = 0;
        while (i < nums.length) {
            int maxstep = 0;
            while (i < nums.length && steps[i] == step) {
                maxstep = maxstep > i + nums[i] ? maxstep : i + nums[i];
                i++;
            }
            step++;
            int index = i;
            while (index < nums.length && index <= maxstep ) {
                if (index < nums.length) {
                    steps[index] = step;
                }
                index++;
            }
        }
        return steps[steps.length - 1];
    }

    public static void main(String[] args) {
        _45JumpGameII s = new _45JumpGameII();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(s.jump(nums));
    }
}

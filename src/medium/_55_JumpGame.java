package medium;

public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        int[] stack = new int[nums.length];
        int p = 0;
        stack[p++] = 0;
        reachable[0] = true;
        while (p > 0) {
            int num = stack[--p];
            for (int i = 1; i <= nums[num]; i++) {
                if (num + i < nums.length && !reachable[num + i]) {
                    if (num + i == nums.length - 1) {
                        return true;
                    }
                    reachable[num + i] = true;
                    stack[p++] = num + i;
                }
            }
        }
        return false;
    }
}

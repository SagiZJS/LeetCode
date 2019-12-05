package amazon;

public class _456_132Pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        int[] stack = new int[nums.length];
        int p = 0;

        int[] mins = new int[nums.length];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = min > nums[i - 1] ? nums[i - 1] : min;
            mins[i] = min;
            // System.out.println(min+":"+nums[i]);
        }
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > mins[j]) {
                Integer num = null;
                while (p > 0 && (num = stack[--p]) <= mins[j]) {
                }
                if (num != null) {
                    if (num > mins[j]) {
                        if (num < nums[j]) {
                            // System.out.println(num+":"+nums[j]);
                            return true;
                        } else {
                            stack[p++] = num;
                        }
                    }
                }
                stack[p++] = nums[j];
            }
        }
        return false;
    }
}
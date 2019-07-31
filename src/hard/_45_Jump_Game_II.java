package hard;

public class _45_Jump_Game_II {


    public int jump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        int[] steps =new int[nums.length];
        int[] queue = new int[nums.length];
        int tail = 0;
        int head = 0;
        queue[tail++] = 0;
        reachable[0] = true;
        while (tail - head > 0) {
            int num = queue[head++];
            for (int i = 1; i <= nums[num]; i++) {
                if (num + i < nums.length && !reachable[num + i]) {
                    reachable[num + i] = true;
                    steps[num + i] = steps[num]+1;
                    queue[tail++] = num + i;
                }
            }
        }
        return steps[steps.length - 1];
    }
    
    public static void main(String[] args) {
        _45_Jump_Game_II s = new _45_Jump_Game_II();
        int[] nums = {1,2,1,1,1};
        System.out.println(s.jump(nums));
    }
}

package medium;

public class _209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int count = 0;
        int sum = 0;
        int i = 0;
        int start = 0;
        while (i < nums.length) {
            if (count == 0) {
                sum += nums[i];
                if (sum >= s) {
                    count = i + 1;
                    start = 0;
                    sum -= nums[start++];
                    if (count == 1) return 1;
                    while (sum >= s) {
                        count--;
                        sum-=nums[start++];
                        if (count == 1) return 1;
                    }
                    i++;
                    break;
                }
            }
            i++;
        }
        while (i < nums.length) {
            sum+=nums[i];
            sum-=nums[start];
            while (sum >= s) {
                count--;
                sum-=nums[++start];
                if (count == 1) return 1;
            }
            start++;
            i++;
        }
        return count;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int res = devideAndConquer(s, nums, 0, nums.length - 1);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int devideAndConquer(int s, int[] nums, int start, int end) {
        if (end - start == -1)
            return Integer.MAX_VALUE;
        if (end - start == 0)
            return s > nums[start] ? Integer.MAX_VALUE : 1;
        int midl = start + (end - start) / 2;
        int midr = midl + 1;
        int count = 2;
        int sum = nums[midl] + nums[midr];
        int min = Math.min(devideAndConquer(s, nums, start, midl), devideAndConquer(s, nums, midr, end));
        outer: while (count < min) {
            if (sum >= s) {
                min = count;
                break;
            }
            count++;
            for (int i = 0; midl - i >= start; i++) {
                sum = 0;
                for (int j = 0; j < count; j++) {
                    if (midl - i + j > end)
                        break;
                    sum += nums[midl - i + j];
                    if (sum >= s) {
                        min = count;
                        break outer;
                    }
                }
            }
            if (count > end - start + 1) {
                return Integer.MAX_VALUE;
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        213
//        [12,28,83,4,25,26,25,2,25,25,25,12]
        int[] nums = new int[] { 2,3,1,2,4,3 };
        int s = 7;
        _209_MinimumSizeSubarraySum t = new _209_MinimumSizeSubarraySum();

        System.out.println(t.minSubArrayLen(s, nums));
    }
}

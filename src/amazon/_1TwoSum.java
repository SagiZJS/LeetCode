package amazon;

import java.util.Arrays;

public class _1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[] {-1,-1};
         int start = 0;
         int end = nums.length - 1;
         int sum = 0;
         int[] mapping = new int[nums.length];
         System.arraycopy(nums, 0, mapping, 0, nums.length);
         Arrays.sort(nums);
         while ((sum = nums[start] + nums[end]) != target) {
             if (sum > target) {
                 end--;
             } else {
                 start++;
             }
         }

         for (int i = 0; i < mapping.length; i++) {
             if (mapping[i] == nums[start]&& res[0]== -1) {
                 res[0] = i;
             }
             if (mapping[i] == nums[end] && i != res[0] && res[1] == -1) {
                 
                 res[1] = i;
             }
         }

         return res;
     }
}

package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end]; 
                if (sum > -nums[i]) {
                    end--;
                    while (end >i && nums[end+1]==nums[end]) {
                        end--;
                    }
                } else if (sum < -nums[i]) {
                    start++;
                    while (start < nums.length && nums[start-1]==nums[start]) {
                        start++;
                    }
                } else {
                    List<Integer> newitem = new ArrayList<>();
                    newitem.add(nums[i]);
                    newitem.add(nums[start]);
                    newitem.add(nums[end]);
                    ret.add(newitem);
                    start++;
                    end--;
                    while (start < nums.length && nums[start-1]==nums[start]) {
                        start++;
                    }
                    while (end >i && nums[end+1]==nums[end]) {
                        end--;
                    }
                }
            }
        }

        return ret;
    }
}

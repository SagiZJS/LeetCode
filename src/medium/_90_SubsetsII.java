package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        result.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            used[i] = true;
            recursion(nums, result, temp, i, used);
            used[i] = false;
        }
        return result;
    }

    public void recursion(int[] nums, List<List<Integer>> result, List<Integer> temp, int index, boolean[] used) {
        temp.add(nums[index]);
        result.add(new ArrayList<>(temp));
        for (int i = index + 1; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            used[i] = true;
            recursion(nums, result, temp, i, used);
            used[i] = false;
        }
        temp.remove(temp.size() - 1);
    }
}

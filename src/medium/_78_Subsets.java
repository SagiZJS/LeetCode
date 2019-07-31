package medium;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        result.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            recursion(nums, result, temp, i);
        }
        return result;
    }

    public void recursion(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        temp.add(nums[index]);
        result.add(new ArrayList<>(temp));
        for (int i = index + 1; i<nums.length; i++) {
            recursion(nums, result, temp, i);
        }
        temp.remove(temp.size() - 1);
    }
}

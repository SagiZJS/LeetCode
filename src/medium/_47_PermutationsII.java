package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        recursionVisit(result, new ArrayList<>(), visited, nums);
        return result;
    }

    public void recursionVisit(List<List<Integer>> result, List<Integer> list, int[] visited, int[] nums
            ) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                int j = i;
                while (j >= 0 && nums[j] == nums[i]) {
                    visited[j] ++;
                    j--;
                }
                list.add(nums[i]);
                recursionVisit(result, list, visited, nums);
                list.remove(list.size() - 1);
                j = i;
                while (j >= 0 && nums[j] == nums[i]) {
                    visited[j] --;
                    j--;
                }
            }
        }
    }
}

package medium;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; 
        recursionVisit(result, new ArrayList<>(), visited, nums);
        return result;
    }
    
    public void recursionVisit(List<List<Integer>> result, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                recursionVisit(result, list, visited, nums);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

}

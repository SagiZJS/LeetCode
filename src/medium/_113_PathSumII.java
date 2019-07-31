package medium;

import java.util.ArrayList;
import java.util.List;

public class _113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> nums = new ArrayList<>();
        
        recursionFindPath(result, nums, root, sum - root.val);
        return result;
    }

    public void recursionFindPath(List<List<Integer>> result, List<Integer> nums, TreeNode root, int sum) {
        nums.add(root.val);
        if (sum == 0) {
            if (root.left == null && root.right == null) {
                result.add(new ArrayList<>(nums));
            }
        }
        if (root.left != null) {
            recursionFindPath(result, nums, root.left, sum - root.left.val);
        }
        if (root.right != null) {
            recursionFindPath(result, nums, root.right, sum - root.right.val);
        }
        nums.remove(nums.size() - 1);
    }
}

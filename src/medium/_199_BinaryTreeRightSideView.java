package medium;

import java.util.ArrayList;
import java.util.List;

public class _199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        recursion(root, 1, result);
        return result;
    }
    
    public void recursion(TreeNode root, int depth, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() < depth) {
            result.add(root.val);
        }
        recursion(root.right, depth + 1, result);
        recursion(root.left, depth + 1, result);
    }
}

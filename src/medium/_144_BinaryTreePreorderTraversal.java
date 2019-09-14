package medium;

import java.util.ArrayList;
import java.util.List;

public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        recursion(res, root);
        return res;
    }
    
    public void recursion(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        recursion(res, root.left);
        recursion(res, root.right);
    }
}

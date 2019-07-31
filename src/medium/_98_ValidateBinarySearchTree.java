package medium;

public class _98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean recursion(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        boolean flag = false;
        if (root.val <right && root.val>left) {
            flag = true;
        }
        if (flag) {
            return recursion(root.left, left, root.val) && recursion(root.right, root.val, right);
        }
        return flag;
    }
}

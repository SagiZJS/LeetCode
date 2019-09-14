package easy;

public class _226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        recursionInvert(root);
        return root;
    }
    private void recursionInvert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recursionInvert(root.left);
        recursionInvert(root.right);
    }
}

package medium;

public class _156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] stack = new TreeNode[200];
        int p = 0;
        TreeNode current = root;
        while (current.left != null) {
            stack[p++] = current;
            current = current.left;
        }
        TreeNode parent = null;
        root = current;
        while (p>0) {
            parent = stack[--p];
            current.left = parent.right;
            current.right = parent;
            current = parent;
        }
        current.right = null;
        current.left = null;
        return root;
        
    }
    
}

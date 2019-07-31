package medium;


public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return recursionBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode recursionBuildTree(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootIndex = istart;
        while (inorder[rootIndex] != preorder[pstart]) {
            rootIndex++;
        }

        if (rootIndex - istart > 0) {
            root.left = recursionBuildTree(preorder, inorder, pstart + 1, pstart + rootIndex - istart, istart,
                    rootIndex - 1);
        }

        if (iend - rootIndex > 0) {
            root.right = recursionBuildTree(preorder, inorder, pstart + rootIndex - istart + 1, pend, rootIndex + 1,
                    iend);
        }

        return root;
    }
}

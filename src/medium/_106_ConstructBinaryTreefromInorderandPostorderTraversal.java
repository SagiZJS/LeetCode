package medium;

public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return recursionBuildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode recursionBuildTree(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend) {
        int num = postorder[pend];
        TreeNode root = new TreeNode(num);
        int rootIndex = istart;
        while (inorder[rootIndex] != num) {
            rootIndex++;
        }

        if (rootIndex - istart > 0) {
            root.left = recursionBuildTree(inorder,postorder,  istart,
                    rootIndex - 1,pstart, pstart + rootIndex - istart - 1);
        }

        if (iend - rootIndex > 0) {
            root.right = recursionBuildTree(inorder,postorder,  rootIndex + 1,
                    iend,pstart + rootIndex - istart, pend-1);
        }

        return root;
    }
}

package medium;

public class _114_FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        TreeNode[] stack = new TreeNode[200];
        int p = 0;
        TreeNode currentLinkNode = null;
        TreeNode temp = null;
        stack[p++] = root;
        while (p > 0) {
            temp = stack[--p];
            if (currentLinkNode!=null) {
                currentLinkNode.right = temp;
            }
            currentLinkNode = temp;
            if (temp.right != null) {
                stack[p++] = temp.right;
                if (p == stack.length) {
                    stack = stackExpand(stack);
                }
                temp.right = null;
            }
            if (temp.left != null) {
                stack[p++] = temp.left;
                if (p == stack.length) {
                    stack = stackExpand(stack);
                }
                temp.left = null;
            }
        }
    }

    public TreeNode[] stackExpand(TreeNode[] stack) {
        TreeNode[] newStack = new TreeNode[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        return newStack;
    }

}

package medium;

public class _222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return recursionCount(root);
    }
    public int recursionCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rightDepth = countRightDepth(root);
        int leftDepth = countLeftDepth(root);
        if (rightDepth == leftDepth) {
            return (2<<rightDepth) - 1;
        }
        else {
            return 1 + recursionCount(root.right) + recursionCount(root.left);
        }
    }
    private int countRightDepth(TreeNode root) {
        int count = -1;
        while (root!=null) {
            count++;
            root = root.right;
        }
        return count;
    }
    private int countLeftDepth(TreeNode root) {
        int count = -1;
        while (root!=null) {
            count++;
            root = root.left;
        }
        return count;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        _222_CountCompleteTreeNodes s = new _222_CountCompleteTreeNodes();
        System.out.println(s.countNodes(root));
        
    }
}
